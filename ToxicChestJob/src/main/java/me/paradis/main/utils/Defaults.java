package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class Defaults {

    public void createDefaults(){

        FileConfiguration config = Main.get().getConfig();

        config.addDefault("enabled", true);

        config.addDefault("config.prefix", "&c[Chest] ");
        config.addDefault("config.cd", 10);

        config.options().copyDefaults(true);
    }
}
