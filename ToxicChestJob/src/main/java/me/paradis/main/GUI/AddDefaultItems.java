package me.paradis.main.GUI;

import me.paradis.main.utils.CreateItems;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddDefaultItems {

    public Inventory add(Inventory inv){
        int size = inv.getSize();
        ItemStack panel1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)0);
        ItemMeta panel1Meta = panel1.getItemMeta();
        panel1Meta.setDisplayName(" ");

        for(int pos = 0; pos < size; pos++){
            if(pos <= 8) inv.setItem(pos,panel1);
            if(pos % 9 == 0 && pos > 1){
                inv.setItem((pos-1), panel1);
                inv.setItem(pos,panel1);
            }
            if(pos >= (size-9)) inv.setItem(pos,panel1);
        }

        return inv;
    }

}
