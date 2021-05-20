package me.paradis.main.GUIs.addGUI;

import me.paradis.main.GUIs.Items.ItemGenerator;
import me.paradis.main.GUIs.Items.defaultItems.AddBackGroundItems;
import me.paradis.main.GUIs.Items.fillItems.AddBorderItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateAddGUI implements Listener {

    public Inventory build() {
        int size = 54;

        Inventory inv = Bukkit.createInventory(null, size, "Click here what you want to add");

        inv = new AddBorderItems().fill(inv, size);
        inv = addGeneralItems(inv);
        inv = new AddBackGroundItems().add(inv, size);

        return inv;
    }

    public Inventory addGeneralItems(Inventory inv) {
        ItemStack location = new ItemGenerator().createItem(Material.COMPASS, 1, ChatColor.GOLD + "Click here to add a location!");
        ItemStack item = new ItemGenerator().createItem(Material.CHEST , 1, ChatColor.GOLD + "Click here to add an item");

        inv.setItem(22,location);
        inv.setItem(23,item);

        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        ItemStack clickedItem = event.getCurrentItem();

        if((event.getView().getTitle().equals("Click here what you want to add"))){
            if(clickedItem == null || clickedItem.getType() == Material.AIR) return;
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            if(clickedItem.getType() == Material.COMPASS) player.performCommand("chest add location");
            if(clickedItem.getType() == Material.CHEST) player.performCommand("chest add item");
        }

    }
}
