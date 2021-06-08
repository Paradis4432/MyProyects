package me.paradis.movingparticle.SchedulerManager;

import me.paradis.movingparticle.configManager.Config;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class CreateHashMap {

    /**
     * creates a hashmap with all active particles, where key is player UUID and value is String of Particle name
     */

    HashMap<UUID, Particle> playerParticle = new HashMap<>();

    /**
     * saves current hashmap into config file
     */
    public void save(){

        for(Object key : playerParticle.keySet()){
            new Config().set("HashMap." + key,playerParticle.get(key));
        }
        new Config().save();
    }
    /**
     * loads the info from the config to the hashmap
     */
    public void load(){
        for(Object key : new Config().getConfigSection("HashMap",false)){
            playerParticle.put((UUID) key, (Particle) new Config().get("HashMap." + key));
        }
    }
    /**
     * get the hashmap
     */
    public HashMap<UUID, Particle> getHashMap(){
        return playerParticle;
    }
    /**
     * adds values to hashmap
     */
    public void put(UUID uuid, Particle particle){
        System.out.println("putting " + uuid + "  " + particle);
        playerParticle.put(uuid,particle);
    }
}