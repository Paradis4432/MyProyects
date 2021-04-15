package me.paradis.blocklocate.locatecommnadblock;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LocateBiomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command on console!");
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            sender.sendMessage(ChatColor.RED + "Invalid Arguments");
            return true;
        }else{
            if((args[0].equals("minecraft:deep_cold_ocean")) || (args[0].equals("minecraft:deep_frozen_ocean")) || (args[0].equals("minecraft:deep_lukewarm_ocean")) || (args[0].equals("minecraft:deep_ocean")) || (args[0].equals("minecraft:deep_warm_ocean")) ){

                sender.sendMessage("Unknown command. Type \"help\" for help.");
                return true;

            }else{
                try{
                    player.performCommand("minecraft:locatebiome " + args[0]);
                    return true;
                }catch(Exception e){
                    return true;
                }
            }
        }
    }
}
