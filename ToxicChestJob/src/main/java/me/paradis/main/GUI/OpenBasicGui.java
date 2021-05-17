package me.paradis.main.GUI;

import me.paradis.main.utils.Config;
import me.paradis.main.utils.CreateItems;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Titles;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OpenBasicGui {

    public void open(Player player) {
        Inventory choose = Bukkit.createInventory(null, 27, getTitleName());

        ItemStack location = createItem(Material.COMPASS, "Select to delete a location");
        ItemStack item = createItem(Material.CHEST, "Select to delete an item");

        choose = new AddDefaultItems().add(choose);

        choose.setItem(12, location);
        choose.setItem(14, item);

        choose = new AddFillItems().add(choose);

        player.openInventory(choose);
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }

    public ItemStack createItem(final Material material, final String name, final String... lore) {
        return new CreateItems().create(material, name, lore);
    }

    public String getTitleName() {
        return new Titles().getBasicGuiTitleName();
    }
}
