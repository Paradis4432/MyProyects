package me.paradis.main.respawnManager;

import me.paradis.main.Main;

public class RemoveLocation {

    public void removeLocation(Integer id){
        int locations = new RespawnLocations().getAllLocations();
        locations--;
        //System.out.println("locations: " + locations + " id: " + id );
        for(int i = id; i <= locations; i++){
            if(i != locations){
                //System.out.println("i != location");
                Main.get().getConfig().set("respawnLocations." + i + ".world" , Main.get().getConfig().get("respawnLocations." + (i+1) + ".world"));
                Main.get().getConfig().set("respawnLocations." + i + ".X" , Main.get().getConfig().get("respawnLocations." + (i+1) + ".X"));
                Main.get().getConfig().set("respawnLocations." + i + ".Y" , Main.get().getConfig().get("respawnLocations." + (i+1) + ".Y"));
                Main.get().getConfig().set("respawnLocations." + i + ".Z" , Main.get().getConfig().get("respawnLocations." + (i+1) + ".Z"));

            }else{
                Main.get().getConfig().set("respawnLocations." + i, null);
            }
        }
        Main.get().saveConfig();
    }
}
