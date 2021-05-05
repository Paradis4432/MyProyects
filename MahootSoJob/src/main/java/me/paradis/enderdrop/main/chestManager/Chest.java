package me.paradis.enderdrop.main.chestManager;

import me.paradis.enderdrop.main.Main;
import me.paradis.enderdrop.main.dragon.KillDragon;
import me.paradis.enderdrop.main.fireworkManager.SpawnFirework;
import me.paradis.enderdrop.main.locationsManager.GetLocationBlock;
import me.paradis.enderdrop.main.utils.Options;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;

public class Chest {

    public void placeChest() {
        //check the amount of chests placed with "admin.DoNotEdit.activeChests"
        if(new Options().getActiveChests() < new Options().getMaxChests()){
            //if the amount of chests placed are lower than  the max amount of chests
            if(new Options().getDebugMode())System.out.println("test6 placeChest called comparing getActiveChests < getMaxChests");
            if(new Options().getDebugMode())System.out.println("test6.1 getActiveChests: " + new Options().getActiveChests() + " < " +  new Options().getMaxChests());
            //return the inv of the chest placed
            Location loc = new GetLocationBlock().getLowestBlock();
            //sets the block to chest
            loc.getBlock().setType(Material.CHEST);
            //gets the inv of the block
            Block b = loc.getBlock();
            org.bukkit.block.Chest chest = (org.bukkit.block.Chest) b.getState();

            //fill the chest with items
            new FillChestWithItems().fillChest();

            //spawns firework
            new SpawnFirework().SpawnFireWork(loc);
            //adds 1 active chest
            Main.get().getConfig().set("admin.DoNotEdit.activeChests", (Main.get().getConfig().getInt("admin.DoNotEdit.activeChests")) + 1);
            if(new Options().getDebugMode()) System.out.println("test6.2 active chests: " + Main.get().getConfig().getInt("admin.DoNotEdit.activeChests"));
        }else{
            //kills  the ender dragon
            new KillDragon().KillEnderDragon();
        }
    }
}
