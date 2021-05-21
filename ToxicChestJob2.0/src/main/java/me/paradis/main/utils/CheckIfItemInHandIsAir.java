package me.paradis.main.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CheckIfItemInHandIsAir {

    public boolean check(ItemStack item) {
        return item.getType() == Material.AIR;
    }
}
