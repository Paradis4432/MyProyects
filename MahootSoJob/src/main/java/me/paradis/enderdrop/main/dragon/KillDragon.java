package me.paradis.enderdrop.main.dragon;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;

public class KillDragon {

    public void KillEnderDragon(){
        //add in death event force = false
        //add in death event timeLeft = 0
        World w = Bukkit.getServer().getWorld(getWorldSpawn());
        if(w == null)return;

        for(Entity e : w.getEntities()){
            if(e instanceof EnderDragon){
                ((EnderDragon)e).setPhase(EnderDragon.Phase.DYING);
            }
        }
        //sets the active chests to 0,isAlive to false and force to false
        Main.get().getConfig().set("admin.DoNotEdit.timeLeft", 0);
        Main.get().getConfig().set("admin.DoNotEdit.isAlive",false);
        Main.get().getConfig().set("admin.DoNotEdit.force",false);
        Main.get().getConfig().set(String.valueOf(getActiveChests()), 0);
        Main.get().saveConfig();
    }
}
