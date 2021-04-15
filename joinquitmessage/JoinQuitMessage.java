package me.paradis.joinquitmessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinQuitMessage extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Join Quit Message Enabled");
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Join Quit Message Disabled");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (p.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.GREEN + "[+]" + p.getName());
        }else{
            e.setJoinMessage(ChatColor.GREEN + "Welcome" + p.getName() + "To Infinity Craft");
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.RED + "[-]" + p.getName());
    }
}
