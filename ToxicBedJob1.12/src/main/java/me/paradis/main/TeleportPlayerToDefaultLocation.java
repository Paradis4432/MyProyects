package me.paradis.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.Random;

public class TeleportPlayerToDefaultLocation {

    public void TeleportPlayer(Player player){
        int spawnLocation = getRandomNumber();

        /*System.out.println("spawnLocation: " + spawnLocation);
        System.out.println("name: " + getWorldRespawn(spawnLocation));
        System.out.println("X: " + getXRespawnLocation(spawnLocation));
        System.out.println("Y: " + getYRespawnLocation(spawnLocation));
        System.out.println("Z: " + getZRespawnLocation(spawnLocation));

         */
        if(spawnLocation == 0) spawnLocation =1;

        try{
            Location loc = new Location(Bukkit.getWorld(getWorldRespawn(spawnLocation)), getXRespawnLocation(spawnLocation), getYRespawnLocation(spawnLocation), getZRespawnLocation(spawnLocation));
            Bukkit.getScheduler().runTask(Main.get(), () -> player.teleport(loc));

            player.sendMessage(getSendingDefaultLocationMessage());

        }catch (Exception e){
            player.sendMessage(getErrorMessage() + e);
        }

    }

    public Integer getRandomNumber(){
        Random r = new Random();
        return r.nextInt(new BedsCommand().getAllLocations());
    }

    public String getWorldRespawn(Integer currentLocation){
        return Main.get().getConfig().getString("respawnLocations." + currentLocation + ".world");
    }

    public Integer getXRespawnLocation(Integer currentLocation){
        return Main.get().getConfig().getInt("respawnLocations." + currentLocation + ".X");
    }

    public Integer getYRespawnLocation(Integer currentLocation){
        return Main.get().getConfig().getInt("respawnLocations." + currentLocation + ".Y");
    }

    public Integer getZRespawnLocation(Integer currentLocation){
        return Main.get().getConfig().getInt("respawnLocations." + currentLocation + ".Z");
    }

    public String getErrorMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.error")));
    }

    public String getSendingDefaultLocationMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.sendingDefaultLocation")));
    }

}
