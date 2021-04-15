package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class RenameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        // rename [string]

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command on console");
            return true;
        }

        Player player = (Player) sender;

        if(CheckPermission.checkPerm("essentials.rename" ,player)){
            if(args.length == 0){
                player.sendMessage(ChatColor.DARK_RED + "Usage: /rename [name]");
            }

            if(args.length >= 2){
                StringBuilder message = new StringBuilder();
                for(int i = 1; i < args.length; i++){
                    message.append(" ").append(args);
                }
                ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
                itemMeta.setDisplayName(String.valueOf(message));
                player.getInventory().getItemInMainHand().setItemMeta(itemMeta);

            }else{
                String message;
                message = args[0];
                ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
                itemMeta.setDisplayName(message);
                player.getInventory().getItemInMainHand().setItemMeta(itemMeta);
            }
        }



        return true;
    }
}
