package me.paradis.main.lootManager.addLoot;

import me.paradis.main.Main;
import me.paradis.main.Messages.GetMessage;
import me.paradis.main.lootManager.get.GetAllLootsFromLocation;
import me.paradis.main.utils.CheckIfItemInHandIsAir;
import me.paradis.main.utils.CheckIfLocationExists;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AddLootCommand {

    /**
     * add the item in hand to the next possible loot, if theres 3 loots it will add the item
     * in hand to lootID 4
     * adds the item to the location in param
     *
     * @param locID the number of the location
     * @param item  the item in hand
     */


    public void add(Player player, int locID, ItemStack item) {

        if (Main.get().debugMode()) System.out.println("CHEST adding loot");

        Integer lootID = new GetAllLootsFromLocation().get(locID);

        if(new CheckIfItemInHandIsAir().check(item)){
            player.sendMessage(new GetMessage().get("itemIsAir"));
            return;
        }

        //if the location exists then add item
        if(!(new CheckIfLocationExists().check(locID))){
            player.sendMessage(new GetMessage().get("noLocationFound"));
            return;
        }

        Main.get().getConfig().set("locations." + locID + ".loots." + (lootID + 1) + ".items.1", item);

        player.sendMessage(new GetMessage().get("itemSaved"));

        Main.get().saveConfig();

        if (Main.get().debugMode()) System.out.println("CHEST loot added");
    }
}
