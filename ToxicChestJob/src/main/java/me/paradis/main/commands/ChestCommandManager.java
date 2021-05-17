package me.paradis.main.commands;

import me.paradis.main.GUI.OpenBasicGui;
import me.paradis.main.GUI.OpenRemoveItemGui;
import me.paradis.main.GUI.OpenRemoveLocationGui;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.items.GetItemFromHand;
import me.paradis.main.list.ListManager;
import me.paradis.main.locations.AddLocationManager;
import me.paradis.main.replace.ReplaceItem;
import me.paradis.main.replace.ReplaceLocation;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Reload;
import me.paradis.main.utils.VarType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ChestCommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("you cant run this command on console");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            sendHelpMessage(player);
        }

        if (args.length == 1) {
            if ((args[0].equalsIgnoreCase("remove"))) {
                if (checkPerm(player, "chest.remove")) {
                    new OpenBasicGui().open(player); //opens a gui to select what to delete
                }

            }
            if (args[0].equalsIgnoreCase("reload")) {
                if (checkPerm(player, "chest.reload")) {
                    new Reload().reload();
                }
            } else {
                sendHelpMessage(player);
            }
        }

        if (args.length == 2) {
            //add commands
            if ((args[0].equalsIgnoreCase("add")) && (args[1].equalsIgnoreCase("location"))) {
                if (checkPerm(player, "chest.add.location")) {
                    new AddLocationManager().addLocation(player); //add a location to the config file where a chest will spawn

                }
            } else if ((args[0].equalsIgnoreCase("add")) && (args[1].equalsIgnoreCase("item"))) {
                if (checkPerm(player, "chest.add.item")) {
                    new GetItemFromHand().get(player); //add the current item in hand to the config file

                }

                //force command
            } else if ((args[0].equalsIgnoreCase("force")) && (isInt(args[1]))) {
                if (checkPerm(player, "chest.force")) {
                    new ChestManager().forceId(Integer.valueOf(args[1])); //forces a chest to spawn
                    player.sendMessage(new Messages().getForcedMessage());
                }

            } else {
                sendHelpMessage(player);
            }
        }

        if (args.length == 3) {
            //set command

                //list commands
            if ((args[0].equalsIgnoreCase("list")) && (args[1].equalsIgnoreCase("item")) && (isInt(args[2]))) {
                if (checkPerm(player, "chest.list.items")) {
                    new ListManager().listItems(player, Integer.valueOf(args[2])); //list all items
                    player.sendMessage(new Messages().getItemsListedMessage());
                }

            } else if ((args[0].equalsIgnoreCase("list")) && (args[1].equalsIgnoreCase("location")) && (isInt(args[2]))) {
                if (checkPerm(player, "chest.list.locations")) {
                    new ListManager().listLocations(player, Integer.valueOf(args[2])); //list all locations
                    player.sendMessage(new Messages().getLocationsListedMessage());
                }
                //replace commands
            } else if ((args[0].equalsIgnoreCase("replace")) && (args[1].equalsIgnoreCase("item")) && (isInt(args[2]))) {
                if (checkPerm(player, "chest.replace.item")) {
                    new ReplaceItem().replace(player, Integer.valueOf(args[2])); //open a gui with the list of items to replace

                }

            } else if ((args[0].equalsIgnoreCase("replace")) && (args[1].equalsIgnoreCase("location")) && (isInt(args[2]))) {
                if (checkPerm(player, "chest.replace.location")) {
                    new ReplaceLocation().replace(player, Integer.valueOf(args[2])); //open a gui with the list of locations to replace

                }
                //remove commands
            } else if ((args[0].equalsIgnoreCase("remove")) && (args[1].equalsIgnoreCase("location")) && (isInt(args[2]))) {
                if (checkPerm(player, "chest.remove.location")) {
                    new OpenRemoveLocationGui().open(player, Integer.valueOf(args[2])); //opens a gui with the locations to remove one

                }

            } else if ((args[0].equalsIgnoreCase("remove")) && (args[1].equalsIgnoreCase("item")) && (isInt(args[2]))) {
                if (checkPerm(player, "chest.remove.item")) {
                    new OpenRemoveItemGui().open(player, Integer.valueOf(args[2])); //opens a gui with the items to remove one
                }
            } else {
                sendHelpMessage(player);
            }
        }

        if(args.length == 4){
            if ((args[0]).equalsIgnoreCase("set") && (args[1].equalsIgnoreCase("chance")) && (isInt(args[2])) && (isInt(args[3]))) {
                if (checkPerm(player, "chest.set.chance")) {
                    new ChangeChanceCommand().change(player,Integer.valueOf(args[2]), Integer.valueOf(args[3]));
                }
            }
        }
        return true;
    }

    public boolean checkPerm(Player player, String perm) {
        if (player.hasPermission(perm) || player.isOp()) return true;
        else player.sendMessage(new Messages().noPermMessage());
        return false;
    }

    public static boolean isInt(String s) {
        return new VarType().check(s);
    }

    //messages

    public void sendHelpMessage(Player player) {
        new Messages().sendHelpMessage(player);
    }


}

