package me.paradis.general.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Main extends JavaPlugin {

    FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Key GiveAway Enabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Infinity Craft");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");

        this.saveDefaultConfig();

        config.addDefault("enabled", true);
        config.addDefault("time", 10);
        config.addDefault("name", "common");
        config.addDefault("type", "Physical");
        config.addDefault("amount", 1);
        config.options().copyDefaults(true);
        saveConfig();

        if(CheckIfEnabled()){
            StartGiveAway();
        }
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Key GiveAway Disabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Infinity Craft");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
    }

    public boolean CheckIfEnabled(){
        if(getConfig().getBoolean("enabled")) return true;
        else return false;
    }

    public void StartGiveAway(){
        //starts countdown so players get the key
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                GiveKeysToAllPlayers();
            }
        },0L,(getConfig().getInt("time")) * 20L);
    }

    public void GiveKeysToAllPlayers() {
        //Bukkit.getLogger().info("cc giveall " + getConfig().getString("type") + " " + getConfig().getString("name") + " " + getConfig().getInt("amount"));
        String Commnad = "cc giveall " + getConfig().getString("type") + " " + getConfig().getString("name") + " " + getConfig().getInt("amount");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Commnad);
        //Bukkit.getLogger().info("Key Gave To Everyone");
    }
}

/**
 *     JavaPlugin plugin; // Your plugin instance
 *     FileConfiguration config = plugin.getConfig();  //Accessing the config file
 *
 */