package me.paradis.main.cooldown;

import me.paradis.main.Main;
import org.bukkit.entity.Player;

public class CooldownManager {

    public Boolean isOnCooldown(Player player, Integer bedId){
        return (Main.get().getConfig().get("activeBeds." + player.getUniqueId() + "." + bedId)) != null;
    }
}
