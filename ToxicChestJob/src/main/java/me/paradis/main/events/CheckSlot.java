package me.paradis.main.events;

public class CheckSlot {

    public boolean isOutSide(Integer slot, Integer size){
        //if slot is any of the outside ones then return true
        return slot <= 8 || slot % 9 == 0 || (slot + 1) % 9 == 0 || slot >= (size - 9);
    }
}
