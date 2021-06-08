package me.paradis.movingparticle.SchedulerManager;

import me.paradis.movingparticle.MovingParticle;
import me.paradis.movingparticle.particleManager.SpawnParticleOnPlayer;
import org.bukkit.Bukkit;

public class StartSchedule {

    /**
     * a scheduler to spawn particles on location of each player, using the hashmap<UUID, String> where string is the
     * particle
     */
    public void start(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MovingParticle.getInstance(), () -> new SpawnParticleOnPlayer().spawn(), 0L,20L);
    }
}
