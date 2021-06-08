package me.paradis.movingparticle.debugManager;

import me.paradis.movingparticle.configManager.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Debug {

    private static final String PREFIX = (String) new Config().get("config.prefix");

    public void logStatistic(String message) {
        logWithExtra("&6Statistic", message);
    }

    public void logDebug(String message) {
        logWithExtra("Debug", message);
    }

    public void logError(String message) {
        logWithExtra("&4Error", message);
    }

    public void logWarning(String message) {
        logWithExtra("&cWarning", message);
    }

    public void logInfo(String message) {
        logWithExtra("Info", message);
    }

    public void logWithExtra(String extra, String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                PREFIX + ": " + extra + " | " + message));
    }

    public void log(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                PREFIX + " | " + message));
    }
}
