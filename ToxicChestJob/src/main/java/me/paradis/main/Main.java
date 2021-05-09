package me.paradis.main;

import me.paradis.main.commands.ChestCommandManager;
import me.paradis.main.cooldown.StartCooldown;
import me.paradis.main.events.DeleteGuiListener;
import me.paradis.main.events.RemoveLocationListener;
import me.paradis.main.events.RightClickChest;
import me.paradis.main.utils.Defaults;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    /*todo list
    add location saved message
    add help message
    add item saved message
    add cooldown started message
    add unlocking message

    add perms for everything

    add force
    add timer
    add set chance
    add remove loc remove item command
    add block remove prevention
    remove item drops when setting chest to air

    add /chest replace item ID and chest replace location ID
    make replace command a gui
    make chest list items and chest list locations a gui

    add resizeble gui
    add fill items

    delete chest on remove location command


     */

    //if timer enabled
    /*
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

    /*ideas:


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
