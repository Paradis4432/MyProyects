package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Messages {

    public void sendHelpMessage(Player player){
        player.sendMessage(ChatColor.GOLD + "/add to add a default respawn location");
        player.sendMessage(ChatColor.GOLD + "/remove [id] to remove a default respawn location using the id");
        player.sendMessage(ChatColor.GOLD + "/limit to check your current bed limit");
        player.sendMessage(ChatColor.GOLD + "/count to count how many active beds you have right now");
    }

    public String getPrefix(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("config.prefix")));
    }

    public String getNoPermMessage() {
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.noPermMessage")));
    }

    public String getLocationSavedMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.locationSaved")));
    }

    public String getErrorMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.error")));
    }

    public String deletingBedMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.deletingBedMessage")));
    }

    public String getWarningMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("warningMessage.message")));
    }

    public String getSendingMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.sendingMessage")));
    }

    public String getBedPlacedMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.bedPlacedEvent")));
    }

    public String getMaxBedsPlaced(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.bedPlacedLimit")));
    }

    public String getOnCooldownMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.onCooldown")));
    }

    public String getLimitMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.limit")));
    }

    public String getSendingDefaultLocationMessage(){
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Objects.requireNonNull(Main.get().getConfig().getString("messages.sendingDefaultLocation")));
    }
}
