package me.paradis.main.commands;

import me.paradis.main.Main;
import me.paradis.main.limitManager.BiggestLimit;
import me.paradis.main.respawnManager.RemoveLocation;
import me.paradis.main.respawnManager.RespawnLocations;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.PlayerInfo;
import me.paradis.main.utils.VarType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage("you cant run this command on console");
            return true;
        }

        Player player = (Player) sender;
        String noPerm = new Messages().getNoPermMessage();
        int locationsCount = new RespawnLocations().getAllLocations();
        int bedsCount = new PlayerInfo().getAmountOfBeds(player);

        if(args.length == 0){
            new Messages().sendHelpMessage(player);
        }
        if(args.length == 1){
            if(args[0].equals("add")){
                try{
                    if(player.hasPermission("bed.add")){
                        Main.get().getConfig().set("respawnLocations." + locationsCount + ".world", new PlayerInfo().getPlayerWorld(player));
                        Main.get().getConfig().set("respawnLocations." + locationsCount + ".X", new PlayerInfo().getXLocation(player));
                        Main.get().getConfig().set("respawnLocations." + locationsCount + ".Y", new PlayerInfo().getYLocation(player));
                        Main.get().getConfig().set("respawnLocations." + locationsCount + ".Z", new PlayerInfo().getZLocation(player));
                        Main.get().saveConfig();
                        player.sendMessage(new Messages().getLocationSavedMessage());
                    }else{
                        player.sendMessage(noPerm);
                    }
                    return true;
                }catch (Exception e){
                    player.sendMessage(new Messages().getErrorMessage() + e + " command add");
                }
            }
            if(args[0].equals("count")){
                try{
                    if(player.hasPermission("bed.count")){
                        //send the player a message with his bed count
                        player.sendMessage("you have a total of " + bedsCount + " active beds");

                    }else{
                        player.sendMessage(noPerm);
                    }
                    return true;
                }catch (Exception e){
                    player.sendMessage(new Messages().getErrorMessage() + e + " command add");
                }
            }
            if(args[0].equals("limit")){
                try{
                    if(player.hasPermission("beds.limit")){
                        int limit = new BiggestLimit().getLimit(player);

                        player.sendMessage(new Messages().getLimitMessage() + limit);
                    }else{
                        player.sendMessage(noPerm);
                    }
                    return true;
                }catch (Exception e){
                    player.sendMessage(new Messages().getErrorMessage() + e + " command add");
                }
            }
            else{
                new Messages().sendHelpMessage(player);
            }
        }
        if(args.length == 2){
            if(args[0].equals("remove")){
                if(new VarType().isInt(args[1])){
                    if(player.hasPermission("bed.remove")){
                        new RemoveLocation().removeLocation(Integer.valueOf(args[1]));
                        player.sendMessage("removed location ");
                    }else{
                        player.sendMessage(noPerm);
                    }
                    return true;
                }else{
                    new Messages().sendHelpMessage(player);
                }
            }
        }
        return true;
    }
}
