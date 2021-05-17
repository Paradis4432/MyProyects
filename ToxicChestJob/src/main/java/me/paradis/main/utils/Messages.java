package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Objects;

/*
  } catch (Exception e) {
                    if (debugMode()) {
                        String name = String.valueOf(this.getClass());
                        getErrorMessage(name, e);
                    }
                }
        public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

     public boolean debugMode() {
        return new Messages().getDebugMode();
    }
 */
public class Messages {
    public String getPrefix() {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("config.prefix")));
    }

    //long messages
    public void errorMessage(String name, Exception e) {
        System.out.println("Error");
        System.out.println(e.getMessage());
        System.out.println("At");
        System.out.println(name);
    }

    public void sendHelpMessage(Player player) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Incorrect Usage"));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6/chest [add] [item/location]"));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6/chest [remove/list/replace] [item/location] [pageId]"));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chest set chance [chestId] [chance]"));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chest force [locationId]"));
    }

    //messages
    //location
    public String getLocationAddedMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.locationAdded"));
    }

    public String getLocationRemovedMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.locationRemoved"));
    }

    //item
    public String getItemGaveMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.itemGave"));
    }


    public String getItemAddedMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.itemAdded"));
    }

    public String getItemRemovedMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.itemRemoved"));
    }

    //forced
    public String getForcedMessage() {
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Main.get().getConfig().getString("messages.chestForced"));
    }

    //list
    public String getItemsListedMessage() {
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Main.get().getConfig().getString("messages.itemsListed"));
    }

    public String getLocationsListedMessage() {
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Main.get().getConfig().getString("messages.locationsListed"));
    }

    //replace
    public String getItemReplacedMessage() {
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Main.get().getConfig().getString("messages.itemReplaced"));
    }

    public String getLocationReplacedMessage() {
        return ChatColor.translateAlternateColorCodes('&', getPrefix() + Main.get().getConfig().getString("messages.locationReplaced"));
    }

    //others
    public String getChestBlockedMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.cantOpen"));
    }

    public Integer getItemLimit(){
        return Main.get().getConfig().getInt("config.limit");
    }

    public String getCantBrakeThisBlockMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.cantBrake"));
    }

    public String getChanceChangedMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.chanceChanged"));
    }

    public String noPermMessage() {
        return ChatColor.translateAlternateColorCodes('&',getPrefix() +  Main.get().getConfig().getString("messages.noPerm"));
    }


}
