package me.paradis.main;

import me.paradis.main.GUIs.generalGUI.CreateGeneralGUI;
import me.paradis.main.commands.CommandManager;
import me.paradis.main.utils.AddDefaults;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        new AddDefaults().add();
        saveConfig();

        if (isEnablled()) {
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Random Item Chest Enabled");
            getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");

            //register commands
            commandRegister();

            //register events
            eventRegister();
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

    public void commandRegister(){
        Objects.requireNonNull(getCommand("chest")).setExecutor(new CommandManager());
    }

    public void eventRegister(){
        getServer().getPluginManager().registerEvents(new CreateGeneralGUI(), this);
    }

    public boolean isEnablled() {
        return Main.get().getConfig().getBoolean("config.enabled");
    }

    public static Main get() {
        return instance;
    }

    public boolean debugMode() {
        return Main.get().getConfig().getBoolean("debugMode");
    }
}
