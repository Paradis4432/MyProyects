package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.text.ColorCoder;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BroadcastCommand implements CommandExecutor {
    /**
     * A simple /broadcast command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * broadcasts a message to all players
     * feature : players will the perm will be allow to use the broadcast based on cooldown
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command in the console");
            return true;
        }

        Player player = (Player) sender;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < args.length; i++){
            sb.append(args[i]).append(" ");
        }
        String messageToBroacast = sb.toString();

        if(CheckPermission.checkPerm("essentials.broadcast.admin", player)){
            if(args.length == 0){
                player.sendMessage(ChatColor.DARK_RED + "Invalid arguments");
                return true;
            }else{
                messageToBroacast = ChatColor.translateAlternateColorCodes('&' , messageToBroacast);
                Bukkit.broadcastMessage(ColorCoder.convertColor("&8[&6Infinity Craft&8]") + " " + messageToBroacast + ChatColor.DARK_GREEN + "- " + sender.getName());

            }

        }
        return true;
    }
}
