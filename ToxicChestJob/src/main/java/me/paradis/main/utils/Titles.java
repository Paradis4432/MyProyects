package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.ChatColor;

import java.util.Objects;

public class Titles {

    //titles
    public String getListItemsTitleName(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("title.listItems")));
    }

    public String getLocationsListTitleName(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("title.listLocations")));
    }

    public String getLocationReplacedTitleName(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("title.replaceLocation")));
    }

    public String getItemReplaceTitleName(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("title.replaceItem")));
    }


    public String getBasicGuiTitleName(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("title.basicGui")));
    }

    public String getItemRemoveTitleName(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("title.removeItem")));
    }

    public String getLocationRemoveTitleName(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("title.removeLocation")));
    }
}
