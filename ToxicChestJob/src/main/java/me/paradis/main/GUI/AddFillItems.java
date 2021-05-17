package me.paradis.main.GUI;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddFillItems {

    public Inventory add(Inventory inv){
        ItemStack panel1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)15);
        ItemMeta panel1Meta = panel1.getItemMeta();
        panel1Meta.setDisplayName(" ");

        while(inv.firstEmpty() != -1) inv.setItem(inv.firstEmpty(), panel1);

        return inv;
    }
}
