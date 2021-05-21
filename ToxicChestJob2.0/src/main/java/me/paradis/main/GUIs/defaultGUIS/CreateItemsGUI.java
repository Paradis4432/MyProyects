package me.paradis.main.GUIs.defaultGUIS;

import me.paradis.main.Main;
import me.paradis.main.itemManager.get.GetAllItemsFromLoot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateItemsGUI {
    public Inventory buidItems(Inventory inv, Integer pageId){
        /*
        int totalItems = new GetAllItemsFromLoot().get();
        int slots = pageId * 29;
        int totalItemsToDosplay = Math.min(totalItems,slots);

        for(int item = (slots - 29); item < totalItemsToDosplay; item++){
            ItemStack itemStack = Main.get().getConfig().getItemStack("");

            inv.setItem(inv.firstEmpty(), itemStack);
        }


         */
        return inv;
    }


}
