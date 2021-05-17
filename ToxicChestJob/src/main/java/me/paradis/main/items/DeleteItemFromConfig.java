package me.paradis.main.items;

import me.paradis.main.Main;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import org.bukkit.inventory.ItemStack;

public class DeleteItemFromConfig {

    public void delete(Integer itemID) {
        //deletes the item from the config file
        try {
            int allItems = new GetAllItems().getItems();

            for (int item = itemID; item <= allItems; item++) {

                if (debugMode())
                    System.out.println("deleting item from config file, itemCount: " + allItems + " itemID " + itemID);

                if (item != allItems) {
                    ItemStack replaceItemStack = Main.get().getConfig().getItemStack("items." + (item + 1));

                    Main.get().getConfig().set("items." + item, replaceItemStack);
                } else {
                    Main.get().getConfig().set("items." + item, null);
                }
            }
            Main.get().saveConfig();
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }
}
