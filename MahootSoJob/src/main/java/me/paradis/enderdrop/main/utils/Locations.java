package me.paradis.enderdrop.main.utils;

import me.paradis.enderdrop.main.Main;

public class Locations {

    public String getWorldSpawn(){
        return (String) Main.get().getConfig().get("config.spawnEnderDragon.world");
    }

    public Integer getXSpawn(){
        return Main.get().getConfig().getInt("config.spawnEnderDragon.X");
    }

    public Integer getYSpawn(){
        return Main.get().getConfig().getInt("config.spawnEnderDragon.Y");
    }

    public Integer getZSpawn(){
        return Main.get().getConfig().getInt("config.spawnEnderDragon.Z");
    }
}
