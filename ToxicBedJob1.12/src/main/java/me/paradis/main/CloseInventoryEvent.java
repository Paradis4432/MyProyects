package me.paradis.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.Objects;

public class CloseInventoryEvent implements Listener {

    @EventHandler
    public void onInvClose(InventoryCloseEvent event){
        if(event.getView().getTitle().equals(getTitleName())){
            Player player = (Player) event.getPlayer();
            new TeleportPlayerToDefaultLocation().TeleportPlayer(player);
        }
    }

    public String getTitleName(){
        return ChatColor.translateAlternateColorCodes('&' , Objects.requireNonNull(Main.get().getConfig().getString("respawnTitleName")));
    }
}
