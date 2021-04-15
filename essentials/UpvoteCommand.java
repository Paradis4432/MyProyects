package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.storageManager.SQLDatabase;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class UpvoteCommand implements CommandExecutor {
    /**
     * A simple /upvote command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            if (CheckPermission.checkPerm("essentials.upvote", player)) {
                player.sendMessage(ChatColor.DARK_RED + "Please specify a player when running this command.");
                return true;
            }
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(ChatColor.DARK_RED + "Looks like that player is offline or hasn't joined this server yet!");
            return true;
        }
        if(CheckPermission.checkPerm("essentials.upvote", player)){
            if (player.getName().equals(args[0])) {
                player.sendMessage(ChatColor.DARK_RED + "You can't upvote yourself!");
            }
            else {
                try (PreparedStatement newUpvote = SQLDatabase.connection.prepareStatement("INSERT INTO upvotes (player, target) VALUES ( UNHEX(?), UNHEX(?))")) {
                    player.sendMessage(ChatColor.GOLD + "You upvoted " + target.getName() + "!");
                    newUpvote.setString(1, String.valueOf(player.getUniqueId()).replaceAll("-", ""));
                    newUpvote.setString(2, String.valueOf(target.getUniqueId()).replaceAll("-", ""));
                    newUpvote.execute();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }

            }
            return true;
        }
        return false;
    }

}
