package me.paradis.main.events;

import me.paradis.main.locations.RemoveLocation;
import me.paradis.main.teleport.TeleportPlayerToLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class RemoveLocationListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        //get inv name if clicked item isint null or air, check the item name, if left click teleport to location
        //if right click delete location
        if(event.getView().getTitle().equals("remove location")){
            ItemStack clickedItem = event.getCurrentItem();
            if(clickedItem == null || clickedItem.getType() == Material.AIR) return;

            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();

            if(event.getClick() == ClickType.LEFT){
                new TeleportPlayerToLocation().teleport(player,clickedItem);
            }
            if(event.getClick() == ClickType.RIGHT){
                new RemoveLocation().remove(player,clickedItem);
            }
        }
    }
}
