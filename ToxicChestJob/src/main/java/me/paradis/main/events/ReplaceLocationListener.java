package me.paradis.main.events;

import me.paradis.main.chest.ChestManager;
import me.paradis.main.locations.ReplaceLocationConfig;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Titles;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ReplaceLocationListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(getTitleName())) {
            ItemStack clickedItem = event.getCurrentItem();

            event.setCancelled(true);
            if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
            if(new CheckSlot().isOutSide(event.getSlot(), event.getInventory().getSize())) return;


            Player player = (Player) event.getWhoClicked();

            new ReplaceLocationConfig().replace(player, clickedItem);

            player.sendMessage(new Messages().getLocationReplacedMessage());

            player.closeInventory();
        }
    }

    public String getTitleName() {
        return new Titles().getLocationReplacedTitleName();
    }
}
