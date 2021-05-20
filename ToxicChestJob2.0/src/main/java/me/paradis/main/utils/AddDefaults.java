package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class AddDefaults {

    public void add() {
        FileConfiguration config = Main.get().getConfig();

        config.addDefault("config.enabled", true);

        config.options().copyDefaults(true);
    }
}
