package me.paradis.main.replace;

import me.paradis.main.GUI.CreateGuiItems;
import me.paradis.main.utils.Titles;
import org.bukkit.entity.Player;

public class ReplaceItem {

    public void replace(Player player, Integer pageId) {
        String title = new Titles().getItemReplaceTitleName();
        player.openInventory(new CreateGuiItems().itemStacks(title, pageId));
    }
}
