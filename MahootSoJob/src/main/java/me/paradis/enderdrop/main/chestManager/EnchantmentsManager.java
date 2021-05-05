package me.paradis.enderdrop.main.chestManager;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Bukkit.getServer;

public class EnchantmentsManager {


    public void addItemEnchants(int currentTier, int items, ItemStack finalItem, ItemMeta finalItemMeta) {
        System.out.println("test10 addItemEnchants called with currentTier: " + currentTier);
        System.out.println("test10.1 itemStack:" + finalItem);
        System.out.println("test10.2 itemMeta: " + finalItemMeta);
        try{
            for(String enchant : Main.get().getConfig().getStringList("tiers." + currentTier + ".items." + items + ".enchants")){
                //splits the information
                Enchantment enchantName = Enchantment.getByName(enchant.split(":")[0]);
                int enchantLevel = Integer.parseInt(enchant.split(":")[1]);

                //adds the enchantments to the itemMeta
                if(enchantName != null){
                    finalItemMeta.addEnchant(enchantName, enchantLevel, true);
                }

            }
            //add the meta to the item
            finalItem.setItemMeta(finalItemMeta);
            //add the item to the inv
            System.out.println("test10.3 finalItem: " + finalItem + " with meta: " + finalItemMeta);
            inv.addItem(finalItem);
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage("no enchantments found in config file");
        }
    }
}
