package me.paradis.main.lootManager.get;

import me.paradis.main.Main;

public class GetAllLootsFromLocation {
    /**
     *
     * @param locationID the chest / location to get the loots from
     * @return all loots in that location
     */

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
