package me.paradis.main.list;

import me.paradis.main.GUI.CreateGuiItems;
import me.paradis.main.utils.Titles;
import org.bukkit.entity.Player;

public class ListManager {

    //gui with items/locations

    public void listLocations(Player player, Integer pageId ) {
        String title = new Titles().getLocationsListTitleName();
        player.openInventory(new CreateGuiItems().locations(title,pageId));
    }

    public void listItems(Player player, Integer pageId) {
        String title = new Titles().getListItemsTitleName();
        player.openInventory(new CreateGuiItems().itemStacks(title, pageId));
    }
}
