package me.paradis.main.Messages;

import me.paradis.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GetMessage {

    public String get(String messageID){
        return ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("messages." + messageID));
    }
}
