package me.paradis.main.events;

import me.paradis.main.Main;
import me.paradis.main.respawnManager.InventoryOpen;
import me.paradis.main.utils.IsEnabled;
import me.paradis.main.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class RespawnEvent implements Listener {

    @EventHandler
    public void onRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if(new IsEnabled().getWarningMessageEnabled()){
            player.sendMessage(new Messages().getWarningMessage());
        }
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(Main.get(), new Runnable() {
            @Override
            public void run() {
                new InventoryOpen().openInventory(player);
            }
        }, 40L);

    }
}
