package me.paradis.enderdrop.main.utils;

import me.paradis.enderdrop.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Messages {

    public void sendNoPermMessage(Player player){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.noPermMessage"))));
    }

    public String getLocationSaved(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.locationSaved")));
    }

    public String getErrorMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.error")));
    }

    public String getSpawningMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.spawnEnderDragonMessage")));
    }

    public String getKillingMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.killEnderDragonMessage")));
    }

    public String getBroadcastMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.spawnEnderDragonMessage")));
    }

    public void sendHelpMessage(Player player){
        player.sendMessage(ChatColor.GOLD + "/dragon help : Opens this message");
        player.sendMessage(ChatColor.GOLD + "/dragon spawn : Forces the dragon to spawn");
        player.sendMessage(ChatColor.GOLD + "/dragon kill : Forces the dragon to die");
        player.sendMessage(ChatColor.GOLD + "/dragon set [spawnLocation/holoLocation] : sets the location of each thing");
    }
}
