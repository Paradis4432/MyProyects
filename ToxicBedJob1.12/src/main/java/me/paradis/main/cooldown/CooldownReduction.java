package me.paradis.main.cooldown;

import me.paradis.main.Main;
import me.paradis.main.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public class CooldownReduction {

    public void bedsCooldown() { //DEBUG
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncRepeatingTask(Main.get(), new Runnable() {
            @Override
            public void run() {
                try {
                    //loops all the beds
                    for (String key : Objects.requireNonNull(Main.get().getConfig().getConfigurationSection("activeBeds")).getKeys(false)) {
                        for (String currentID : Objects.requireNonNull(Main.get().getConfig().getConfigurationSection("activeBeds." + key)).getKeys(false)) {
                            int cd = getCurrentCD(key, currentID);
                            if (cd == 0) {
                                Main.get().getConfig().set("activeBeds." + key + "." + currentID, null);
                                //send message maybe?
                            } else {
                                Main.get().getConfig().set("activeBeds." + key + "." + currentID, (cd - 1));
                            }
                            Main.get().saveConfig();
                        }
                    }
                } catch (Exception e) {
                    Bukkit.getLogger().info(new Messages().getErrorMessage() + e + " CooldownReduction");

                }
            }
        }, 0L, 20L);
    }

    public Integer getCurrentCD(String key, String currentID) {
        return Main.get().getConfig().getInt("activeBeds." + key + "." + currentID);
    }
}

