package me.paradis.main.items;

import me.paradis.main.Main;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetItemFromHand {

    public void get(Player player) {
        try {
            //saves the item in the config file
            int itemId = new GetAllItems().getItems();

            ItemStack item = player.getInventory().getItemInMainHand();

            if(item.getType() == Material.AIR) return;

            Main.get().getConfig().set("items." + itemId, item);
            Main.get().saveConfig();

            player.sendMessage(getItemSavedMessage());
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public String getItemSavedMessage() {
        return new Messages().getItemAddedMessage();
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}
