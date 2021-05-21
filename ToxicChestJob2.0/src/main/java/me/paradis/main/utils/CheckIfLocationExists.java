package me.paradis.main.utils;

import me.paradis.main.Main;
import me.paradis.main.Messages.GetMessage;

public class CheckIfLocationExists {

    public boolean check(int locID){
        return (Main.get().getConfig().get("locations." + locID)) != null;
    }
}
