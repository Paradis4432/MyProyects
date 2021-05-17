package me.paradis.main.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CreateItems {

    public ItemStack create(final Material material, final String name, final String... lore) {
        //creates the item to be added
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        //sets the meta
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }
}
