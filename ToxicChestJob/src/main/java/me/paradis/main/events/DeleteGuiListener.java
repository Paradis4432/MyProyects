package me.paradis.main.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DeleteGuiListener implements Listener {

    @EventHandler
    public void onGuiClick(InventoryClickEvent event){
        if(event.getView().getTitle().equals("Choose what to delete")){
            Player player = (Player) event.getWhoClicked();
            player.sendMessage("test");
            event.setCancelled(true);
            if(event.getCurrentItem().getType() == Material.COMPASS){
                player.sendMessage("test1");
                //make player run command
            }
        }
    }
}
