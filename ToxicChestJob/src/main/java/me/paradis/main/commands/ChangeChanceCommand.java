package me.paradis.main.commands;

import me.paradis.main.Main;
import me.paradis.main.utils.Messages;
import org.bukkit.entity.Player;

public class ChangeChanceCommand {

    public void change(Player player, Integer chestId, Integer chance){
        //add chance and change it on command
        //save config
        Main.get().getConfig().set("chest." + chestId + ".chance", chance);

        player.sendMessage(new Messages().getChanceChangedMessage());

        Main.get().saveConfig();
    }
}
