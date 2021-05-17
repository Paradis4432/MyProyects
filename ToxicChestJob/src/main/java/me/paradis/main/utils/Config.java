package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.ChatColor;

import java.util.Objects;

public class Config {

    //config


    public boolean getDebugMode() {
        return Main.get().getConfig().getBoolean("config.debugMode");
    }


}
