package me.paradis.main.commands;

import me.paradis.main.GUI.OpenBasicGui;
import me.paradis.main.GUI.OpenRemoveItemGui;
import me.paradis.main.GUI.OpenRemoveLocationGui;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.items.GetItemFromHand;
import me.paradis.main.locations.AddLocationManager;
import me.paradis.main.utils.VarType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChestCommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("you cant run this command on console");
            return true;
        }

        Player player = (Player) sender;

        if ((args[0].equals("add")) && (args[1].equals("location"))) {
            //add current location of player to config file
            //add current location with id args[1]
            new AddLocationManager().addLocation(player);

        } else if ((args[0].equals("add")) && (args[1].equals("item"))) {
            //manage the addition of items using item in hand
            new GetItemFromHand().get(player);

        } else if ((args[0].equals("remove")) && (args.length == 1)){
            //open gui with 2 options, when each choose run player command remove args
            new OpenBasicGui().open(player);

        } else if ((args[0].equals("remove")) && (args[1].equals("location"))) {
            //remove location of id args[2]
            new OpenRemoveLocationGui().open(player);

        } else if ((args[0].equals("remove")) && (args[1].equals("item"))) {
            //remove item with id args[2]
            new OpenRemoveItemGui().open(player);

        } else if ((args[0].equals("force")) && (isInt(args[1]))){
            //forces a location to happen
            new ChestManager().forceId(Integer.valueOf(args[1]));

        } else if ((args[0]).equals("set") ){//add chance here

        } else{
            //send help message
        }
        //add force location
        //add give item
        //add start timer
        //add list
        //add set chance

        return true;
    }

    public static boolean isInt(String s) {
        return new VarType().check(s);
    }
}

