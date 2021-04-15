package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.storageManager.EditObject;
import com.infinitycraft.plugin.general.storageManager.GetObject;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BalanceEditCommand implements CommandExecutor {

    /**
     * Edits a player's balance
     * @param sender Sender
     * @param cmd Command
     * @param label Command's Label
     * @param args Arguments
     * @return Whether the command was used properly or not
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length < 3) {
            if (CheckPermission.checkPerm("essentials.editbalance", player)) {
                player.sendMessage(ChatColor.DARK_RED + "To use this command, run: /editbalance [player] [set/add/remove] [amount]");
                return true;
            }
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        Integer amount;
        if (target == null) {
            player.sendMessage(ChatColor.DARK_RED + "Could not find player!");
            return true;
        }
        if (CheckPermission.checkPerm("essentials.editbalance", player)) {
            try {
                amount = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.DARK_RED + "To use this command, run: /editbalance [player] [set/add/remove] [amount]");
                return true;
            }
            if (args[1].equals("set")){
                EditObject.editPlayer(target.getUniqueId(), "balance", amount);
                player.sendMessage(ChatColor.DARK_GREEN + "Set " + args[0] + "'s balance to $" + amount +".");
            }
            if (args[1].equals("add")){
                Integer current = (Integer) GetObject.getPlayer(target.getUniqueId(), "balance");
                EditObject.editPlayer(target.getUniqueId(), "balance", current + amount);
                player.sendMessage(ChatColor.DARK_GREEN + "Added $" + amount + " to " + args[0] + "'s balance.");
            }
            if (args[1].equals("remove")){
                Integer current = (Integer) GetObject.getPlayer(target.getUniqueId(), "balance");
                EditObject.editPlayer(target.getUniqueId(), "balance", current - amount);
                player.sendMessage(ChatColor.DARK_GREEN + "Removed $" + amount + " from " + args[0] + "'s balance.");
            }
            return true;
        }
        return true;
    }
}
