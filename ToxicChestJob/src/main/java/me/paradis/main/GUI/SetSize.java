package me.paradis.main.GUI;

public class SetSize {

    public Integer set(Integer nun) {
        if (nun <= 7) return 27;
        if (nun <= 14) return 36;
        if (nun <= 21) return 45;
        else return 54;
    }
}
