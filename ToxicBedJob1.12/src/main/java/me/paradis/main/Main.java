package me.paradis.main;

import me.paradis.main.commands.BedCommand;
import me.paradis.main.cooldown.CooldownManager;
import me.paradis.main.cooldown.CooldownReduction;
import me.paradis.main.events.*;
import me.paradis.main.utils.AddDefaults;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {


    //add removed location message

    //ideas:

    private static Main instance;


    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Bed GUI Respawn Enabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");

        instance = this;
        this.saveDefaultConfig();
        new AddDefaults().addDefaults();
        saveConfig();

        if(enabled()){
            commands();
            new CooldownReduction().bedsCooldown();
            getServer().getPluginManager().registerEvents(new CloseInventoryEvent(), this);
            getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
            getServer().getPluginManager().registerEvents(new InvDragEvent(), this);
            getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
            getServer().getPluginManager().registerEvents(new BedPlaceEvent(), this);
        }

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Bed GUI Respawn Disabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
    }

    public void commands(){
        //register commands
        Objects.requireNonNull(getCommand("beds")).setExecutor(new BedCommand());
    }

    public Boolean enabled(){
        return getConfig().getBoolean("enabled");
    }

    public static Main get(){
        return instance;
    }


}
