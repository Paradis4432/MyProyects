package me.paradis.movingparticle.particleManager;

import me.paradis.movingparticle.SchedulerManager.CreateHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class SpawnParticleOnPlayer {

    /**
     * taking the hashMap created in CreateHashMap it spawns the particle
     * where particle is the Value of the Key (uuid of player)
     */
    public void spawn(){
        HashMap<UUID, Particle> list = getHash();
        System.out.println("Spawn particle on player - spawn called");
        for(Player player : Bukkit.getOnlinePlayers()){
            System.out.println("List: " + list);
            System.out.println("Player found " + player);
            UUID uuid = player.getUniqueId();
            Particle particle = list.get(uuid);
            System.out.println("Particle spawning: " + particle);

            player.spawnParticle(particle,player.getLocation(), 2);
        }
    }

    public HashMap<UUID,Particle> getHash(){
        return new CreateHashMap().getHashMap();
    }
}
