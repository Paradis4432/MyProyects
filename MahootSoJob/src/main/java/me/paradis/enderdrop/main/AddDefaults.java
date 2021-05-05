package me.paradis.enderdrop.main;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;

public class AddDefaults {

    FileConfiguration config = Main.get().getConfig();
    public void addDefaults(){
        String[] defaultLore = {"first Default Lore", "second Default Lore"};
        String[] defaultEnchantsDiaBlock = {"DAMAGE_ALL:4", "FIRE_ASPECT:2"};
        String[] defaultEnchantsCoalBlock = {"SILK_TOUCH:3", "MENDING:5"};
        String[] defaultEnchantsEmeraldBlock = {"SHARPNESS:4", "UNBREAKING:2"};

        config.addDefault("enabled", true);

        config.addDefault("config.minDelay", 20);
        config.addDefault("config.maxDelay", 40);
        config.addDefault("config.chests" , 10);
        config.addDefault("config.delayBetweenChests" , 5);

        config.addDefault("config.holograms.timeLeft.world", "world");
        config.addDefault("config.holograms.timeLeft.X" , 0);
        config.addDefault("config.holograms.timeLeft.Y" , 0);
        config.addDefault("config.holograms.timeLeft.Z" , 0);

        config.addDefault("config.spawnEnderDragon.world" , "the_end");
        config.addDefault("config.spawnEnderDragon.X" , 0);
        config.addDefault("config.spawnEnderDragon.Y" , 0);
        config.addDefault("config.spawnEnderDragon.Z" , 0);

        config.addDefault("messages.noPermMessage", "&4You Dont Have Permission To Do That");
        config.addDefault("messages.spawnEnderDragonMessage", "&6Spawning Ender Dragon");
        config.addDefault("messages.killEnderDragonMessage", "&cKilling Ender Dragon");
        config.addDefault("messages.locationSaved" , "&6Location saved!");
        config.addDefault("messages.error" , "&4There was an error pleaes contact the developer");

        //default tier 1 items
        //default diamond block
        config.addDefault("tiers.1.chance",  50);
        config.addDefault("tiers.1.items.1.type",  "diamond block");
        config.addDefault("tiers.1.items.1.name",  "diamond");
        config.addDefault("tiers.1.items.1.amount",  2);
        config.addDefault("tiers.1.items.1.lore", Arrays.asList(defaultLore));
        config.addDefault("tiers.1.items.1.enchants", Arrays.asList(defaultEnchantsDiaBlock));

        //default gold block
        config.addDefault("tiers.1.items.2.type",  "gold block");
        config.addDefault("tiers.1.items.2.name",  "gold");
        config.addDefault("tiers.1.items.2.amount",  5);
        config.addDefault("tiers.1.items.2.lore", Arrays.asList(defaultLore));

        //default coal block
        config.addDefault("tiers.1.items.3.type",  "coal block");
        config.addDefault("tiers.1.items.3.name",  "coal");
        config.addDefault("tiers.1.items.3.amount",  100);
        config.addDefault("tiers.1.items.3.lore", Arrays.asList(defaultLore));
        config.addDefault("tiers.1.items.3.enchants", Arrays.asList(defaultEnchantsCoalBlock));

        //default tier 2 items
        //default emerald block
        config.addDefault("tiers.2.chance",  100);
        config.addDefault("tiers.2.items.1.type",  "emerald block");
        config.addDefault("tiers.2.items.1.name",  "emerald");
        config.addDefault("tiers.2.items.1.amount",  2);
        config.addDefault("tiers.2.items.1.lore", Arrays.asList(defaultLore));
        config.addDefault("tiers.2.items.1.enchants", Arrays.asList(defaultEnchantsEmeraldBlock));

        //default redstone block
        config.addDefault("tiers.2.items.2.type",  "redstone block");
        config.addDefault("tiers.2.items.2.name",  "redstone");
        config.addDefault("tiers.2.items.2.amount",  10);
        config.addDefault("tiers.2.items.2.lore", Arrays.asList(defaultLore));

        config.addDefault("admin.DoNotEdit.timeLeft",0);
        config.addDefault("admin.DoNotEdit.isAlive",false);
        config.addDefault("admin.DoNotEdit.debugMode",true);
        config.addDefault("admin.DoNotEdit.activeChests",0);

        config.options().copyDefaults(true);
    }
}
