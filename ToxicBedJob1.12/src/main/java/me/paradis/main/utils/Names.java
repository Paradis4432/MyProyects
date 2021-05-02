package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.ChatColor;

import java.util.Objects;

public class Names {

    public String getTitleName(){
        return ChatColor.translateAlternateColorCodes('&' , Objects.requireNonNull(Main.get().getConfig().getString("respawnTitleName")));
    }
}
