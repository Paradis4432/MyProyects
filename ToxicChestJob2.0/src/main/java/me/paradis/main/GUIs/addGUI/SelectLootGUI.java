package me.paradis.main.GUIs.addGUI;

import me.paradis.main.GUIs.Items.ItemGenerator;
import me.paradis.main.GUIs.Items.defaultItems.AddBackGroundItems;
import me.paradis.main.GUIs.Items.fillItems.AddBorderItems;
import me.paradis.main.GUIs.defaultGUIS.CreateItemsGUI;
import me.paradis.main.GUIs.defaultGUIS.CreateLootsGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SelectLootGUI implements Listener {

    public Inventory build(int pageID) {
        int size = 54;

        Inventory inv = Bukkit.createInventory(null, size, "Click in what loot you want to add the item");

        inv = new AddBorderItems().fill(inv, size);
        inv = new CreateLootsGUI().buildItems(inv,pageID);
        inv = new AddBackGroundItems().add(inv, size);

        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        ItemStack clickedItem = event.getCurrentItem();

        if((event.getView().getTitle().equals("Click in what loot you want to add the item"))){
            if(clickedItem == null || clickedItem.getType() == Material.AIR) return;
            event.setCancelled(true);
        }

    }
}
