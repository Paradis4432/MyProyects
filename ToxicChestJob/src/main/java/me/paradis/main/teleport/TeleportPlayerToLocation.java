package me.paradis.main.teleport;

import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TeleportPlayerToLocation {

    public void teleport(Player player, ItemStack clickedItem) {
        try {
            //teleport the player to the lore of the item
            Location loc = new Location(getWorld(clickedItem),
                    getLore(1, clickedItem),
                    getLore(2, clickedItem),
                    getLore(3, clickedItem));

            player.teleport(loc);

            if (debugMode())
                System.out.println("player " + player + " teleported to location " + loc + " current clicked item: " + clickedItem);
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public World getWorld(ItemStack clickedItem) {
        return Bukkit.getWorld(clickedItem.getItemMeta().getLore().get(0));
    }

    public double getLore(Integer loreLine, ItemStack clickedItem) {
        return Double.parseDouble(clickedItem.getItemMeta().getLore().get(loreLine));
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}
