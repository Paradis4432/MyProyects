package me.paradis.main.events;

import me.paradis.main.Main;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ChestBrakeEvent implements Listener {

    @EventHandler
    public void onBrake(BlockBreakEvent event) {
        try {
            if (event.getBlock().getType() == Material.CHEST) {
                if (debugMode()) System.out.println("atemping to cancel block brake event , event: " + event);

                int totalLocs = new GetAllLocations().getLocs();

                if (debugMode()) System.out.println("total locs: " + totalLocs);

                for (int loc = 0; loc < totalLocs; loc++) {
                    if ((event.getBlock().getWorld() == Bukkit.getWorld(Main.get().getConfig().getString("locations." + loc + ".world"))) &&
                            (event.getBlock().getLocation().getBlockX() == Main.get().getConfig().getInt("locations." + loc + ".X")) &&
                            (event.getBlock().getLocation().getBlockY() == Main.get().getConfig().getInt("locations." + loc + ".Y")) &&
                            (event.getBlock().getLocation().getBlockZ() == Main.get().getConfig().getInt("locations." + loc + ".Z"))) {

                        if (!checkPerm(event.getPlayer(), "chest.brake") || !event.getPlayer().isOp()) {
                            event.setCancelled(true);
                            event.getPlayer().sendMessage(getCantBrakeMessage());
                        } else {
                            event.getPlayer().sendMessage("Permission chest.brake or op detected, braking chest");
                            new ChestManager().setDefaultValues(loc);
                        }

                    }
                }
            }
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public boolean checkPerm(Player player, String perm) {
        if (player.hasPermission(perm)) return true;
        else player.sendMessage(new Messages().noPermMessage());
        return false;
    }

    public String getCantBrakeMessage() {
        return new Messages().getCantBrakeThisBlockMessage();
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}

