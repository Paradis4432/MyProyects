package me.paradis.enderdrop.main.fireworkManager;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class SpawnFirework {

    public void SpawnFireWork(Location loc){
        Firework f = loc.getWorld().spawn(loc,Firework.class);

        FireworkMeta fm = f.getFireworkMeta();
        fm.addEffect(FireworkEffect.builder()
                .flicker(false)
                .trail(true)
                .with(FireworkEffect.Type.STAR)
                .withColor(Color.GREEN)
                .withFade(Color.BLUE)
                .build());
        fm.setPower(3);
        f.setFireworkMeta(fm);
    }
}
