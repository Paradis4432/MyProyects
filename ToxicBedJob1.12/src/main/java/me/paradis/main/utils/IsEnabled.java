package me.paradis.main.utils;

import me.paradis.main.Main;

public class IsEnabled {

    public Boolean getWarningMessageEnabled(){
        return Main.get().getConfig().getBoolean("warningMessage.enabled");
    }
}
