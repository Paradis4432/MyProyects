package me.paradis.main.utils;

public class VarType {

    public Boolean check(String s){
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
