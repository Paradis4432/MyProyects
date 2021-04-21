package me.paradis.coinflip.main.utils;

import org.bukkit.Bukkit;

public class GeneralUtils {

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

    public static int getMinecraftVersion() {
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        return Integer.parseInt(packageName.split("_")[1]);
    }


}
