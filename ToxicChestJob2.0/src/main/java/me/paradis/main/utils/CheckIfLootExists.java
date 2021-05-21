package me.paradis.main.utils;

import me.paradis.main.Main;

public class CheckIfLootExists {

    public boolean check(int locID,int lootID){
        return (Main.get().getConfig().get("locations." + locID + ".loots." + lootID)) != null;
    }
}
