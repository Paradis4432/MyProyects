package me.paradis.main.chest;

import me.paradis.main.Main;
import me.paradis.main.items.AddItemsToChest;
import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.ChestInfo;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class ChestManager {

    public void spawn(){
        int totalLocs = new GetAllLocations().getLocs();

        for(int loc = 0; loc < totalLocs; loc++){
            Location spawnChest = new Location(Bukkit.getWorld(world(loc)) , X(loc) , Y(loc) , Z(loc));

            if(spawnChest.getBlock().getType() == Material.CHEST) return;

            spawnChest.getBlock().setType(Material.CHEST);

            setSpawned(loc,true);
            setClicked(loc,false);
            setUnlocked(loc,false);
            new ChestInfo().setTimeLEft(loc,10);

            Main.get().saveConfig();

            //add items
            new AddItemsToChest().add(spawnChest);

            System.out.println("chest spawned at " + spawnChest);
        }
    }

    public void forceId(Integer chestId){
        int totalLocs = new GetAllLocations().getLocs();

        for(int loc = 0; loc < totalLocs; loc++){
            if(loc == chestId) {
                Location spawnChest = new Location(Bukkit.getWorld(world(loc)), X(loc), Y(loc), Z(loc));

                if (spawnChest.getBlock().getType() == Material.CHEST) return;

                spawnChest.getBlock().setType(Material.CHEST);

                setSpawned(loc, true);
                setClicked(loc, false);
                setUnlocked(loc, false);
                new ChestInfo().setTimeLEft(loc, 10);

                Main.get().saveConfig();

                //add items
                new AddItemsToChest().add(spawnChest);

                System.out.println("chest spawned at " + spawnChest);
            }
        }
    }
    //if timer enabled
    /*
    if spawned == false and cd(timeleft) >=1:
        cd --
    if spawned == false and cd== 0:
        spawn the chest
        set spawned == true
        set clicked == false
        set unblocked == false
        set timeleft == lockedTime(cd, timeleft) == 10
    on click chest:
        if unblocked == false:
            clicked == true
        else:
            open
            wait (delete time) 5 seconds
            delete chest
            set spawned to false
            set cd == 10 (respawn time)
    if spawned == true and clicked == true and unblocked == false and timeleft >= 1:
        cd--
    if spawned == true and clicked == true and unblocked == false and timeleft == 0:
        unblocked == true
     */

    public void delete(Integer chestId){
        int totalLocs = new GetAllLocations().getLocs();

        for(int loc = 0; loc < totalLocs; loc++){

            if(loc == chestId){
                Location delete = new Location(Bukkit.getWorld(world(loc)) , X(loc) , Y(loc) , Z(loc));

                if(delete.getBlock().getType() == Material.AIR) return;

                delete.getBlock().setType(Material.AIR);
                System.out.println("chest deleted at " + delete);
            }
        }
    }

    public void setClicked(Integer chestId, Boolean set){
        new ChestInfo().setClicked(chestId,false);
    }
    public void setSpawned(Integer chestId, Boolean set){
        new ChestInfo().setSpawned(chestId,set);
    }

    public void setUnlocked(Integer chestId, Boolean set){
        new ChestInfo().setUnlocked(chestId,set);
    }

    public String world(Integer chestId){
        return new ChestInfo().getWorld(chestId);
    }

    public Integer X(Integer chestId){
        return new ChestInfo().getXlocation(chestId);
    }

    public Integer Y(Integer chestId){
        return new ChestInfo().getYlocation(chestId);
    }

    public Integer Z(Integer chestId){
        return new ChestInfo().getZlocation(chestId);
    }
}
