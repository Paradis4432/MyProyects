package me.paradis.main.chest;

import me.paradis.main.Main;

public class GetAllChests {

    public Integer get(){
         boolean allChestsFound = false;
         int chests = 0;

         while(!allChestsFound){
             if ((Main.get().getConfig().get("chest." + (chests + 1))) == null) allChestsFound = true;
             else chests++;
         }
         return chests;
    }
}
