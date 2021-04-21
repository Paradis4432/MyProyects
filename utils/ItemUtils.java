package me.paradis.coinflip.main.utils;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {

    public static Material[] tool = {Material.DIAMOND_PICKAXE, Material.DIAMOND_AXE, Material.LEGACY_DIAMOND_SPADE, Material.DIAMOND_HOE,
            Material.IRON_PICKAXE, Material.IRON_AXE, Material.LEGACY_IRON_SPADE, Material.IRON_HOE,
            Material.GOLDEN_PICKAXE, Material.GOLDEN_AXE, Material.LEGACY_GOLD_SPADE, Material.GOLDEN_HOE,
            Material.STONE_PICKAXE, Material.STONE_AXE, Material.LEGACY_STONE_SPADE, Material.STONE_HOE,
            Material.WOODEN_PICKAXE, Material.WOODEN_AXE, Material.LEGACY_WOOD_SPADE, Material.WOODEN_HOE};
    public static  Material[] sword = {Material.DIAMOND_SWORD, Material.IRON_SWORD, Material.GOLDEN_SWORD, Material.STONE_SWORD, Material.WOODEN_SWORD};
    public static Material[] armor = {Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS,
            Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS,
            Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS,
            Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS,
            Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS};
    public static Material[] boots = {Material.DIAMOND_BOOTS, Material.CHAINMAIL_BOOTS, Material.GOLDEN_BOOTS, Material.IRON_BOOTS, Material.LEATHER_BOOTS};

    public static Material[] pickaxe = {Material.DIAMOND_PICKAXE, Material.GOLDEN_PICKAXE, Material.IRON_PICKAXE, Material.STONE_PICKAXE, Material.WOODEN_PICKAXE};
    public static Material[] axe = {Material.DIAMOND_AXE, Material.GOLDEN_AXE, Material.IRON_AXE, Material.STONE_AXE, Material.WOODEN_AXE};
    public static Material[] spade = {Material.LEGACY_DIAMOND_SPADE, Material.LEGACY_GOLD_SPADE, Material.LEGACY_IRON_SPADE, Material.LEGACY_STONE_SPADE, Material.LEGACY_WOOD_SPADE};
    public static Material[] hoe = {Material.DIAMOND_HOE, Material.GOLDEN_HOE, Material.IRON_HOE, Material.STONE_HOE, Material.WOODEN_HOE};


    public static boolean isTool(ItemStack i){
        for (Material m : tool){
            if (m.equals(i.getType()))return true;
        }
        return false;
    }
    public static boolean isSword(ItemStack i){
        for (Material m : sword){
            if (m.equals(i.getType()))return true;
        }
        return false;
    }
    public static boolean isArmor(ItemStack i){
        for (Material m : armor){
            if (m.equals(i.getType()))return true;
        }
        return false;
    }
    public static boolean isBoots(ItemStack i){
        for (Material m : boots){
            if (m.equals(i.getType()))return true;
        }
        return false;
    }

    public static boolean isPickaxe(ItemStack i){
        for (Material m : pickaxe){
            if (m.equals(i.getType()))return true;
        }
        return false;
    }
    public static boolean isAxe(ItemStack i){
        for (Material m : axe){
            if (m.equals(i.getType()))return true;
        }
        return false;
    }
    public static boolean isSpade(ItemStack i){
        for (Material m : spade){
            if (m.equals(i.getType()))return true;
        }
        return false;
    }
    public static boolean isHoe(ItemStack i){
        for (Material m : hoe){
            if (m.equals(i.getType()))return true;
        }
        return false;
    }


    public static ItemStack createItem(Material material, String name, int data){
        ItemStack item = new ItemStack(material, 1, (short)data);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack createItem(Material material, String name){
        ItemStack item = new ItemStack(material, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack setName(ItemStack item, String name){
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack setLore(ItemStack item, String lore){
        ItemMeta itemMeta = item.getItemMeta();

        List<String> lored = new ArrayList<String>();
        lored.add(lore);
        itemMeta.setLore(lored);

        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack addToLore(ItemStack item, String lore){
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lored = new ArrayList<String>();
        if (itemMeta.getLore() != null){
            lored = itemMeta.getLore();
        }
        lored.add(lore);
        itemMeta.setLore(lored);

        item.setItemMeta(itemMeta);
        return item;
    }
}
