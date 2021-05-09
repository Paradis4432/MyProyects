package me.paradis.main.GUI;

import me.paradis.main.utils.CreateItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OpenBasicGui {

    public void open(Player player){
        Inventory choose = Bukkit.createInventory(null, 9, "Choose what to delete");

        ItemStack location = createItem(Material.COMPASS, "Select to delete a location");
        ItemStack item = createItem(Material.CHEST , "Select to delete an item");

        choose.setItem(2,location);
        choose.setItem(6,item);

        player.openInventory(choose);
    }

    public ItemStack createItem(final Material material, final String name, final String... lore){
        return new CreateItems().create(material,name,lore);
    }
}
