package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class Defaults {

    public void createDefaults(){

        FileConfiguration config = Main.get().getConfig();

        config.addDefault("enabled", true);

        config.addDefault("config.prefix", "&c[Chest] ");
        config.addDefault("config.cd", 10);
        config.addDefault("config.debugMode", false);
        config.addDefault("config.limit", 50);


        config.addDefault("messages.error", "&4There was an error please contact the developers");
        config.addDefault("messages.locationAdded", "&6location added");
        config.addDefault("messages.locationRemoved", "&6location removed");
        config.addDefault("messages.itemAdded" , "&6item added");
        config.addDefault("messages.itemRemoved" , "&6item removed");
        config.addDefault("messages.itemReplaced" , "&6item replaced");
        config.addDefault("messages.chestSpawned" , "&6chest spawned");
        config.addDefault("messages.chestDeleted" , "&6chest deleted");
        config.addDefault("messages.chestForced" , "&6chest forced");
        config.addDefault("messages.itemsListed" , "&6item listed");
        config.addDefault("messages.locationsListed" , "&6locations listed");
        config.addDefault("messages.locationReplaced" , "&6Location replaced");
        config.addDefault("messages.cantBrake" , "&6cant brake this block");
        config.addDefault("messages.chanceChanged" , "&6chance changed");
        config.addDefault("messages.noPerm", "&cYou cant run this command");
        config.addDefault("messages.cantOpen", "&6this chest is locked, unlocking in: ");
        config.addDefault("messages.itemGave", "&6Item added to your inventory");

        config.addDefault("title.basicGui", "&6Choose what to Delete");
        config.addDefault("title.removeItem", "&6Choose what item to Delete");
        config.addDefault("title.removeLocation", "&6Choose what location to Delete");
        config.addDefault("title.replaceItem", "&6Choose what item to replace");
        config.addDefault("title.replaceLocation", "&6Choose what location to replace");
        config.addDefault("title.listItems", "&6List of items");
        config.addDefault("title.listLocations", "&6List of locations");

        config.options().copyDefaults(true);
    }
}
