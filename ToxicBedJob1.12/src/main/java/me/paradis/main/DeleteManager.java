package me.paradis.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeleteManager {

    public void deleteBed(Player player, ItemStack item) {
        //gets the amount of beds
        int beds = new RespawnEvent().getAmountOfBeds(player);

        //gets the bed name / id
        int bedId = getBedName(item);
        //creates the new bed
        renameBeds(player, beds, bedId);

        player.closeInventory();
    }

    public Integer getBedName(ItemStack itemStack) {
        return Integer.valueOf(Objects.requireNonNull(itemStack.getItemMeta().getDisplayName()));
    }

    public void renameBeds(Player player, Integer beds, int bedId) {

        for (int i = bedId; i <= beds; i++) {
            //if this bed id is the one deleted then do this for all beds
            // if 1 2 3 4 5
            // deleted 2
            // new list 1 3 4 5
            // 2:3 3:4 4:5
            // new list 1 2 3 4
            // 5 deleted
            //System.out.println("test0 " + beds + " i " + i);
            //if the cliked bed is the one then start

            if(i != beds){
                Main.get().getConfig().set("beds." + player.getUniqueId() + ".bedsLocation." + i + ".world",Main.get().getConfig().get("beds." + player.getUniqueId() + ".bedsLocation." + (i+1) + ".world"));
                Main.get().getConfig().set("beds." + player.getUniqueId() + ".bedsLocation." + i + ".X",Main.get().getConfig().get("beds." + player.getUniqueId() + ".bedsLocation." + (i+1) + ".X"));
                Main.get().getConfig().set("beds." + player.getUniqueId() + ".bedsLocation." + i + ".Y",Main.get().getConfig().get("beds." + player.getUniqueId() + ".bedsLocation." + (i+1) + ".Y"));
                Main.get().getConfig().set("beds." + player.getUniqueId() + ".bedsLocation." + i + ".Z",Main.get().getConfig().get("beds." + player.getUniqueId() + ".bedsLocation." + (i+1) + ".Z"));

            }else{
                Main.get().getConfig().set("beds." + player.getUniqueId() + ".bedsLocation." + i,null);
            }
        }
        Main.get().saveConfig();
    }

    public String getErrorMessage() {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.error")));
    }


}
