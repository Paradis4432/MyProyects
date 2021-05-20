package me.paradis.main.GUIs.generalGUI;

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
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateGeneralGUI implements Listener {

    public Inventory build() {
        int size = 54;

        Inventory inv = Bukkit.createInventory(null, size, "Click here the action you want to do");

        inv = new AddBorderItems().fill(inv, size);
        inv = addGeneralItems(inv);
        inv = new AddBackGroundItems().add(inv, size);

        return inv;
    }

    public Inventory addGeneralItems(Inventory inv) {
        ItemStack add = new ItemGenerator().createItem(Material.ENDER_CHEST, 1, ChatColor.GOLD + "Click here to add items,loot or locations!");
        ItemStack remove = new ItemGenerator().createItem(Material.BARRIER , 1, ChatColor.GOLD + "Click here to remove items,loot or locations!");
        ItemStack list = new ItemGenerator().createItem(Material.PAPER , 1, ChatColor.GOLD + "Click here to list loots or locations!");
        ItemStack replace = new ItemGenerator().createItem(Material.CHEST , 1, ChatColor.GOLD + "Click here to replace a location!");

        inv.setItem(21,add);
        inv.setItem(22,remove);
        inv.setItem(23,list);
        inv.setItem(31,replace);

        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        ItemStack clickedItem = event.getCurrentItem();

        if((event.getView().getTitle().equals("Click here the action you want to do"))){
            if(clickedItem == null || clickedItem.getType() == Material.AIR) return;
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            if(clickedItem.getType() == Material.ENDER_CHEST) player.performCommand("chest add");
            if(clickedItem.getType() == Material.BARRIER) player.performCommand("chest remove");
            if(clickedItem.getType() == Material.PAPER) player.performCommand("chest list");
            if(clickedItem.getType() == Material.CHEST) player.performCommand("chest replace");
        }

    }
}
