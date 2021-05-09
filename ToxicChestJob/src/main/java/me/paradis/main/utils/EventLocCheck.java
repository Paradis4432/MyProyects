package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.block.Block;

public class EventLocCheck {

    public Boolean check(Block b,Integer chestId){
        return (b.getLocation().getBlockX() == Main.get().getConfig().getInt("locations." + chestId + ".X"))
                && (b.getLocation().getBlockY() == Main.get().getConfig().getInt("locations." + chestId + ".Y"))
                && (b.getLocation().getBlockZ() == Main.get().getConfig().getInt("locations." + chestId + ".Z"));
    }
}
