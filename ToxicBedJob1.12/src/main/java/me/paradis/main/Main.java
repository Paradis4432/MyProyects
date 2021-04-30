package me.paradis.main;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    //on add of location set block under the player to gold with true false in config file
    //add bedDelay
    //only show the bed if the bed is still there by checking location is bed
    //add message on bed place event


    //ideas:
    //change bed lore based on perm or config, have each respawn location with % of happening, have different bed limits based on perm of config
    //different sending message ,title  based on config or perm
    //adapt the gui size based on the amount of beds
    //right click tp left click delete with confirmation


    FileConfiguration config = this.getConfig();
    private static Main instance;


    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Bed GUI Respawn Enabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------");

        instance = this;
        this.saveDefaultConfig();
        addDefaults();
        saveConfig();

        commands();

        if(enabled()){
            getServer().getPluginManager().registerEvents(new BedPlaceEvent(), this);
            getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
            getServer().getPluginManager().registerEvents(new CloseInventoryEvent(), this);
        }

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Bed GUI Respawn Disabled");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Made By Paradis");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "--------------------------");
    }

    public void addDefaults(){
        config.addDefault("enabled", true);

        config.addDefault("warningMessage.enabled" , true);
        config.addDefault("warningMessage.message" , "&6Opening Bed GUI");

        config.addDefault("messages.noPermMessage", "&4You dont have permission to do that");
        config.addDefault("messages.playerNotFound", "&4This player was not found");
        config.addDefault("messages.deletingBedMessage" , "&6Deleting Bed");
        config.addDefault("messages.error", "&4Fatal Error Please Contact The Developer");
        config.addDefault("messages.sendingMessage", "&6Sending you to your bed location");
        config.addDefault("messages.sendingDefaultLocation", "&6Sending you to a default Respawn location");
        config.addDefault("messages.locationSaved", "&6Location Saved Successfully");
        config.addDefault("messages.error", "&4There has been an error please contact the debeloper: ");

        config.addDefault("config.bedDelay" , 0);
        config.addDefault("config.bedLimit" , 21);

        config.addDefault("respawnTitleName" , "&4Choose the bed you want to respawn in");

        config.options().copyDefaults(true);
    }

    public void commands(){
        //register commands
        Objects.requireNonNull(getCommand("beds")).setExecutor(new BedsCommand());
    }

    public Boolean enabled(){
        return getConfig().getBoolean("enabled");
    }

    public static Main get(){
        return instance;
    }


}
