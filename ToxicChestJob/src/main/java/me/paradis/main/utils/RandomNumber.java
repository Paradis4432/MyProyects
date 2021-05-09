package me.paradis.main.utils;

import java.util.Random;

public class RandomNumber {

    public Integer create(){
        Random r = new Random();
        return r.nextInt(100);
    }
}
