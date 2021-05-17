package me.paradis.main.events;

import me.paradis.main.locations.RemoveLocation;
import me.paradis.main.teleport.TeleportPlayerToLocation;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Titles;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class RemoveLocationListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        try {
            //get inv name if clicked item isint null or air, check the item name, if left click teleport to location
            //if right click delete location
            if (event.getView().getTitle().equals(getTitleName())) {
                ItemStack clickedItem = event.getCurrentItem();
                event.setCancelled(true);
                if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
                if(new CheckSlot().isOutSide(event.getSlot(), event.getInventory().getSize())) return;

                Player player = (Player) event.getWhoClicked();

                if (event.getClick() == ClickType.LEFT) {
                    new TeleportPlayerToLocation().teleport(player, clickedItem);
                }
                if (event.getClick() == ClickType.RIGHT) {
                    new RemoveLocation().remove(player, clickedItem);
                    player.sendMessage(new Messages().getLocationRemovedMessage());

                    player.closeInventory();
                }
            }
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public String getTitleName() {
        return new Titles().getLocationRemoveTitleName();
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}
