package me.paradis.main.itemManager.get;

import me.paradis.main.Main;

public class GetAllItems {

    public Integer get(){
        boolean allItemsFound = false;
        int items = 0;
        while(!allItemsFound){
            if( (Main.get().getConfig().get("" + items)) == null){
                allItemsFound = true;
            }else{
                items++;
            }
        }
        return items;
    }
}
