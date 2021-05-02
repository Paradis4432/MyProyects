package me.paradis.main.events;

import me.paradis.main.Main;
import me.paradis.main.respawnManager.TeleportPlayerToLocation;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Names;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.Objects;

public class CloseInventoryEvent implements Listener {

    @EventHandler
    public void onInvClose(InventoryCloseEvent event){
        if(event.getView().getTitle().equals(new Names().getTitleName())){
            Player player = (Player) event.getPlayer();
            try{
                if((Main.get().getConfig().getBoolean(String.valueOf(player.getUniqueId())))){
                    Main.get().getConfig().set(String.valueOf(player.getUniqueId()), null);
                }else if ((Main.get().getConfig().get(String.valueOf(player.getUniqueId()))) == null){
                    new TeleportPlayerToLocation().TeleportPlayer(player);
                }
            }catch (Exception e){
                player.sendMessage(new Messages().getErrorMessage() + e);
            }
        }
    }
}
