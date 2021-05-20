package me.paradis.main.GUIs.Items.defaultItems;

import me.paradis.main.GUIs.Items.ItemGenerator;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddBackGroundItems {

    public Inventory add(Inventory inv, int size){
        //adds background items
        ItemStack panel = new ItemGenerator().createItemShort(Material.STAINED_GLASS_PANE,1, (short) 15, " ");

        while(inv.firstEmpty() != -1) inv.setItem(inv.firstEmpty(), panel);

        return inv;
    }
}
