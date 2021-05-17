package me.paradis.main.events;

import me.paradis.main.Main;
import me.paradis.main.items.DeleteItemFromConfig;
import me.paradis.main.items.GetAllItems;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Titles;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class RemoveItemGuiListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        try {
            if (event.getView().getTitle().equals(getTitleName())) {
                ItemStack clickedItem = event.getCurrentItem();
                event.setCancelled(true);
                if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
                if(new CheckSlot().isOutSide(event.getSlot(), event.getInventory().getSize())) return;

                int totalItems = new GetAllItems().getItems();

                for (int items = 0; items < totalItems; items++) {
                    ItemStack configItem = Main.get().getConfig().getItemStack("items." + items);
                    if (clickedItem.equals(configItem)) {
                        new DeleteItemFromConfig().delete(items);
                        Player player = (Player) event.getWhoClicked();
                        player.sendMessage(new Messages().getItemRemovedMessage());

                        player.closeInventory();

                    }
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
        return new Titles().getItemRemoveTitleName();
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}

