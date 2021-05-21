package me.paradis.main.itemManager.addItem;

import me.paradis.main.Main;
import me.paradis.main.Messages.GetMessage;
import me.paradis.main.itemManager.get.GetAllItemsFromLoot;
import me.paradis.main.utils.CheckIfItemInHandIsAir;
import me.paradis.main.utils.CheckIfLocationExists;
import me.paradis.main.utils.CheckIfLootExists;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AddItemCommand {
    /**
     * @param locationID the location where the item will be added
     * @param lootID     the loot where the item will be added
     */

    public void add(int locationID, int lootID, ItemStack item, Player player) {

        if (Main.get().debugMode()) System.out.println("CHEST adding item");

        int itemID = new GetAllItemsFromLoot().get(locationID, lootID);

        //if the location exists then add item
        if(!(new CheckIfLocationExists().check(locationID))){
            player.sendMessage(new GetMessage().get("noLocationFound"));
            return;
        }

        //if loot exists then add item
        if(!(new CheckIfLootExists().check(locationID,lootID))){
            player.sendMessage(new GetMessage().get("noLootFound"));
            return;
        }

        if(new CheckIfItemInHandIsAir().check(item)){
            player.sendMessage(new GetMessage().get("itemIsAir"));
            return;
        }

        Main.get().getConfig().set("locations." + locationID + ".loots." + lootID + ".items." + (itemID+1), item);
        Main.get().saveConfig();

        player.sendMessage(new GetMessage().get("itemSaved"));

        if(Main.get().debugMode()) System.out.println("CHEST item added");
    }

}
