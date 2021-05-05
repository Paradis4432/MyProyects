package me.paradis.enderdrop.main.dragon;

import me.paradis.enderdrop.main.Main;
import me.paradis.enderdrop.main.utils.Locations;
import me.paradis.enderdrop.main.utils.Messages;
import me.paradis.enderdrop.main.utils.Options;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import static org.bukkit.Bukkit.getServer;

public class SpawnDragon {


    public void SpawnEnderDragon(){
        if(new Options().getDebugMode())System.out.println("spawning ender dragon");
        //spawns ender dragon in the spawn location from config
            System.out.println("test2");
            //broadcast a message to all players
            getServer().broadcastMessage(new Messages().getBroadcastMessage());
            //gets the spawn location where the dragon will spawn
            Location spawnLocation = new Location(Bukkit.getWorld(new Locations().getWorldSpawn()),new Locations().getXSpawn(),new Locations().getYSpawn(),new Locations().getZSpawn());
            World w = Bukkit.getServer().getWorld(new Locations().getWorldSpawn());
            if(w == null)return;
            Entity enderDragon = w.spawnEntity(spawnLocation, EntityType.ENDER_DRAGON);

            //sets the phase
            for(Entity e : w.getEntities()){
                if(e instanceof EnderDragon){
                    ((EnderDragon)e).setPhase(EnderDragon.Phase.CIRCLING);
                }
            }
        if(new Options().getDebugMode())System.out.println("ender dragon spawned");
    }
}
