package me.paradis.main.items;

import me.paradis.main.Main;

public class GetAllItems {

    public Integer getItems(){
        boolean allItemsFound = false;
        int items = 0;
        while(!allItemsFound){
            if( (Main.get().getConfig().get("items." + items)) == null){
                allItemsFound = true;
            }else{
                items++;
            }
        }
        return items;
    }
}
