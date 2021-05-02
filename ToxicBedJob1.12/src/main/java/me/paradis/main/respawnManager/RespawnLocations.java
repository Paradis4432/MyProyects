package me.paradis.main.respawnManager;

import me.paradis.main.Main;

public class RespawnLocations {

    public Integer getAllLocations(){
        boolean allLocationsFound = false;
        int locationsFound = 0;
        while(!(allLocationsFound)){
            if((Main.get().getConfig().get("respawnLocations." + (locationsFound + 1))) == null){
                allLocationsFound = true;
            }else{
                locationsFound++;
            }
        }
        return locationsFound + 1;
    }
}
