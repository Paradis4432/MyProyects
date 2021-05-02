package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.entity.Player;

public class Lores {

    public String loreWorld(Player player, Integer beds){
        return(Main.get().getConfig().getString("beds." + player.getUniqueId() + ".bedsLocation." + (beds+1) + ".world"));
    }

    public Integer loreLocationX(Player player, Integer beds){
        return (Main.get().getConfig().getInt("beds." + player.getUniqueId() + ".bedsLocation." + (beds+1) + ".X"));
    }

    public Integer loreLocationY(Player player, Integer beds){
        return (Main.get().getConfig().getInt("beds." + player.getUniqueId() + ".bedsLocation." + (beds+1) + ".Y"));
    }

    public Integer loreLocationZ(Player player, Integer beds){
        return (Main.get().getConfig().getInt("beds." + player.getUniqueId() + ".bedsLocation." + (beds+1) + ".Z"));
    }
}
