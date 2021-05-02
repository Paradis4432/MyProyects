package me.paradis.main.utils;

import me.paradis.main.Main;

public class Respawn {

    public String getWorldRespawn(Integer currentLocation){
        return Main.get().getConfig().getString("respawnLocations." + currentLocation + ".world");
    }

    public Integer getXRespawnLocation(Integer currentLocation){
        return Main.get().getConfig().getInt("respawnLocations." + currentLocation + ".X");
    }

    public Integer getYRespawnLocation(Integer currentLocation){
        return Main.get().getConfig().getInt("respawnLocations." + currentLocation + ".Y");
    }

    public Integer getZRespawnLocation(Integer currentLocation){
        return Main.get().getConfig().getInt("respawnLocations." + currentLocation + ".Z");
    }

}
