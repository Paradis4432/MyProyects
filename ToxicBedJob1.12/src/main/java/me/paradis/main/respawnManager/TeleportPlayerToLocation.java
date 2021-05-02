package me.paradis.main.respawnManager;

import me.paradis.main.Main;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Random;
import me.paradis.main.utils.Respawn;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class TeleportPlayerToLocation {

    public void TeleportPlayer(Player player){

        int spawnLocation = new Random().getRandomNumber();

        /*System.out.println("spawnLocation: " + spawnLocation);
        System.out.println("name: " + getWorldRespawn(spawnLocation));
        System.out.println("X: " + getXRespawnLocation(spawnLocation));
        System.out.println("Y: " + getYRespawnLocation(spawnLocation));
        System.out.println("Z: " + getZRespawnLocation(spawnLocation));

         */
        if(spawnLocation == 0) spawnLocation =1;

        try{
            Location loc = new Location(Bukkit.getWorld(new Respawn().getWorldRespawn(spawnLocation)),
                    new Respawn().getXRespawnLocation(spawnLocation),
                    new Respawn().getYRespawnLocation(spawnLocation),
                    new Respawn().getZRespawnLocation(spawnLocation));

            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(Main.get(), new Runnable() {
                @Override
                public void run() {
                    player.teleport(loc);
                    player.sendMessage(new Messages().getSendingDefaultLocationMessage());
                }
            }, 1L);


        }catch (Exception e){
            player.sendMessage(new Messages().getErrorMessage() + e);
        }
    }
}
