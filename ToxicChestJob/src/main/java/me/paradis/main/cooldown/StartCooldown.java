package me.paradis.main.cooldown;

import me.paradis.main.Main;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.ChestInfo;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

public class StartCooldown {

    //if loc is not a chest spawn a chest

    public void start() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncRepeatingTask(Main.get(), new Runnable() {
            @Override
            public void run() {
                try {
                    int totalLocs = new GetAllLocations().getLocs();

                    for (int loc = 0; loc < totalLocs; loc++) {

                        if(!getSpawned(loc) && timeLeft(loc) >= 1){
                            setTimeLeft(loc, (timeLeft(loc)-1));
                        } else if (!getSpawned(loc) && timeLeft(loc) == 0){
                            new ChestManager().spawn();
                        } else if (getSpawned(loc) && clicked(loc) && (!getUnlocked(loc)) && timeLeft(loc) >= 1){
                            setTimeLeft(loc, (timeLeft(loc)-1));
                        } else if (getSpawned(loc) && clicked(loc) && (!getUnlocked(loc)) && timeLeft(loc) == 0){
                            setUnlocked(loc,true);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }, 0L, 20L);
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
            set clicked == false
            set unblocked == false
            set cd == 10 (respawn time)
    if spawned == true and clicked == true and unblocked == false and timeleft >= 1:
        cd--
    if spawned == true and clicked == true and unblocked == false and timeleft == 0:
        unblocked == true
     */

    public boolean clicked(Integer chestId){
        return new ChestInfo().getClicked(chestId);
    }
    public boolean getSpawned(Integer chestId) {
        return new ChestInfo().getSpawned(chestId);
    }

    public boolean getUnlocked(Integer chestId) {
        return new ChestInfo().getUnlocked(chestId);
    }

    public Integer timeLeft(Integer chestId) {
        return new ChestInfo().getTimeLeft(chestId);
    }

    public void setTimeLeft(Integer chestId, Integer cd) {
        new ChestInfo().setTimeLEft(chestId, cd);
    }

    public Integer cd() {
        return new ChestInfo().getCd();
    }

    public void setUnlocked(Integer chestId, Boolean set) {
        new ChestInfo().setUnlocked(chestId, set);
    }
}
