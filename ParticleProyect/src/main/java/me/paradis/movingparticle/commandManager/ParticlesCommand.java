package me.paradis.movingparticle.commandManager;

import me.paradis.movingparticle.SchedulerManager.CreateHashMap;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class ParticlesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //sender is not player return
        //if args == 0  open main gui

        if(!(sender instanceof Player)){
            sender.sendMessage("You cant run this command on console");
            return true;
        }

        Player player = (Player) sender;
        Particle particle = Particle.valueOf(args[0]);

        System.out.println("adding " + particle);
        new CreateHashMap().put(player.getUniqueId(), particle);

        return true;
    }
}
