package me.paradis.main.items;

import me.paradis.main.utils.Messages;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveClickedItem {

    public void give(ItemStack item, Player player){
        player.getInventory().addItem(item);
        player.sendMessage(new Messages().getItemGaveMessage());
    }
}
