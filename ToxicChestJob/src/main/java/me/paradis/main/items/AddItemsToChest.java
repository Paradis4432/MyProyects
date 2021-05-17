package me.paradis.main.items;

import me.paradis.main.Main;
import me.paradis.main.chest.GetAllChests;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.RandomNumber;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AddItemsToChest {

    public void add(Location chestLocation) {

        int itemsAdded = 0;
        try {
            Block b = chestLocation.getBlock();
            Chest chest = (Chest) b.getState();
            Inventory chestInv = chest.getInventory();

            int items = new GetAllItems().getItems();

            if (debugMode()) System.out.println("total items : " + items);
            int chestId = getRandomNum(new GetAllChests().get());

            for (int i = 0; i < items; i++) {
                ItemStack item = Main.get().getConfig().getItemStack("items." + i);

                int num = getRandomNum(100);

                if (num <= Main.get().getConfig().getInt("chest." + chestId + ".chance")) {
                    if (debugMode())
                        System.out.println("random num: " + num + " current chance: " + num + " adding item: " + item + " chestID: " + chestId);

                    //if cont < limit
                    if (itemsAdded <= new Messages().getItemLimit()) chestInv.addItem(item);
                }
            }
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

    public Integer getRandomNum(int num) {
        return new RandomNumber().create(num);
    }
}
