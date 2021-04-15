package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.storageManager.GetObject;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayTimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (CheckPermission.checkPerm("essentials.playtime", player)) {
                player.sendMessage(ChatColor.GOLD + "Your playtime is:" + getPlayTime(player));
                return true;
            }
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(ChatColor.DARK_RED + "Could not find player!");
            return true;
        }
        if(CheckPermission.checkPerm("essentials.playtime.others", player)){
            player.sendMessage(ChatColor.GOLD + "" + target.getName() + "'s playtime is:" + getPlayTime(target));
            return true;
        }
        return false;
    }
    public static String getPlayTime(Player player) {
        Integer minutes = (Integer) GetObject.getPlayer(player.getUniqueId(), "playTime");
        String time = "";
        if (minutes/24/60 != 0) {
            time = time + " " + minutes/24/60 + " days,";
        }
        if (minutes/60%24 != 0) {
            time = time + " " + minutes/60%24 + " hours,";
        }
        if (minutes%60 != 0) {
            time = time + " " + minutes%60 + " minutes,";
        }
        time = StringUtils.substring(time, 0, time.length() - 1);
        time = time + ".";
        return time;
    }
}
