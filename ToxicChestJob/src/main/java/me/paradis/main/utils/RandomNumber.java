package me.paradis.main.utils;

import java.util.Random;

public class RandomNumber {

    public Integer create(int num){
        Random r = new Random();
        return r.nextInt(num);
    }
}
