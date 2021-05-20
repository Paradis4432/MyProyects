package me.paradis.main.GUIs.Items.fillItems;

import me.paradis.main.GUIs.Items.ItemGenerator;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddBorderItems {

    public Inventory fill(Inventory inv, int size){
        //adds border items to the inventory given based on the size of it

        ItemStack panel = new ItemGenerator().createItemShort(Material.STAINED_GLASS_PANE,1, (short) 0, " ");

        for(int pos = 0; pos < size; pos++){
            if(pos <= 8) inv.setItem(pos,panel);
            if(pos % 9 == 0 && pos > 1){
                inv.setItem((pos-1),panel);
                inv.setItem(pos,panel);
            }
            if(pos >= (size-9)) inv.setItem(pos,panel);
        }

        return inv;
    }
}
