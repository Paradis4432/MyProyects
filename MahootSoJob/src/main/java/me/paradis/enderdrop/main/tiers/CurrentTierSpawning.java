package me.paradis.enderdrop.main.tiers;

import org.bukkit.ChatColor;

import static org.bukkit.Bukkit.getServer;

public class CurrentTierSpawning {

    public Integer getTierSpawning() {
        if(Main.get().getConfig().getBoolean("admin.DoNotEdit.newChestSpawning")){
            int randomNumber = getRandomNumber();
            System.out.println("test5.2 randomNumber: " + randomNumber);
            int tiers = getAmountOfTiers();
            //loops the amount of tiers there is
            for (int tiersCount = 1; tiersCount <= tiers; tiersCount++) {
                //if the random generated number is <= than the chance of the tier then it returns the current tier
                if (randomNumber <= Main.get().getConfig().getInt("tiers." + tiersCount + ".chance")) {
                    System.out.println("test5 getTierSpawning called returning: " + tiersCount);
                    System.out.println("test5.1 tiers: " + tiers);
                    Main.get().getConfig().set("admin.DoNotEdit.newChestSpawning", false);
                    Main.get().saveConfig();
                    return tiersCount;
                }
            }
        }else{
            System.out.println("test5.3 returning: " + Main.get().getConfig().getInt("admin.DoNotEdit.currentRandomNumber"));
            return Main.get().getConfig().getInt("admin.DoNotEdit.currentRandomNumber");
        }

        //default returns null with warning
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Fatal Error: Tiers Not Found");
        return null;
    }

    public Integer getAmountOfItemsOnTier() {
        boolean allItemsFound = false;
        int itemCount = 1;
        int currentTier = getTierSpawning();
        while (!allItemsFound) {
            if ((Main.get().getConfig().get("tiers." + currentTier + ".items." + (itemCount + 1))) == null) {
                allItemsFound = true;
            } else {
                itemCount++;
            }
        }
        System.out.println("test4 getAmountOfItemsOnTier called returning: " + itemCount );
        return itemCount;
    }
}
