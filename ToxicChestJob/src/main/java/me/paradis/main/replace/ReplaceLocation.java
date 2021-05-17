package me.paradis.main.replace;

import me.paradis.main.GUI.CreateGuiItems;
import me.paradis.main.utils.Titles;
import org.bukkit.entity.Player;

public class ReplaceLocation {

    public void replace(Player player, Integer pageId) {
        String title = new Titles().getLocationReplacedTitleName();
        player.openInventory(new CreateGuiItems().locations(title, pageId));
    }
}
