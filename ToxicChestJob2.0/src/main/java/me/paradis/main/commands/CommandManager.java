package me.paradis.main.commands;

import me.paradis.main.GUIs.generalGUI.CreateGeneralGUI;
import me.paradis.main.Main;
import me.paradis.main.itemManager.addItem.AddItemCommand;
import me.paradis.main.locationManager.addLocation.AddLocationCommand;
import me.paradis.main.lootManager.addLoot.AddLootCommand;
import me.paradis.main.utils.VarType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("you cant run this command on console");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            //open general gui
            player.openInventory(new CreateGeneralGUI().build());
            return true;
        }


        if (args.length == 2) checkArgs1(args, player);
        if (args.length == 3) checkArgs2(args, player);
        if (args.length == 4) checkArgs3(args, player);
        if (args.length == 5) checkArgs4(args, player);
        return true;
    }

    public void checkArgs1(String[] args, Player player) {
        if (is(args, 0, "add") && is(args, 1, "location") && checkPerm(player, "chest.add.location")) {
            if(Main.get().debugMode()) player.sendMessage("adding location");
            new AddLocationCommand().add(player);
        } else if (is(args,0,"list") && is(args,1,"locations") && checkPerm(player,"chest.list")) {
            if(Main.get().debugMode()) player.sendMessage("listing locations");
        }
    }

    public void checkArgs2(String[] args, Player player) {
        if (is(args, 0, "add") && is(args, 1, "loot") && isInt(args[2]) && checkPerm(player, "chest.add.loot")) {
            if(Main.get().debugMode()) player.sendMessage("adding loot");
            ItemStack item = player.getItemInHand();
            new AddLootCommand().add(player, Integer.parseInt(args[2]),item);
        } else if (is(args, 0, "remove") && is(args, 1, "location") && isInt(args[2]) && checkPerm(player, "chest.remove.location")) {
            if(Main.get().debugMode()) player.sendMessage("removing location");
        } else if(is(args,0,"replace") && is(args,1,"location") && isInt(args[2]) && checkPerm(player,"chest.replace.location")){
            if(Main.get().debugMode()) player.sendMessage("replacing location");
        } else if (is(args,0,"list") && is(args,1,"locations") && isInt(args[2]) && checkPerm(player,"chest.list")){
            if(Main.get().debugMode()) player.sendMessage("listing loots on location " + args[2]);
        }
    }

    public void checkArgs3(String[] args, Player player) {
        if (is(args, 0, "add") && is(args, 1, "item") && isInt(args[2]) && isInt(args[3]) && checkPerm(player, "chest.add.item")) {
            if(Main.get().debugMode()) player.sendMessage("adding item");
            ItemStack item = player.getItemInHand();
            new AddItemCommand().add(Integer.parseInt(args[2]), Integer.parseInt(args[3]), item, player);
        } else if (is(args, 0, "remove") && is(args, 1, "loot") && isInt(args[2]) && isInt(args[3]) && checkPerm(player, "chest.remove.loot")) {
            if(Main.get().debugMode()) player.sendMessage("removing loot");
        }
    }

    public void checkArgs4(String[] args, Player player) {
        if (is(args, 0, "remove") && is(args,1,"item") && isInt(args[2]) && isInt(args[3]) && isInt(args[4]) && checkPerm(player,"chest.remove.item")){
            if(Main.get().debugMode()) player.sendMessage("removing item");
        } else if(is(args,0,"replace") && is(args,1,"item") && isInt(args[2]) && isInt(args[3]) && isInt(args[4]) && checkPerm(player,"chest.replace.item")){
            if(Main.get().debugMode()) player.sendMessage("replacing item");
        }
    }

    public boolean checkPerm(Player player, String perm) {
        if (player.hasPermission(perm) || player.isOp()) return true;
        else if(Main.get().debugMode()) player.sendMessage("no perm message");
        return false;
    }

    public boolean is(String[] args, Integer pos, String command) {
        return args[pos].equalsIgnoreCase(command);
    }

    public static boolean isInt(String s) {
        return new VarType().check(s);
    }
}
