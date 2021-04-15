package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

    /**
     * A simple /fly command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * finish time arg to add X time to FlyTime in sql
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player =(Player) sender;
            if (args.length == 0) {
                // if players has flyTime left enable or has perm essentials.fly
                // enable fly

                // else you cant use that
                    if (CheckPermission.checkPerm("essentials.fly", player)) {
                        if (player.getAllowFlight()) {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                            player.sendMessage(ChatColor.DARK_GREEN + "Flight disabled.");
                        } else {
                            player.setAllowFlight(true);
                            player.setFlying(true);
                            player.sendMessage(ChatColor.DARK_GREEN + "Flight enabled.");
                        }
                        return true;
                    }
            }
            // fly for other players
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if(target == null){
                player.sendMessage(ChatColor.DARK_RED + "Player not found");
                return true;
            }
            if(CheckPermission.checkPerm("essentials.fly.others", player)){
                if (target.getAllowFlight()) {
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    target.sendMessage(ChatColor.DARK_GREEN + "Flight disabled by " + player.getName() + ".");
                    player.sendMessage(ChatColor.DARK_GREEN + "Flight disabled for " + target.getName() + ".");
                }
                else {
                    target.setAllowFlight(true);
                    target.setFlying(true);
                    target.sendMessage(ChatColor.DARK_GREEN + "Flight enabled by " + player.getName() + ".");
                    player.sendMessage(ChatColor.DARK_GREEN + "Flight enabled for " + target.getName() + ".");
                }
                return true;
            }


        return false;
    }
}
