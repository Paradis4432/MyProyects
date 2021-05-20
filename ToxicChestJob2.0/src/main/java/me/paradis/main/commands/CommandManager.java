package me.paradis.main.commands;

import me.paradis.main.GUIs.generalGUI.CreateGeneralGUI;
import me.paradis.main.utils.VarType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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


        if(args.length == 2) checkArgs1(args,player);
        if(args.length == 3) checkArgs2(args,player);
        if(args.length == 4) checkArgs3(args,player);
        return true;
    }

    public void checkArgs1(String[] args, Player player){
        if(is(args,0,"add") && is(args,1,"location") && checkPerm(player,"chest.add.location")){
            player.sendMessage("adding location");
        }
    }

    public void checkArgs2(String[] args, Player player){
        if(is(args,0,"add") && is(args,1,"loot") && isInt(args[2]) && checkPerm(player,"chest.add.loot")){
            player.sendMessage("adding loot");
        }
    }

    public void checkArgs3(String[] args, Player player){
        if(is(args,0,"add") && is(args,1,"item") && isInt(args[2]) && isInt(args[3]) && checkPerm(player,"chest.add.item")){
            player.sendMessage("adding item");
        }
    }

    public boolean checkPerm(Player player, String perm) {
        if (player.hasPermission(perm) || player.isOp()) return true;
        else player.sendMessage("no perm message");
        return false;
    }

    public boolean is(String[] args, Integer pos, String command) {
        return args[pos].equalsIgnoreCase(command);
    }

    public static boolean isInt(String s) {
        return new VarType().check(s);
    }
}
