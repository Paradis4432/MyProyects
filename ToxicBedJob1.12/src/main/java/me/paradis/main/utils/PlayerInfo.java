package me.paradis.main.utils;

import me.paradis.main.Main;
import org.bukkit.entity.Player;

public class PlayerInfo {

    public String getPlayerID(Player player){
        return String.valueOf(player.getUniqueId());
    }

    public Integer getAmountOfBeds(Player player){
        boolean allBedsFound = false;
        int bedsFound = 0;

        while(!allBedsFound){
            //gets the amount of beds the player placed
            if((Main.get().getConfig().get("beds." + getPlayerID(player) + ".bedsLocation." + (bedsFound + 1))) == null){
                allBedsFound = true;
            }else{
                bedsFound++;
            }
        }

        return bedsFound;
    }

    public String getPlayerWorld(Player player){
        return player.getWorld().getName();
    }

    public Integer getXLocation(Player player){
        return player.getLocation().getBlockX();
    }

    public Integer getYLocation(Player player){
        return player.getLocation().getBlockY();
    }

    public Integer getZLocation(Player player){
        return player.getLocation().getBlockZ();
    }

}
