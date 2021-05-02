package me.paradis.main.bedManager;

import me.paradis.main.utils.Lores;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class CheckIfBedIsAlive {

    //if the location is a bed return true
    //else delete the location in config return true
    public Boolean IsBed(Player player, Integer bedId){
        //using lores fucntions
        Location loc = new Location(Bukkit.getWorld(Objects.requireNonNull(new Lores().loreWorld(player,bedId))),
                new Lores().loreLocationX(player,bedId),
                new Lores().loreLocationY(player,bedId),
                new Lores().loreLocationZ(player,bedId));

        return loc.getBlock().getType().name().startsWith("BED_");
    }
}
