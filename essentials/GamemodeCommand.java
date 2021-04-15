package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {

    /**
     * A simple /gm command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * usage: /[gm/gamemode] [0/1/2] [Player]
     */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command in the console");
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            if(CheckPermission.checkPerm("essentials.gamemode", player)){
                player.sendMessage(ChatColor.DARK_RED + "Invalid arguments");
                return true;
            }
        }

        if(args.length == 1){
            if(args[0].equals("0") || args[0].equals("s") || args[0].equals("survival")){
                if(CheckPermission.checkPerm("essentials.gamemode.survival", player)){
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.DARK_GREEN + "Gamemode set to Survival");
                    return true;
                }
            }else if(args[0].equals("1") || args[0].equals("c") || args[0].equals("creative")){
                if(CheckPermission.checkPerm("essentials.gamemode.creative", player)){
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.DARK_GREEN + "Gamemode set to Creative");
                    return true;
                }
            }else if(args[0].equals("2") || args[0].equals("sp") || args[0].equals("spectator")){
                if(CheckPermission.checkPerm("essentials.gamemode.spectator", player)){
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.DARK_GREEN + "Gamemode set to Spectator");
                    return true;
                }
            }else{
                player.sendMessage(ChatColor.DARK_RED + "Invalid arguments");
                return true;
            }
        }

        Player target = Bukkit.getServer().getPlayer(args[1]);

        if(args.length == 2){
            if(target == null){
                player.sendMessage(ChatColor.DARK_RED + "Invalid arguments");
                return true;
            }else{
                if(CheckPermission.checkPerm("essentials.gamemode.admin", player)){
                    if(args[0].equals("0") || args[0].equals("s") || args[0].equals("survival")){
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been changed to Survival by " + player.getName());
                        player.sendMessage(ChatColor.DARK_GREEN + "You changed the gamemode of " + target.getName() + " to Survival");
                        return true;
                    }else if(args[0].equals("1") || args[0].equals("c") || args[0].equals("creative")){
                        target.setGameMode(GameMode.CREATIVE);
                        target.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been changed to Creative by " + player.getName());
                        player.sendMessage(ChatColor.DARK_GREEN + "You changed the gamemode of " + target.getName() + " to Creative");
                        return true;
                    }else if(args[0].equals("2") || args[0].equals("sp") || args[0].equals("spectator")){
                        target.setGameMode(GameMode.SPECTATOR);
                        target.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been changed to Spectator by " + player.getName());
                        player.sendMessage(ChatColor.DARK_GREEN + "You changed the gamemode of " + target.getName() + " to Spectator");
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
