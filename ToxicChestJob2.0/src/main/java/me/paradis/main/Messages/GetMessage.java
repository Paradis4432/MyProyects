package me.paradis.main.Messages;

import me.paradis.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GetMessage {

    /**
     *
     * @param messageID message
     * @return message found in config file
     */
    public String get(String messageID){
        try{
            return ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("messages." + messageID));
        } catch (Exception e){
            System.out.println("CHEST messageID not found, returning error message");
            return ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("messages.error"));
        }
    }
}
