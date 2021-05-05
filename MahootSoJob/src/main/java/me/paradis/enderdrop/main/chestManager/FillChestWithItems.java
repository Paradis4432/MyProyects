package me.paradis.enderdrop.main.chestManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class FillChestWithItems {
    public Inventory inv = placeChest();
    public void fillChest() {
        if (inv == null) return;
        //fills the chest with the items in the config yml


        //loops the amount of tiers
        //getTierSpawning gets the tier that spawns
        //getAmountOfItemsOnTier gets the amount of items on the current tier
        int totalItems = getAmountOfItemsOnTier();
        int currentTier = getTierSpawning();
        for (int items = 1; items <= totalItems; items++) {
            System.out.println("test12 fillChest Called with items: " + items);
            System.out.println("test12.1 totalItems: " + totalItems);
            System.out.println("test12.2 currentTier: " + currentTier);
            //loops the amount of items on current tier
            //gets the type of the item in the config file using current tier and the amount of items
            String material = Main.get().getConfig().getString("tiers." + currentTier + ".items." + items + ".type");
            System.out.println("test12.3 material: " + material);
            Material mat = null;
            try {
                //gets the material of the item
                mat = Material.valueOf(Objects.requireNonNull(material).toUpperCase().replace(" ", "_"));
                System.out.println("test12.4 mat: " + mat);

            } catch (Exception e) {
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "Fatal Error: Item Type Not Found");
            }
            //add lore and enchants and change the material to item stack
            if (mat == null) {
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "Fatal Error: Item Not Found");
            } else {
                Integer amount = getItemAmount(currentTier, items);
                if (amount == null) amount = 1;
                System.out.println("test12.5 amount: " + amount);
                ItemStack finalItem = new ItemStack(mat, amount);
                ItemMeta finalItemMeta = finalItem.getItemMeta();
                //gets the name of the item in the config file

                String finalItemName = getItemName(currentTier, items);
                if (finalItemName != null) {
                    finalItemMeta.setDisplayName(finalItemName);
                }

                //gets the lore of the item in the config file

                List<?> finalItemLore = getItemLore(currentTier, items);

                if (finalItemLore != null) {
                    finalItemMeta.setLore((List<String>) finalItemLore);
                }

                //gets the enchants of the item in the config file

                try {
                    addItemEnchants(currentTier, items, finalItem, finalItemMeta);
                } catch (Exception e) {
                    getServer().getConsoleSender().sendMessage(ChatColor.RED + "Fatal Error: Enchantments Not Found");
                }
            }
        }
        Main.get().getConfig().set("admin.DoNotEdit.newChestSpawning", true);
        Main.get().saveConfig();
    }
}
