package me.paradis.main.GUI;

import me.paradis.main.utils.CreateItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class OpenRemoveItemGui {

    public void open(Player player){

    }

    public ItemStack createItem(final Material material, final String name, final String... lore){
        return new CreateItems().create(material,name,lore);
    }
}
