package me.paradis.main.events;

import me.paradis.main.Main;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.ChestInfo;
import me.paradis.main.utils.EventLocCheck;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickChest implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        System.out.println("test1");
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.CHEST) {
            //check if that chest is in the config file

            int locs = new GetAllLocations().getLocs();

            Block b = event.getClickedBlock();
            System.out.println("block " + b + " locs " + locs);

            for (int chest = 0; chest < locs; chest++) {

                if (new EventLocCheck().check(b, chest)) {
                    System.out.println("chest found at " + event.getClickedBlock().getLocation() + " delete message");

                    //do all checks

                    if (!isUnlocked(chest)) {
                        event.setCancelled(true);
                        Main.get().getConfig().set("locations." + chest + ".clicked" , true);
                        event.getPlayer().sendMessage("add this chest is locked unlocking in " + getTimeLeft(chest));
                    }else{
                        /*
                        wait 5 seocnds
                        delete
                        set spawned to false
                        set cd == 10
                         */
                        int finalChest = chest;
                        Bukkit.getScheduler().runTaskLater(Main.get(), new Runnable() {
                            @Override
                            public void run() {
                                new ChestManager().delete(finalChest);
                                setSpawned(finalChest,false);
                                setClicked(finalChest,false);
                                setUnlocked(finalChest,false);
                                setTimeLeft(finalChest,10);

                                Main.get().saveConfig();
                            }
                        }, 100);
                    }

                    return;
                }


            }
        }
    }

    public void setTimeLeft(Integer chestId, Integer set){
        new ChestInfo().setTimeLEft(chestId,set);
    }

    public void setUnlocked(Integer chestId, Boolean set){
        new ChestInfo().setUnlocked(chestId,set);
    }

    public void setClicked(Integer chestId, Boolean set){
        new ChestInfo().setClicked(chestId,set);
    }

    public void setSpawned(Integer chestId, Boolean set){
        new ChestInfo().setSpawned(chestId,set);
    }

    public boolean isUnlocked(Integer chestId) {
        return new ChestInfo().getUnlocked(chestId);
    }

    public Integer getTimeLeft(Integer chestId) {
        return new ChestInfo().getTimeLeft(chestId);
    }
}
