package com.infinitycraft.plugin.general.essentials.automatedEvents;

import com.infinitycraft.plugin.general.storageManager.SQLDatabase;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;

public class PlayTime extends BukkitRunnable{
        @Override
        public void run() {
            try (PreparedStatement increaseTime = SQLDatabase.connection.prepareStatement("UPDATE players set playTime = players.playTime+1 where online = true")) {
                increaseTime.execute();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
}
