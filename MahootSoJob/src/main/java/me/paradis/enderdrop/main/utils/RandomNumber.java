package me.paradis.enderdrop.main.utils;

import me.paradis.enderdrop.main.Main;

import java.util.Random;

public class RandomNumber {

    public Integer getRandomNumber() {
        Random r = new Random();
        int num = r.nextInt(100);
        if(new Options().getDebugMode())System.out.println("Random number function called: " + num);
        return num;
    }
}
