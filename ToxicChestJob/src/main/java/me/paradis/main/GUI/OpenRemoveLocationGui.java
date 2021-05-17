package me.paradis.main.GUI;

import me.paradis.main.utils.Titles;
import org.bukkit.entity.Player;

public class OpenRemoveLocationGui {

    public void open(Player player, Integer pageId) {
        String title = new Titles().getLocationRemoveTitleName();
        player.openInventory(new CreateGuiItems().locations(title, pageId));
    }
}
