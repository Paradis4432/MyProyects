package me.paradis.main.GUIs.defaultGUIS;

import me.paradis.main.Main;
import me.paradis.main.itemManager.get.GetAllItems;
import me.paradis.main.locationManager.get.GetAllLocations;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateLocationsGUI {

    public Inventory buildLocations(Inventory inv, Integer pageId){
        int totalLocs = new GetAllLocations().get();
        int slots = pageId * 29;
        int totalLocsToDisplay = Math.min(totalLocs,slots);

        for(int loc = (slots - 29); loc < totalLocsToDisplay; loc++){
            ItemStack itemStack = Main.get().getConfig().getItemStack("");

            inv.setItem(inv.firstEmpty(), itemStack);
        }

        return inv;
    }
}
