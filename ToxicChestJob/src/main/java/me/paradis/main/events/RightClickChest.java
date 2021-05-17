package me.paradis.main.events;

import me.paradis.main.Main;
import me.paradis.main.chest.ChestManager;
import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.ChestInfo;
import me.paradis.main.utils.Config;
import me.paradis.main.utils.EventLocCheck;
import me.paradis.main.utils.Messages;
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
        try {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.CHEST) {
                //check if that chest is in the config file

                int locs = new GetAllLocations().getLocs();

                Block b = event.getClickedBlock();

                if (debugMode())
                    System.out.println("right click chest detected, info: TotalLocs: " + locs + " block: " + b);

                for (int chest = 0; chest < locs; chest++) {

                    if (new EventLocCheck().check(b, chest)) {
                        if (debugMode()) System.out.println("chest found at " + event.getClickedBlock().getLocation());

                        //do all checks

                        if (!isUnlocked(chest)) {
                            event.setCancelled(true);
                            Main.get().getConfig().set("locations." + chest + ".clicked", true);
                            event.getPlayer().sendMessage(new Messages().getChestBlockedMessage() + getTimeLeft(chest));
                        } else {
                            if (debugMode())
                                System.out.println("waiting 5 seconds to delete, set spawned to false and cd to 10");
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
                                    setSpawned(finalChest, false);
                                    setClicked(finalChest, false);
                                    setUnlocked(finalChest, false);
                                    setTimeLeft(finalChest, 10);

                                    Main.get().saveConfig();
                                }
                            }, 100);
                        }
                        return;
                    }
                }
            }
        } catch (Exception e) {
            if (debugMode()) {
                String name = String.valueOf(this.getClass());
                getErrorMessage(name, e);
            }
        }
    }

    public void getErrorMessage(String name, Exception e) {
        new Messages().errorMessage(name, e);
    }

    public boolean debugMode() {
        return new Config().getDebugMode();
    }

    public void setTimeLeft(Integer chestId, Integer set) {
        new ChestInfo().setTimeLEft(chestId, set);
    }

    public void setUnlocked(Integer chestId, Boolean set) {
        new ChestInfo().setUnlocked(chestId, set);
    }

    public void setClicked(Integer chestId, Boolean set) {
        new ChestInfo().setClicked(chestId, set);
    }

    public void setSpawned(Integer chestId, Boolean set) {
        new ChestInfo().setSpawned(chestId, set);
    }

    public boolean isUnlocked(Integer chestId) {
        return new ChestInfo().getUnlocked(chestId);
    }

    public Integer getTimeLeft(Integer chestId) {
        return new ChestInfo().getTimeLeft(chestId);
    }
}
