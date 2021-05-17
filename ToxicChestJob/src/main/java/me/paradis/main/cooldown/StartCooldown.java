package me.paradis.main.cooldown;

import me.paradis.main.Main;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.ChestInfo;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
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

                        //if (debugMode())
                        //  System.out.println("chest ID: " + loc + " is spawned: " + getSpawned(loc) + " time left: " + timeLeft(loc) +
                        //        " is clicked: " + clicked(loc) + " is unlocked: " + getUnlocked(loc));

                        if (!getSpawned(loc) && timeLeft(loc) >= 1) {
                            setTimeLeft(loc, (timeLeft(loc) - 1));
                            if (debugMode()) System.out.println("time left -- for" + loc);
                        } else if (!getSpawned(loc) && timeLeft(loc) == 0) {
                            if (debugMode()) System.out.println("atemping to spawn the chest for " + loc);
                            new ChestManager().spawn(loc);
                        } else if (getSpawned(loc) && clicked(loc) && (!getUnlocked(loc)) && timeLeft(loc) >= 1) {
                            if (debugMode())
                                System.out.println("time left -- for (second check, spawned && !unlocked && timeleft >= 1 && clicked" + loc);
                            setTimeLeft(loc, (timeLeft(loc) - 1));
                        } else if (getSpawned(loc) && clicked(loc) && (!getUnlocked(loc)) && timeLeft(loc) == 0) {
                            if (debugMode()) System.out.println("attemping to unlock chest " + loc);
                            setUnlocked(loc, true);
                        }
                    }
                } catch (Exception e) {
                    if (debugMode()) {
                        String name = String.valueOf(this.getClass());
                        getErrorMessage(name, e);
                    }
                }
            }
        }, 0L, 20L);
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }

    public boolean clicked(Integer chestId) {
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
