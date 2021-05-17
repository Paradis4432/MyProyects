package me.paradis.main.events;

import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Titles;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class DeleteGuiListener implements Listener {

    @EventHandler
    public void onGuiClick(InventoryClickEvent event) {

            if (event.getView().getTitle().equals(getTitleName())) {
                Player player = (Player) event.getWhoClicked();
                ItemStack clickedItem = event.getCurrentItem();

                event.setCancelled(true);
                if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
                if(new CheckSlot().isOutSide(event.getSlot(), event.getInventory().getSize())) return;
                if (event.getCurrentItem().getType() == Material.COMPASS) {
                    //make player run command
                    player.closeInventory();
                    player.performCommand("chest remove location 1");
                } else if (event.getCurrentItem().getType() == Material.CHEST) {
                    player.closeInventory();
                    player.performCommand("chest remove item 1");
                }
            }

    }

    public String getTitleName() {
        return new Titles().getBasicGuiTitleName();
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}
