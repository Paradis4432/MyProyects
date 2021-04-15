package me.paradis.blocklocate.locatecommnadblock;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class LocateCommnadBlock extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Locate and Locatebiome Command Blocked");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Made By InfinityCraft");
        Objects.requireNonNull(getCommand("Locate")).setExecutor(new LocateCommand());
        Objects.requireNonNull(getCommand("Locatebiome")).setExecutor(new LocateBiomeCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
