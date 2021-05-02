package me.paradis.main.limitManager;

import me.paradis.main.Main;
import org.bukkit.entity.Player;

import java.util.Objects;

public class BiggestLimit {

    public Integer getLimit(Player player){
        int max = 0;
        int totalLimits = new GetTotalLimits().getAllLimits();

        System.out.println("test1 max: " + max + " totallimits: " +  totalLimits);

        for(int i = 1; i <= totalLimits; i++){
            System.out.println("test2 " + i);
            if(hasPerm(player,i)){
                System.out.println("test3 "+getAmount(i));
                if(getAmount(i) >= max){
                    System.out.println("test4 " +getAmount(i) + " max " + max);
                    max = getAmount(i);
                }
            }
        }

        System.out.println("test5 returning" + max);
        return max;
    }

    public Boolean hasPerm(Player player, Integer i){
        return player.hasPermission(Objects.requireNonNull(Main.get().getConfig().getString("bedLimits." + i + ".permission")));
    }

    public Integer getAmount(Integer i){
        return Main.get().getConfig().getInt("bedLimits." + i + ".amount");
    }
}
