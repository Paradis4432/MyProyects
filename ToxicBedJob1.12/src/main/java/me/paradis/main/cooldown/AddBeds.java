package me.paradis.main.cooldown;

import me.paradis.main.Main;
import me.paradis.main.utils.Cooldown;
import org.bukkit.entity.Player;

public class AddBeds {

    public void addBed(Player player, Integer bedId){
        Main.get().getConfig().set("activeBeds." + player.getUniqueId() + "." + bedId , new Cooldown().getCooldownFromConfig());
        Main.get().saveConfig();
    }
}
