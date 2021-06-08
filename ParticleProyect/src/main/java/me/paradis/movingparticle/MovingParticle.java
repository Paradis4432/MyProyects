package me.paradis.movingparticle;

import me.paradis.movingparticle.SchedulerManager.StartSchedule;
import me.paradis.movingparticle.commandManager.ParticlesCommand;
import me.paradis.movingparticle.configManager.Config;
import me.paradis.movingparticle.debugManager.Debug;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MovingParticle extends JavaPlugin {

    private static MovingParticle instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        this.saveDefaultConfig();

        if (enabled()) {
            new Debug().log("&a--------------------------");
            new Debug().log("&aMoving Particles Enabled");
            new Debug().log("&6Made By Paradis#4432");
            new Debug().log("&a--------------------------");

            //register commands
            registerCommands();
            //register events
            //register cooldowns
            registerSchedules();
            //initialize hashmap


        }
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("particles")).setExecutor(new ParticlesCommand());
    }

    public void registerSchedules(){
        new StartSchedule().start();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        new Debug().log("&c--------------------------");
        new Debug().log("&cMoving Particles Disabled");
        new Debug().log("&6Made By Paradis#4432");
        new Debug().log("&c--------------------------");
    }

    public boolean enabled() {
        return (boolean) new Config().get("config.enabled");
    }

    public static MovingParticle getInstance() {
        return instance;
    }

}
