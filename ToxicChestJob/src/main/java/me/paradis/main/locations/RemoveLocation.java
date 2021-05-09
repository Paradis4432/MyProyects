package me.paradis.main.locations;

import me.paradis.main.GUI.OpenRemoveLocationGui;
import me.paradis.main.Main;
import me.paradis.main.utils.VarType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveLocation {

    public void remove(Player player, ItemStack clickedItem) {
        //removes the location in the config file and calls chestmanager.delete
        String[] id = clickedItem.getItemMeta().getDisplayName().split(":");
        List<String> nameValues = new ArrayList<String>(Arrays.asList(id));

        String chestId = nameValues.get(1).replaceAll("\\s", "");

        int finalId = Integer.parseInt(chestId);

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
        System.out.println(allLocs);
        Main.get().getConfig().set("locations." + (allLocs-1), null);

        Main.get().saveConfig();

        player.closeInventory();
        new OpenRemoveLocationGui().open(player);
    }

    public void replace(Integer locId, String toReplace) {
        int allLocs = new GetAllLocations().getLocs();

        for (int i = locId; i <= allLocs; i++) {
            if (i != allLocs) {
                Main.get().getConfig().set("locations." + locId + "." + toReplace, Main.get().getConfig().get("locations." + (locId + 1) + "." + toReplace));
            }
        }
    }
}
