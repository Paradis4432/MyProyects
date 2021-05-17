package me.paradis.main.events;

import me.paradis.main.items.GiveClickedItem;
import me.paradis.main.utils.Titles;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ListGuiListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(new Titles().getLocationsListTitleName())) {
            event.setCancelled(true);
        }

        if (event.getView().getTitle().equals(new Titles().getListItemsTitleName())) {
            ItemStack clickedItem = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if(new CheckSlot().isOutSide(event.getSlot(), event.getInventory().getSize())) return;
            if (event.getClick() == ClickType.RIGHT) new GiveClickedItem().give(clickedItem, player);
        }
    }
}
