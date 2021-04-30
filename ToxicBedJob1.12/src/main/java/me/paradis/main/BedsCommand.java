package me.paradis.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BedsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage("you cant run this command on console");
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            new HelpMessage().sendHelpMessage(player);
        }
        if(args.length == 1){
            if(args[0].equals("add")){
                try{
                    if(player.hasPermission("bed.add")){
                        int location = getAllLocations();
                        Main.get().getConfig().set("respawnLocations." + location + ".world", getPlayerWorld(player));
                        Main.get().getConfig().set("respawnLocations." + location + ".X", getXLocation(player));
                        Main.get().getConfig().set("respawnLocations." + location + ".Y", getYLocation(player));
                        Main.get().getConfig().set("respawnLocations." + location + ".Z", getZLocation(player));
                        Main.get().saveConfig();
                        player.sendMessage(getLocationSavedMessage());
                    }else{
                        player.sendMessage(getNoPermMessage());
                    }
                }catch (Exception e){
                    player.sendMessage(getErrorMessage() + e);
                }
            }
            if(args[0].equals("count")){
                try{
                    if(player.hasPermission("bed.count")){

                    }else{
                        player.sendMessage(getNoPermMessage());
                    }
                }catch (Exception e){
                    player.sendMessage(getErrorMessage() + e);
                }
            }
        }
        if(args.length == 2){
            if(args[0].equals("remove")){
                if(isInt(args[1])){
                    if(player.hasPermission("bed.remove")){
                        removeLocation(Integer.valueOf(args[1]));
                        player.sendMessage("removed location ");
                    }else{
                        player.sendMessage(getNoPermMessage());
                    }
                }else{
                    new HelpMessage().sendHelpMessage(player);
                }
            }
        }
        return true;
    }

    public void removeLocation(Integer id){
        int locations = getAllLocations();
        locations--;
        //System.out.println("locations: " + locations + " id: " + id );
        for(int i = id; i <= locations; i++){
            System.out.println("i: " + i);
            if(i != locations){
                //System.out.println("i != location");
                Main.get().getConfig().set("respawnLocations." + i + ".world" , Main.get().getConfig().get("respawnLocations." + (i+1) + ".world"));
                Main.get().getConfig().set("respawnLocations." + i + ".X" , Main.get().getConfig().get("respawnLocations." + (i+1) + ".X"));
                Main.get().getConfig().set("respawnLocations." + i + ".Y" , Main.get().getConfig().get("respawnLocations." + (i+1) + ".Y"));
                Main.get().getConfig().set("respawnLocations." + i + ".Z" , Main.get().getConfig().get("respawnLocations." + (i+1) + ".Z"));

            }else{
                System.out.println("i == location removing i" + i);
                Main.get().getConfig().set("respawnLocations." + i, null);
            }
        }
        Main.get().saveConfig();
    }

    public static boolean isInt(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public Integer getAllLocations(){
        boolean allLocationsFound = false;
        int locationsFound = 0;
        while(!(allLocationsFound)){
            if((Main.get().getConfig().get("respawnLocations." + (locationsFound + 1))) == null){
                allLocationsFound = true;
            }else{
                locationsFound++;
            }
        }
        return locationsFound + 1;
    }

    public String getNoPermMessage() {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.noPermMessage")));
    }

    public String getPlayerWorld(Player player){
        return player.getWorld().getName();
    }

    public Integer getXLocation(Player player){
        return player.getLocation().getBlockX();
    }

    public Integer getYLocation(Player player){
        return player.getLocation().getBlockY();
    }

    public Integer getZLocation(Player player){
        return player.getLocation().getBlockZ();
    }

    public String getLocationSavedMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.locationSaved")));
    }

    public String getErrorMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.error")));
    }
}
