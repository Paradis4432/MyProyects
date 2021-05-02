package me.paradis.main.events;

import me.paradis.main.Main;
import me.paradis.main.bedManager.DeleteBedsManager;
import me.paradis.main.bedManager.TeleportPlayerToBed;
import me.paradis.main.cooldown.AddBeds;
import me.paradis.main.cooldown.CooldownManager;
import me.paradis.main.utils.Beds;
import me.paradis.main.utils.Messages;
import me.paradis.main.utils.Names;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InvClickEvent implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        //checks the name of the inv to see if its the same
        if (event.getView().getTitle().equals(new Names().getTitleName())) {

            //cancels the event and gets the clicked item
            event.setCancelled(true);
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null || clickedItem.getType() == Material.AIR || clickedItem.getType() != Material.BED) return;
            Player player = (Player) event.getWhoClicked();

            //add time check

            //sends you to the clicked bed location
            //sends the player to the bed location
            if(event.getClick() == ClickType.LEFT){
                if(player.hasPermission("bed.teleport")){
                    //if bed is not on cooldown
                    int bedId = new Beds().getBedName(clickedItem);
                    if(new CooldownManager().isOnCooldown(player, bedId)){
                        player.sendMessage(new Messages().getOnCooldownMessage());
                        return;
                    }
                    //add the bed to the activeBeds
                    new AddBeds().addBed(player,bedId);

                    Main.get().getConfig().set(String.valueOf(player.getUniqueId()), true);

                    new TeleportPlayerToBed().teleportPlayer(player,clickedItem);
                }
            }else if(event.getClick() == ClickType.RIGHT){
                if(player.hasPermission("bed.delete")){
                    Main.get().getConfig().set(String.valueOf(player.getUniqueId()), true);
                    new DeleteBedsManager().deleteBed(player,clickedItem);
                    player.sendMessage(new Messages().deletingBedMessage());
                }
            }
        }
    }
}
