package me.paradis.main.utils;

import me.paradis.main.Main;

public class CreateLore {

    public String getWorld(Integer chestId){
        return Main.get().getConfig().getString("locations." + chestId + ".world");
    }

    public Integer getX(Integer chestId){
        return Main.get().getConfig().getInt("locations." + chestId + ".X");
    }

    public Integer getY(Integer chestId){
        return Main.get().getConfig().getInt("locations." + chestId + ".Y");
    }

    public Integer getZ(Integer chestId){
        return Main.get().getConfig().getInt("locations." + chestId + ".Z");
    }
}
