package me.paradis.main.lootManager.get;

import me.paradis.main.Main;

public class GetAllLootsFromLocation {

    public Integer get(int locationID){
        boolean allLootsFound = false;
        int loots = 0;
        while(!allLootsFound){
            if( (Main.get().getConfig().get("locations." + locationID + ".loots." + (loots+1))) == null){
                allLootsFound = true;
            }else{
                loots++;
            }
        }
        return loots;
    }
}
