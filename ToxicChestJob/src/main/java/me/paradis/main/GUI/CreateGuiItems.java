package me.paradis.main.GUI;

import me.paradis.main.Main;
import me.paradis.main.items.GetAllItems;
import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.CreateItems;
import me.paradis.main.utils.CreateLore;
import me.paradis.main.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateGuiItems {

    public Inventory itemStacks(String titleName, Integer pageId) {

        int totalItems = new GetAllItems().getItems(); // 31

        int slots = pageId * 29; // 2* 29 = 58
        int totalItemsToDisplay = Math.min(totalItems, slots); // 31 58

        Inventory items = Bukkit.createInventory(null, new SetSize().set(totalItemsToDisplay), titleName); // fix gui size

        items = new AddDefaultItems().add(items);

        for (int item = (slots-29); item < totalItemsToDisplay; item++) {
            ItemStack itemStack = Main.get().getConfig().getItemStack("items." + item);

            items.setItem(items.firstEmpty(), itemStack);
        }

        items = new AddFillItems().add(items);

        return items;

    }

    public Inventory locations(String titleName, Integer pageId) {

        int totalLocs = new GetAllLocations().getLocs();

        int slots = pageId * 29;
        int totalLocsToDisplay = Math.min(totalLocs, slots);

        Inventory removeLocsInv = Bukkit.createInventory(null, new SetSize().set(totalLocsToDisplay), titleName);

        removeLocsInv = new AddDefaultItems().add(removeLocsInv);

        for (int locs = (slots-29); locs < totalLocsToDisplay; locs++) {
            ItemStack locItem = createItem(Material.COMPASS, "Click here to delete chest ID: " + locs,
                    world(locs),
                    X(locs),
                    Y(locs),
                    Z(locs));

            System.out.println("test1 " + locItem + removeLocsInv.firstEmpty());
            System.out.println("test2 " + new SetSize().set(totalLocs) + totalLocs);

            removeLocsInv.setItem(removeLocsInv.firstEmpty(), locItem);
        }

        removeLocsInv = new AddFillItems().add(removeLocsInv);

        return removeLocsInv;

    }

    public ItemStack createItem(final Material material, final String name, final String... lore) {
        return new CreateItems().create(material, name, lore);
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }

    public String world(Integer chestId) {
        return new CreateLore().getWorld(chestId);
    }

    public String X(Integer chestId) {
        return String.valueOf(new CreateLore().getX(chestId));
    }

    public String Y(Integer chestId) {
        return String.valueOf(new CreateLore().getY(chestId));
    }

    public String Z(Integer chestId) {
        return String.valueOf(new CreateLore().getZ(chestId));
    }
}
