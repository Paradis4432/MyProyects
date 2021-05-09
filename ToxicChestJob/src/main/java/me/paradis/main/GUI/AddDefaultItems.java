package me.paradis.main.GUI;

import me.paradis.main.utils.CreateItems;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AddDefaultItems {

    public Inventory add(Inventory inv){

        ItemStack panel1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)0);
        ItemStack info = createItem(Material.BOOK, "Info", "add the items info here ");
        for(int pos = 0; pos < 54; pos++){
            if(pos <= 8) inv.setItem(pos,panel1);
            if(pos % 9 == 0 && pos > 1){
                inv.setItem((pos-1), panel1);
                inv.setItem(pos,panel1);
            }
            if(pos >= (54-9)) inv.setItem(pos,panel1);
            if(pos == (54-5)) inv.setItem(pos,info);
        }

        return inv;
    }

    public ItemStack createItem(final Material material, final String name, final String... lore){
        return new CreateItems().create(material,name,lore);
    }
}
