package me.paradis.main.locationManager.addLocation;

import me.paradis.main.Main;
import me.paradis.main.Messages.GetMessage;
import me.paradis.main.chestManager.SpawnChest;
import me.paradis.main.locationManager.get.GetAllLocations;
import org.bukkit.entity.Player;

public class AddLocationCommand {

    public void add(Player player){

        if(Main.get().debugMode()) System.out.println("CHEST adding location");

        Integer locId = new GetAllLocations().get();

        Main.get().getConfig().set("locations." + locId + ".world", player.getWorld().getName());
        Main.get().getConfig().set("locations." + locId + ".X", player.getLocation().getBlockX());
        Main.get().getConfig().set("locations." + locId + ".Y", player.getLocation().getBlockY());
        Main.get().getConfig().set("locations." + locId + ".Z", player.getLocation().getBlockZ());
        Main.get().getConfig().set("locations." + locId + ".spawned", false);
        Main.get().getConfig().set("locations." + locId + ".unlocked", false);
        Main.get().getConfig().set("locations." + locId + ".clicked", false);
        Main.get().getConfig().set("locations." + locId + ".timeleft", 0);

        Main.get().saveConfig();

        new SpawnChest().spawnLocation(player.getLocation(),locId);

        if(Main.get().debugMode()) System.out.println("CHEST location added");

        player.sendMessage(new GetMessage().get("locationAdded"));
    }
}
