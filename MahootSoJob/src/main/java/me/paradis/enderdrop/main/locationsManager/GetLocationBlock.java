package me.paradis.enderdrop.main.locationsManager;

import org.bukkit.*;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;

import static org.bukkit.Bukkit.getServer;

public class GetLocationBlock {

    public Location getLowestBlock() {
        System.out.println("test9 getLowestBlock called");
        //gets the lowest possible block to place the chest
        Location loc;
        for (World w : Bukkit.getWorlds()) {
            //loops through all worlds
            for (Entity e : w.getEntities()) {
                //loops trough all entities on each world
                if (e instanceof EnderDragon) {
                    //stops when ender dragon found
                    loc = e.getLocation().clone();
                    for (int blocks = 1; blocks <= 100; blocks++) {
                        if (!(loc.getBlock().getType() == Material.AIR)) {
                            loc.add(0, 1, 0);
                            System.out.println("test9.1 returning: " + loc);
                            return loc;
                        } else {
                            loc.subtract(0, 1, 0);
                        }
                    }
                }
            }
        }

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Fatal Error: Ender Dragon Not Found");

        return null;
    }
}
