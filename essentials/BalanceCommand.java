package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.storageManager.GetObject;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BalanceCommand implements CommandExecutor {
    /**
     * Returns the balance of a player
     * @param sender Sender
     * @param cmd Command
     * @param label Command Label
     * @param args Arguments
     * @return Whether the command was used correctly
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (CheckPermission.checkPerm("essentials.balance", player)) {
                player.sendMessage(ChatColor.GOLD + "Your balance is: $" + GetObject.getPlayer(player.getUniqueId(), "balance"));
                return true;
            }
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(ChatColor.DARK_RED + "Could not find player!");
            return true;
        }
        if(CheckPermission.checkPerm("essentials.balance.others", player)){
            player.sendMessage(ChatColor.GOLD + "" + target.getName() + "'s balance is: $" + GetObject.getPlayer(target.getUniqueId(), "balance"));
            return true;
        }
        return false;
    }
}
