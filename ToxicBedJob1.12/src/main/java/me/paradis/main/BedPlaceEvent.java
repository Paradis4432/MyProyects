package me.paradis.main;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Objects;
import java.util.UUID;

public class BedPlaceEvent implements Listener {

    @EventHandler
    public void onBedPlaceEvent(BlockPlaceEvent event){
        if(event.getBlock().getType().name().startsWith("BED_")){
            //gets the player info
            String id = getPlayerID(event.getPlayer());
            int amountOfBeds = getAmountOfBeds(event.getPlayer());

            //gets the location info
            int locX = event.getBlock().getX();
            int locY = event.getBlock().getY();
            int locZ = event.getBlock().getZ();
            String world = event.getBlock().getWorld().getName();

            //add bed to list

            //Bukkit.getLogger().info("id: " + id + " locX: " + locX + " locY: " + locY + " locZ: " + locZ + " Amount of beds: " + amountOfBeds);

            Main.get().getConfig().set("beds." + id + ".playerName", event.getPlayer().getName());
            Main.get().getConfig().set("beds." + id + ".bedsLocation." + (amountOfBeds+1) + ".world", world);
            Main.get().getConfig().set("beds." + id + ".bedsLocation." + (amountOfBeds+1) + ".X", locX);
            Main.get().getConfig().set("beds." + id + ".bedsLocation." + (amountOfBeds+1) + ".Y", locY);
            Main.get().getConfig().set("beds." + id + ".bedsLocation." + (amountOfBeds+1) + ".Z", locZ);

            Main.get().saveConfig();
        }
    }

    public String getPlayerID(Player player){
        return String.valueOf(player.getUniqueId());
    }

    public Integer getAmountOfBeds(Player player){
        boolean allBedsFound = false;
        int bedsFound = 0;

        while(!allBedsFound){
            //gets the amount of beds the player placed
            if((Main.get().getConfig().get("beds." + getPlayerID(player) + ".bedsLocation." + (bedsFound + 1))) == null){
                allBedsFound = true;
            }else{
                bedsFound++;
            }
        }

        return bedsFound;
    }
}
