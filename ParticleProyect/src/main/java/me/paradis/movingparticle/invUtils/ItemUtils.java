package me.paradis.movingparticle.invUtils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {

    public static ItemStack createItem(Material material, String name, int data) {
        ItemStack item = new ItemStack(material, 1, (short) data);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack createItem(Material material, String name) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack setName(ItemStack item, String name) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack setLore(ItemStack item, String lore) {
        ItemMeta itemMeta = item.getItemMeta();

        List<String> lored = new ArrayList<String>();
        lored.add(lore);
        itemMeta.setLore(lored);

        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack addToLore(ItemStack item, String lore) {
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lored = new ArrayList<String>();
        if (itemMeta.getLore() != null) {
            lored = itemMeta.getLore();
        }
        lored.add(lore);
        itemMeta.setLore(lored);

        item.setItemMeta(itemMeta);
        return item;
    }
}
