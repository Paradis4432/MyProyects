package me.paradis.spiderman;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class DebugManager {

    private static final String PREFIX = SpiderMan.getString("config.prefix");

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
