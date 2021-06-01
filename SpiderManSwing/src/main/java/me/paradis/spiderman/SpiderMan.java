package me.paradis.spiderman;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public final class SpiderMan extends JavaPlugin implements Listener {

    private static SpiderMan instance;
    private int task;
    private SpiderMan plugin;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();

        // Plugin startup logic
        if (enabled()) {
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "enabling spider man plugin - Paradis");
            getServer().getPluginManager().registerEvents(this, this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean enabled() {
        return getConfig().getBoolean("config.enabled");
    }

    public static SpiderMan getInstance() {
        return instance;
    }

    public static String getString(String s) {
        return new Config().getString(s);
    }

    @EventHandler
    public void Swing(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_AIR) {
            Player player = event.getPlayer();
            Block b = player.getTargetBlock(null, 120);

            if (!b.getType().isAir()) {
                World w = player.getWorld();
                Location l = player.getLocation();

                LivingEntity bat = (LivingEntity) w.spawnEntity(l, EntityType.BAT);
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 100000));
                bat.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 100000));

                Vector v = l.getDirection();
                Arrow arr = w.spawnArrow(l.add(v.clone().normalize().multiply(2)),v,10f,0);
                bat.setLeashHolder(arr);

                BukkitScheduler scheduler = player.getServer().getScheduler();
                task = scheduler.scheduleSyncRepeatingTask(getInstance(), () -> {
                    if(arr.isInBlock()){
                        player.teleport(player.getLocation().add(0,0.5,0));
                        player.setVelocity(v.clone().multiply(5));
                        player.setFallDistance(-100f);
                        bat.remove();
                        arr.remove();
                        scheduler.cancelTask(task);
                    }
                    if(arr.getTicksLived() >= 40){
                        bat.remove();
                        scheduler.cancelTask(task);
                    }
                }, 0L, 10L);
            }
        }
    }
}
