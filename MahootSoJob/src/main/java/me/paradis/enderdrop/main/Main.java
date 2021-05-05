package me.paradis.enderdrop.main;

import me.paradis.enderdrop.main.dragon.SpawnDragon;
import me.paradis.enderdrop.main.chestManager.Chest;
import me.paradis.enderdrop.main.commands.DragonCommand;
import me.paradis.enderdrop.main.utils.Options;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public final class Main extends JavaPlugin {

    //add command /dragon spawn force
    //add command /dragon kill force
    //add command /dragon set spawnLocation
    //add command /dragon set holoLocation
    //add command /dragon help

    private static Main instance;

    @Override
    public void onEnable() {

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Ender Dragon Drops Enabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");

        instance = this;
        this.saveDefaultConfig();

        //adds defaults
        new AddDefaults().addDefaults();
        saveConfig();

        command();

        if(enabled()){
            startCountDown();
        }
    }

    public void startCountDown(){
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                //every 1 second check if time is enough
                //if time left >= minDelay start event else add 1
                if(new Options().getTimeLeft() >= new Options().getMinDelay()){
                    //start event
                    //spawn dragon,set isAlive to true check if isAlive is true and spawn chest if so
                    if(new Options().getIsAlive()){
                        //spawn chests
                        new Chest().placeChest(); // places the chests and starts a chain reaction to fill the chests
                    }else{
                        //spawn dragon
                        //add chance of happening
                        Main.get().getConfig().set("admin.DoNotEdit.isAlive", true);
                        new SpawnDragon().SpawnEnderDragon(); // spawns the ender dragon on the location in the config file
                    }
                }else{
                    Main.get().getConfig().set("admin.DoNotEdit.timeLeft" , (new Options().getTimeLeft()) + 1);
                }
            }
        }, 0L, 20L);
    }


    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Ender Dragon Drops Disabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
    }

    public static Main get(){
        return instance;
    }

    public void command(){
        Objects.requireNonNull(getCommand("dragon")).setExecutor(new DragonCommand());
    }

    public boolean enabled() {
        return getConfig().getBoolean("enabled");
    }
}

