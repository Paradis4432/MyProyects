package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class AddDefaults {

    public void addDefaults(){

        FileConfiguration config = Main.get().getConfig();

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
        config.addDefault("messages.bedPlacedEvent", "&6Bed Placed");
        config.addDefault("messages.bedPlacedLimit", "&4You have reached the maxium amount of beds to place");
        config.addDefault("messages.onCooldown", "&4This Bed is on cooldown");
        config.addDefault("messages.limit", "&6Your current bed limit is: ");

        config.addDefault("bedLimits.1.permission" , "test");
        config.addDefault("bedLimits.1.amount", 5);

        config.addDefault("bedLimits.2.permission" , "test1");
        config.addDefault("bedLimits.2.amount", 10);

        config.addDefault("bedLimits.3.permission" , "test2");
        config.addDefault("bedLimits.3.amount", 2);

        config.addDefault("bedLimits.4.permission" , "test3");
        config.addDefault("bedLimits.4.amount", 12);

        config.addDefault("bedLimits.5.permission" , "test4");
        config.addDefault("bedLimits.5.amount", 16);

        config.addDefault("config.bedDelay" , 0);
        config.addDefault("config.prefix", "&c[&6Prefix&c] ");

        config.addDefault("respawnTitleName" , "&4Choose the bed you want to respawn in");

        config.options().copyDefaults(true);
    }
}
