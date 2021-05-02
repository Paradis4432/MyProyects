package me.paradis.main.respawnManager;

import me.paradis.main.utils.PlayerInfo;
import org.bukkit.entity.Player;

public class InventorySizeManager {

    public int setSize(Player player) {
        int beds = new PlayerInfo().getAmountOfBeds(player);
        if(beds <= 7)return 27;
        if(beds <= 14)return 36;
        if(beds <= 21)return 45;
        else return 54;
    }
}
