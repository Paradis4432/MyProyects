package me.paradis.enderdrop.main.tiers;

import org.bukkit.ChatColor;

import static org.bukkit.Bukkit.getServer;

public class AmountTiers {

    public Integer getAmountOfTiers() {
        boolean allTiersFound = false;
        int tier = 1;
        //while all tiers not found
        while (!allTiersFound) {
            //get the next tier
            if (Main.get().getConfig().get("tiers." + (tier + 1)) == null) {
                //if not found then stop the while and return tier default = 1
                allTiersFound = true;
            } else {
                //else increase the amount of tiers
                tier++;
            }
        }
        System.out.println("test3 getAmountOfTiers called returning: " + tier);
        return tier;
    }


}
