package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class InvseeCommand  implements CommandExecutor {


    /**
     * A simple /invsee command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * invsee [Player]
     */


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 0){
            player.sendMessage(ChatColor.DARK_RED + "To use this command, run: invsee [Player]");
            return true;
        }
        Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
        if(CheckPermission.checkPerm("essentials.invsee.admin",player)){
            if(targetPlayer != null) {
                Inventory targetInv = targetPlayer.getInventory();
                player.openInventory(targetInv);
                return true;
            }
        }// if target not null open inv and cancel event on click

        return true;
    }
}
