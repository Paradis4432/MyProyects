package me.paradis.main.chest;

import me.paradis.main.Main;
import me.paradis.main.items.AddItemsToChest;
import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.ChestInfo;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class ChestManager {

    public void spawn(Integer chestId) {
        try {
            int totalLocs = new GetAllLocations().getLocs();

            for (int loc = 0; loc < totalLocs; loc++) {
                if (loc == chestId) {
                    Location spawnChest = new Location(Bukkit.getWorld(world(loc)), X(loc), Y(loc), Z(loc));

                    if (spawnChest.getBlock().getType() == Material.CHEST) return;

                    spawnChest.getBlock().setType(Material.CHEST);

                    setDefaultValues(loc);

                    Main.get().saveConfig();

                    //add items
                    new AddItemsToChest().add(spawnChest);

                    if (debugMode()) System.out.println("chest spawned at " + loc);
                }
            }
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public void setDefaultValues(Integer loc) {
        setSpawned(loc, true);
        setClicked(loc, false);
        setUnlocked(loc, false);
        new ChestInfo().setTimeLEft(loc, 10);
    }


    public void forceId(Integer chestId) {
        try {
            int totalLocs = new GetAllLocations().getLocs();

            for (int loc = 0; loc < totalLocs; loc++) {
                if (loc == chestId) {
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

                    if (debugMode()) System.out.println("chest forced at " + loc);
                }
            }
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }


    public void delete(Integer chestId) {
        try {
            int totalLocs = new GetAllLocations().getLocs();

            for (int loc = 0; loc < totalLocs; loc++) {

                if (loc == chestId) {
                    Location delete = new Location(Bukkit.getWorld(world(loc)), X(loc), Y(loc), Z(loc));

                    if (delete.getBlock().getType() == Material.AIR) return;

                    if (delete.getBlock().getType() == Material.CHEST) {
                        Block b = delete.getBlock();
                        Chest chest = (Chest) b.getState();
                        Inventory inv = chest.getInventory();
                        inv.clear();
                    }

                    delete.getBlock().setType(Material.AIR);

                    if (debugMode()) System.out.println("chest deleted at " + loc);
                }
            }
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }

    public void setClicked(Integer chestId, Boolean set) {
        new ChestInfo().setClicked(chestId, false);
    }

    public void setSpawned(Integer chestId, Boolean set) {
        new ChestInfo().setSpawned(chestId, set);
    }

    public void setUnlocked(Integer chestId, Boolean set) {
        new ChestInfo().setUnlocked(chestId, set);
    }

    public String world(Integer chestId) {
        return new ChestInfo().getWorld(chestId);
    }

    public Integer X(Integer chestId) {
        return new ChestInfo().getXlocation(chestId);
    }

    public Integer Y(Integer chestId) {
        return new ChestInfo().getYlocation(chestId);
    }

    public Integer Z(Integer chestId) {
        return new ChestInfo().getZlocation(chestId);
    }
}
