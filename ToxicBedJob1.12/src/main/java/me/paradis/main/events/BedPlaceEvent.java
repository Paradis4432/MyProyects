package me.paradis.main.events;

import me.paradis.main.limitManager.BiggestLimit;
import me.paradis.main.Main;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.PlayerInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BedPlaceEvent implements Listener {

    @EventHandler
    public void onBedPlaceEvent(BlockPlaceEvent event){
        if(event.getBlock().getType().name().startsWith("BED_")){
            //gets the player info
            String id = new PlayerInfo().getPlayerID(event.getPlayer());
            int amountOfBeds = new PlayerInfo().getAmountOfBeds(event.getPlayer());
            Player player = event.getPlayer();
            int limit = new BiggestLimit().getLimit(player);
            if(limit > amountOfBeds || player.isOp()){
                System.out.println("test 6 limit not reached");
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

                event.getPlayer().sendMessage(new Messages().getBedPlacedMessage());
            }else{
                player.sendMessage(new Messages().getMaxBedsPlaced());
                event.setCancelled(true);
            }

        }
    }
}
