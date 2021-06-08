package me.paradis.movingparticle.invUtils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

    public static void fillWithItem(Inventory inv, ItemStack item, int start, int end) {
        for (; start <= end; start++) {
            inv.setItem(start, item);
        }
    }

    public static int getAvailableSlots(ItemStack item, Inventory inv) {
        int count = 0;
        for (ItemStack i : inv.getContents()) {
            if (i == null || i.getType() == Material.AIR) {
                count += item.getMaxStackSize();
            } else if (i.getType() == item.getType()) {
                count += (i.getMaxStackSize() - i.getAmount());
            }
        }

        return count;
    }
}
