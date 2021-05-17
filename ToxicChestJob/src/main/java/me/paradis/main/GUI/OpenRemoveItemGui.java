package me.paradis.main.GUI;

import me.paradis.main.utils.Titles;
import org.bukkit.entity.Player;

public class OpenRemoveItemGui {

    public void open(Player player, Integer pageId) {
        String title = new Titles().getItemRemoveTitleName();
        player.openInventory(new CreateGuiItems().itemStacks(title, pageId));
    }

}
