package me.paradis.main.limitManager;

import me.paradis.main.Main;

public class GetTotalLimits {

    public Integer getAllLimits(){
        boolean allLimitsFound = false;
        int limitsFound = 0;

        while(!(allLimitsFound)){
            if( (Main.get().getConfig().get("bedLimits." + (limitsFound + 1)) ) == null){
                allLimitsFound = true;
            }else{
                limitsFound++;
            }
        }
        return limitsFound;
    }
}
