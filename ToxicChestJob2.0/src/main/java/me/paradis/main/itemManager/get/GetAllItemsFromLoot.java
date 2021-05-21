package me.paradis.main.itemManager.get;

import me.paradis.main.Main;

public class GetAllItemsFromLoot {
    /**
     * @return all items found in config
     */
    public Integer get(int locationID, int lootID) {
        boolean allItemsFound = false;
        int items = 0;
        while (!allItemsFound) {
            if ((Main.get().getConfig().get("locations." + locationID + ".loots." + lootID + ".items." + (items + 1))) == null) {
                allItemsFound = true;
            } else {
                items++;
            }
        }
        return items;
    }
}
