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

public class RemoveLocation {

    public void remove(Player player, ItemStack clickedItem) {
        try {
            //removes the location in the config file and calls chestmanager.delete
            String[] id = clickedItem.getItemMeta().getDisplayName().split(":");
            List<String> nameValues = new ArrayList<String>(Arrays.asList(id));

            String chestId = nameValues.get(1).replaceAll("\\s", "");

            int finalId = Integer.parseInt(chestId);

            new ChestManager().delete(finalId);

            //remove finalId from config file
            replace(finalId, "world");
            replace(finalId, "X");
            replace(finalId, "Y");
            replace(finalId, "Z");
            replace(finalId, "spawned");
            replace(finalId, "unlocked");
            replace(finalId, "clicked");
            replace(finalId, "timeleft");

            int allLocs = new GetAllLocations().getLocs();

            Main.get().getConfig().set("locations." + (allLocs - 1), null);

            Main.get().saveConfig();

            if (debugMode()) System.out.println("location removed, total locs: " + allLocs);
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public void replace(Integer locId, String toReplace) {
        int allLocs = new GetAllLocations().getLocs();

        for (int i = locId; i <= allLocs; i++) {
            if (i != allLocs) {
                Main.get().getConfig().set("locations." + locId + "." + toReplace, Main.get().getConfig().get("locations." + (locId + 1) + "." + toReplace));
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
