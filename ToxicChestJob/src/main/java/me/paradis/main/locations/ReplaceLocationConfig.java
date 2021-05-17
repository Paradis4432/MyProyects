package me.paradis.main.locations;

import me.paradis.main.Main;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceLocationConfig {

    public void replace(Player player, ItemStack clickedItem) {
        try {
            if (debugMode()) System.out.println("attempting to replace location");
            int totalLocs = new GetAllLocations().getLocs();

            for (int loc = 0; loc < totalLocs; loc++) {

                String[] id = clickedItem.getItemMeta().getDisplayName().split(":");
                List<String> nameValues = new ArrayList<String>(Arrays.asList(id));

                String chestId = nameValues.get(1).replaceAll("\\s", "");

                int finalId = Integer.parseInt(chestId);

                if (finalId == loc) {

                    if (debugMode())
                        System.out.println("attemping to replace chest, final id: " + finalId + " chest loc id " + loc);

                    Main.get().getConfig().set("locations." + loc + ".world", player.getWorld().getName());
                    Main.get().getConfig().set("locations." + loc + ".X", player.getLocation().getBlockX());
                    Main.get().getConfig().set("locations." + loc + ".Y", player.getLocation().getBlockY());
                    Main.get().getConfig().set("locations." + loc + ".Z", player.getLocation().getBlockZ());
                    Main.get().getConfig().set("locations." + loc + ".spawned", false);
                    Main.get().getConfig().set("locations." + loc + ".unlocked", false);
                    Main.get().getConfig().set("locations." + loc + ".clicked", false);
                    Main.get().getConfig().set("locations." + loc + ".timeleft", 0);

                    new ChestManager().spawn(loc);

                    player.updateInventory();

                    return;
                }
            }

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
