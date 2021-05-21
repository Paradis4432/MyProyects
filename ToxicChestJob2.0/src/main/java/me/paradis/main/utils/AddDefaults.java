package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class AddDefaults {

    public void add() {
        FileConfiguration config = Main.get().getConfig();

        config.addDefault("config.enabled", true);
        config.addDefault("config.debugMode", true);

        //add message
        config.addDefault("messages.error", "&4There was an error please contact the developer");

        config.addDefault("messages.itemIsAir", "&cYou cant add air!");
        config.addDefault("messages.noLootFound", "&cInvalid loot");
        config.addDefault("messages.noLocationFound", "&cInvalid location");

        config.addDefault("messages.locationAdded", "&6Location added");
        config.addDefault("messages.itemSaved", "&6Item added!");

        config.options().copyDefaults(true);
    }
}
