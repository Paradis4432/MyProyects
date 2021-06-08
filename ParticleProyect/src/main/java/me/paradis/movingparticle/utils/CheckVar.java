package me.paradis.movingparticle.utils;

public class CheckVar {

    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isBoolean(String str) {
        if (str.equals("true") || str.equals("false")) return true;
        else return false;
    }
}
