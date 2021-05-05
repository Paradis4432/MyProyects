package me.paradis.enderdrop.main.chestManager;

import me.paradis.enderdrop.main.Main;
import org.bukkit.ChatColor;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class ItemData {

    public Integer getItemAmount(int currentTier, int items){
        System.out.println("test11 getItemAmount called returning: " + Main.get().getConfig().getInt("tiers." + currentTier + ".items." + items + ".amount"));
        return Main.get().getConfig().getInt("tiers." + currentTier + ".items." + items + ".amount");
    }

    public List getItemLore(int currentTier, int items) {
        System.out.println("test8 getItemLore called");
        try {
            return Main.get().getConfig().getList(ChatColor.translateAlternateColorCodes('&', "tiers." + currentTier + ".items." + items + ".lore"));
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage("no lore found in config file");
        }
        return null;
    }

    public String getItemName(int currentTier, int items) {
        System.out.println("test7 getItemName called");
        try {
            return Main.get().getConfig().getString(ChatColor.translateAlternateColorCodes('&', "tiers." + currentTier + ".items." + items + ".name"));
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage("no item name found in config file");
        }
        return null;
    }
}
