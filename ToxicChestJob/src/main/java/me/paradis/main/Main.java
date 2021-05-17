package me.paradis.main;

import me.paradis.main.commands.ChestCommandManager;
import me.paradis.main.cooldown.StartCooldown;
import me.paradis.main.events.*;
import me.paradis.main.utils.Defaults;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    /*todo list
    add debug message for chest

    each location has X set of items , lootables
    after unlocked move the set of items to the enderchest
     */
    /**
    if spawned == false and cd(timeleft) >=1:
        cd --
    if spawned == false and cd== 0:
        spawn the chest
        set spawned == true
        set clicked == false
        set unblocked == false
        set timeleft == lockedTime(cd, timeleft) == 10
    on click chest:
        if unblocked == false:
            clicked == true
        else:
            open
            wait (delete time) 5 seconds
            delete chest
            set spawned to false
            set clicked == false
            set unblocked == false
            set cd == 10 (respawn time)
    if spawned == true and clicked == true and unblocked == false and timeleft >= 1:
        cd--
    if spawned == true and clicked == true and unblocked == false and timeleft == 0:
        unblocked == true
     */

    private static Main instance;



    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        new Defaults().createDefaults();
        saveConfig();

        if (enabled()) {
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Random Item Chest Enabled");
            getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");

            //register commands
            commands();

            //register cooldownds
            new StartCooldown().start();

            //register events
            getServer().getPluginManager().registerEvents(new ListGuiListener(), this);
            getServer().getPluginManager().registerEvents(new ReplaceLocationListener(), this);
            getServer().getPluginManager().registerEvents(new ReplaceItemListener(), this);
            getServer().getPluginManager().registerEvents(new ChestBrakeEvent(), this);
            getServer().getPluginManager().registerEvents(new RemoveItemGuiListener(), this);
            getServer().getPluginManager().registerEvents(new RemoveLocationListener(), this);
            getServer().getPluginManager().registerEvents(new DeleteGuiListener(), this);
            getServer().getPluginManager().registerEvents(new RightClickChest(), this);
        }
    }

    @Override
    public void onDisable() {
        Main.get().saveConfig();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Random Item Chest Disabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
    }

    public void commands() {
        //register commands
        Objects.requireNonNull(getCommand("chest")).setExecutor(new ChestCommandManager());
    }

    public Boolean enabled() {
        return getConfig().getBoolean("enabled");
    }

    public static Main get() {
        return instance;
    }
}
