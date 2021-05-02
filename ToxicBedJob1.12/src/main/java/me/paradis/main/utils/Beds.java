package me.paradis.main.utils;

import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Beds {

    public Integer getBedName(ItemStack itemStack) {
        return Integer.valueOf(Objects.requireNonNull(itemStack.getItemMeta().getDisplayName()));
    }
}
