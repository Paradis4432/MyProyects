package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DayCommand implements CommandExecutor {
    /**
     * A simple /day command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * daytime will allow certain players with a permission to set time to 1000 ticks
     */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if(CheckPermission.checkPerm("essentials.time.day", player)){
            World w = player.getWorld();
            w.setTime(Long.parseLong("2000"));
            player.sendMessage(ChatColor.DARK_GREEN + "The time was successfully set to day.");
            return true;
        }
        return false;
    }
}
