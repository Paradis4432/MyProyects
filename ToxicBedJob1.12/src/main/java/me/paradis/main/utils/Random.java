package me.paradis.main.utils;

import me.paradis.main.respawnManager.RespawnLocations;

public class Random {

    public Integer getRandomNumber(){
        java.util.Random r = new java.util.Random();
        return r.nextInt(new RespawnLocations().getAllLocations());
    }
}
