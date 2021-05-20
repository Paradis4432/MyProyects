package me.paradis.main.GUIs.defaultGUIS;

import me.paradis.main.Main;
import me.paradis.main.itemManager.get.GetAllItems;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateLootsGUI {

    public Inventory buildItems(Inventory inv, Integer pageId){
        int totalLoots = new GetAllItems().get();
        int slots = pageId * 29;
        int totalLootsToDisplay = Math.min(totalLoots,slots);

        for(int loot = (slots - 29); loot < totalLootsToDisplay; loot++){
            ItemStack itemStack = Main.get().getConfig().getItemStack("");

            inv.setItem(inv.firstEmpty(), itemStack);
        }

        return inv;
    }
}
