package me.paradis.coinflip.main.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

//utils found in https://github.com/gronnmann/CoinFlipper/tree/master/src/io/github/gronnmann/utils

public class Degub {
    public static void print(String mess){
        File debugEnabler = new File(Bukkit.getServer().getWorldContainer().getAbsolutePath(), "debug.yml");
        if(!debugEnabler.exists())return;
        FileConfiguration utilsConfig = YamlConfiguration.loadConfiguration(debugEnabler);
        if(utilsConfig.getString("debug") == null)return;
        if(!utilsConfig.getBoolean("debug"))return;

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + mess);
    }
}
