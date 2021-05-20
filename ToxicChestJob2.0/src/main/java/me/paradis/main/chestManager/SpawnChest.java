package me.paradis.main.chestManager;

import me.paradis.main.Main;
import me.paradis.main.locationManager.get.GetAllLocations;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class SpawnChest {

    public void spawn(Integer locationID){
        int totalLocs = new GetAllLocations().get();

        if(Main.get().debugMode()) System.out.println("CHEST spawning locationID: " + locationID + " theres a total locs of: " + totalLocs);
        for(int loc = 0; loc < totalLocs; loc++){
            if(loc == locationID){
                //spawn chest
            }
        }
    }

    public void spawnLocation(Location location, Integer locationID){
        if(location.getBlock().getType() == Material.CHEST) replaceChest(location);
        //setDefaultValues(locationID);
        if(Main.get().debugMode()) System.out.println("CHEST spawned location " + locationID + " location: " + location);
    }

    public void spawnItems(){

    }

    public void replaceChest(Location location){
        clearInv(location);
        location.getBlock().setType(Material.AIR);
        location.getBlock().setType(Material.CHEST);
    }

    public void clearInv(Location location){
        Inventory inv = getInv(location);
        inv.clear();
    }

    public Inventory getInv(Location location){
        Block block = location.getBlock();
        Chest chest = (Chest) block.getState();
        return chest.getInventory();
    }

    /*


    public void setDefaultValues(Integer loc) {
        setSpawned(loc, true);
        setClicked(loc, false);
        setUnlocked(loc, false);
        new ChestInfo().setTimeLEft(loc, 10);
    }

     */
}
