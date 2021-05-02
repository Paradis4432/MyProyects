package me.paradis.main.events;

import me.paradis.main.utils.Names;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class InvDragEvent implements Listener {


    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event){
        if (event.getView().getTitle().equals(new Names().getTitleName())) {
            //cancels the event
            event.setCancelled(true);
        }
    }
}
