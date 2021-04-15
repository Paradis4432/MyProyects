package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {

    /**
     * A simple /feed command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            if (CheckPermission.checkPerm("essentials.feed", player)) {
                player.setFoodLevel(20);
                player.setSaturation(20);
                player.sendMessage(ChatColor.DARK_GREEN + "You have been fed.");
                return true;
            }
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(ChatColor.DARK_RED + "Could not find player!");
            return true;
        }
        if(CheckPermission.checkPerm("essentials.feed.others", player)){
            target.setFoodLevel(20);
            target.setSaturation(20);
            target.sendMessage(ChatColor.DARK_GREEN + "You have been fed by " + player.getName() + ".");
            player.sendMessage(ChatColor.DARK_GREEN + "You fed " + target.getName() + ".");
            return true;
        }
        return false;
    }
}
