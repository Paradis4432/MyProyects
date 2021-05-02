package me.paradis.main.utils;

import org.bukkit.entity.Player;

public class Perms {

    public Boolean checkIfPlayerHasPerm(Player player, String s){
        return player.hasPermission(s);
    }
}
