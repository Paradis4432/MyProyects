package me.paradis.enderdrop.main.utils;

import me.paradis.enderdrop.main.Main;

public class Options {

    public Integer getMaxDelay(){
        return Main.get().getConfig().getInt("config.maxDelay");
    }

    public Integer getMinDelay(){
        return Main.get().getConfig().getInt("config.minDelay");
    }

    public Integer getTimeLeft(){
        return Main.get().getConfig().getInt("admin.DoNotEdit.timeLeft");
    }

    public Boolean getIsAlive(){
        return Main.get().getConfig().getBoolean("admin.DoNotEdit.isAlive");
    }

    public Integer getActiveChests(){
        return Main.get().getConfig().getInt("admin.DoNotEdit.activeChests");
    }

    public Integer getMaxChests() {
        System.out.println("test1 getMaxChests called returning: " + Main.get().getConfig().getInt("config.chests"));
        return Main.get().getConfig().getInt("config.chests");
    }

    public Boolean getDebugMode(){
        return Main.get().getConfig().getBoolean("admin.DoNotEdit.debugMode");
    }

    //   if(new Options().getDebugMode())
}
