package me.paradis.main.locations;

import me.paradis.main.Main;

public class GetAllLocations {

    public Integer getLocs(){
        boolean allLocsFound = false;
        int locs = 0;
        while(!allLocsFound){
            if( (Main.get().getConfig().get("locations." + locs)) == null){
                allLocsFound = true;
            }else{
                locs++;
            }
        }
        return locs;
    }
}
