package me.paradis.main.locations;

import me.paradis.main.Main;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import org.bukkit.entity.Player;

public class AddLocationManager {

    public void addLocation(Player player) {
        try {
            //get the player location and save it to spawn the chest there

            Integer locId = new GetAllLocations().getLocs();

            Main.get().getConfig().set("locations." + locId + ".world", player.getWorld().getName());
            Main.get().getConfig().set("locations." + locId + ".X", player.getLocation().getBlockX());
            Main.get().getConfig().set("locations." + locId + ".Y", player.getLocation().getBlockY());
            Main.get().getConfig().set("locations." + locId + ".Z", player.getLocation().getBlockZ());
            Main.get().getConfig().set("locations." + locId + ".spawned", false);
            Main.get().getConfig().set("locations." + locId + ".unlocked", false);
            Main.get().getConfig().set("locations." + locId + ".clicked", false);
            Main.get().getConfig().set("locations." + locId + ".timeleft", 0);

            new ChestManager().spawn(locId);

            if(debugMode()) System.out.println("location saved chest spawned");

            Main.get().saveConfig();

            player.sendMessage(new Messages().getLocationAddedMessage());
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}