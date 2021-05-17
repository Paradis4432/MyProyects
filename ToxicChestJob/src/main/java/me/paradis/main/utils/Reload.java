package me.paradis.main.utils;

import me.paradis.main.Main;

public class Reload {

    public void reload(){
        Main.get().saveDefaultConfig();
        Main.get().reloadConfig();
    }
}
