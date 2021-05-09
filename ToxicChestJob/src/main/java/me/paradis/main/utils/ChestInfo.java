package me.paradis.main.utils;

import me.paradis.main.Main;

public class ChestInfo {

    public void setClicked(Integer chestId, Boolean set){
        Main.get().getConfig().set("locations." + chestId + ".clicked" , set);
    }
    public boolean getClicked(Integer chestId){
        return Main.get().getConfig().getBoolean("locations." + chestId + ".clicked");
    }
    public boolean getSpawned(Integer chestId){
        return Main.get().getConfig().getBoolean("locations." + chestId + ".spawned");
    }

    public void setSpawned(Integer chestId, Boolean set){
        Main.get().getConfig().set("locations." + chestId + ".spawned" , set);
    }

    public boolean getUnlocked(Integer chestId){
        return Main.get().getConfig().getBoolean("locations." + chestId + ".unlocked");
    }

    public Integer getTimeLeft(Integer chestId){
        return Main.get().getConfig().getInt("locations." + chestId + ".timeleft");
    }

    public void setUnlocked(Integer chestId, Boolean set){
        Main.get().getConfig().set("locations." + chestId + ".unlocked" , set);
    }

    public void setTimeLEft(Integer chestId, Integer time){
        Main.get().getConfig().set("locations." + chestId + ".timeleft", time);
    }

    public Integer getCd(){
        return Main.get().getConfig().getInt("config.cd");
    }

    public String getWorld(Integer chestId){
        return Main.get().getConfig().getString("locations." + chestId + ".world");
    }

    public Integer getXlocation(Integer chestid){
        return Main.get().getConfig().getInt("locations." + chestid + ".X");
    }

    public Integer getYlocation(Integer chestid){
        return Main.get().getConfig().getInt("locations." + chestid + ".Y");
    }

    public Integer getZlocation(Integer chestid){
        return Main.get().getConfig().getInt("locations." + chestid + ".Z");
    }
}
