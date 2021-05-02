package me.paradis.main.utils;

import me.paradis.main.Main;

public class Cooldown {

    public Integer getCooldownFromConfig(){
        return Main.get().getConfig().getInt("config.bedDelay");
    }
}
