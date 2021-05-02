package me.paradis.main.bedManager;

import me.paradis.main.Main;
import me.paradis.main.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public class TeleportPlayerToBed {

    public void teleportPlayer(Player player, ItemStack clickedItem){
        //teleports the player to the location of the bed
        Location loc = new Location(Bukkit.getWorld(Objects.requireNonNull(clickedItem.getItemMeta().getLore()).get(0)) ,
                Double.parseDouble(clickedItem.getItemMeta().getLore().get(1)),
                Double.parseDouble(clickedItem.getItemMeta().getLore().get(2)),
                Double.parseDouble(clickedItem.getItemMeta().getLore().get(3)));

        player.closeInventory();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(Main.get(), new Runnable() {
            @Override
            public void run() {
                player.teleport(loc);
                player.sendMessage(new Messages().getSendingMessage());
            }
        }, 2L);
        //Bukkit.getScheduler().runTask(Main.get(), () -> player.teleport(loc));
    }
}
