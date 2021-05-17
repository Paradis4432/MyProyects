package me.paradis.main.items;

import me.paradis.main.Main;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ReplaceItemConfig {

    public void replace(Player player, ItemStack clickedItem) {
        try {
            if (debugMode()) System.out.println("attempting to replace item");
            int totalItems = new GetAllItems().getItems();

            for (int item = 0; item < totalItems; item++) {
                if (clickedItem.equals(getItemFromConfigFile(item))) {
                    ItemStack inHand = player.getInventory().getItemInMainHand();
                    Main.get().getConfig().set("items." + item, inHand);

                    Main.get().saveConfig();

                    if (debugMode()) System.out.println("clicked item: " + clickedItem + " item in hand: " + inHand);
                    return;
                } else {
                    if (debugMode())
                        System.out.println("to replace item not found in config file " + clickedItem + getItemFromConfigFile(item));
                }
            }

        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public ItemStack getItemFromConfigFile(Integer item) {
        return Main.get().getConfig().getItemStack("items." + item);
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}
