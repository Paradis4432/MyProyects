package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TimeCommand implements CommandExecutor {

    /**
     * A simple /time command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * time [set/add] [day/night/dawn/int/ticks]
     */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't do that in the console.");
            return true;
        }

        Player player = (Player) sender;
        if(args.length == 0){
            if(CheckPermission.checkPerm("essentials.time", player)){
                player.sendMessage(ChatColor.DARK_RED + "To use this command, run: time [set/add] [day/night/dawn/ticks]");
                return true;
            }
        } else if(args[0].equals("set")) {
            if(CheckPermission.checkPerm("essentials.time.set", player)){
                if(args[1] == null){
                        player.sendMessage(ChatColor.DARK_RED + "To use this command, run: time [set] [day/night/dawn/ticks]");
                        return true;
                }
                }
                if(args[1].equals("day")){
                    World w = player.getWorld();
                    w.setTime(Long.parseLong("2000"));
                    player.sendMessage(ChatColor.DARK_GREEN + "The time was successfully changed.");
                    return true;
                }
                if(args[1].equals("dawn")){
                    World w = player.getWorld();
                    w.setTime(Long.parseLong("23041"));
                    player.sendMessage(ChatColor.DARK_GREEN + "The time was successfully changed.");
                    return true;
                }
                if(args[1].equals("night")){
                    World w = player.getWorld();
                    w.setTime(Long.parseLong("13000"));
                    player.sendMessage(ChatColor.DARK_GREEN + "The time was successfully changed.");
                    return true;
                }
                else{
                    try{
                        World w = player.getWorld();
                        w.setTime(Long.parseLong(args[1]));
                        player.sendMessage(ChatColor.DARK_GREEN + "The time was successfully changed.");
                        return true;
                    }catch (NumberFormatException e){
                        player.sendMessage(ChatColor.DARK_RED + "To use this command, run: time [set] [day/night/dawn/ticks]");
                        return true;
                    }
            }

        }else if(args[0].equals("add")){
            if(CheckPermission.checkPerm("essentials.time.add", player)) {
                if (args[1] == null) {
                    player.sendMessage(ChatColor.DARK_RED + "To use this command, run: time [add] [int/ticks]");
                    return true;
                } else {
                    try {
                        World w = player.getWorld();
                        int time = Integer.parseInt(w.getTime() + args[1]);
                        player.sendMessage(ChatColor.DARK_GREEN + "The time was successfully changed.");
                        w.setTime(time);
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.DARK_RED + "To use this command, run: time [set] [day/night/dawn/ticks]");
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
