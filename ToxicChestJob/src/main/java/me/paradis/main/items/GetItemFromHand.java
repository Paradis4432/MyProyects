package me.paradis.main.items;

import me.paradis.main.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GetItemFromHand {

    public void get(Player player){
        //saves the item in the config file
        int itemId = new GetAllItems().getItems();

        ItemStack item = player.getInventory().getItemInMainHand();

        System.out.println(item.serialize());

        Main.get().getConfig().set("items." + itemId , item.serialize()); //replace
        Main.get().saveConfig();

        player.sendMessage("add item saved message");
    }
}
