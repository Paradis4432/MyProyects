package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.storageManager.SQLDatabase;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;

public class BalTopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (CheckPermission.checkPerm("essentials.baltop", player)) {
                try {
                    ResultSet rs = SQLDatabase.statement.executeQuery("SELECT players.* from players ORDER BY balance DESC LIMIT 10");
                    int current = 1;
                    player.sendMessage(ChatColor.GOLD + "+----------------Top Balances----------------+");
                    while(rs.next()) {
                        player.sendMessage(ChatColor.GOLD + "  " + current + ". " + rs.getString("name") + ": $" + rs.getInt("balance"));
                        current += 1;
                    }
                    player.sendMessage(ChatColor.GOLD + "+-------------------------------------------+");
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }
}
