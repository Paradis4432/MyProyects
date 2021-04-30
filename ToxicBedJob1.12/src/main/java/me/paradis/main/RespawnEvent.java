package me.paradis.main;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Arrays;
import java.util.Objects;

public class RespawnEvent implements Listener {

    private Inventory inv;
    @EventHandler
    public void onRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if(getWarningMessageEnabled()){
            player.sendMessage(getWarningMessage());
        }
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(Main.get(), new Runnable() {
            @Override
            public void run() {
                openInventory(player);
            }
        }, 40L);

    }

    public void openInventory(Player player){
        //create the inventory
        Inventory inv = Bukkit.createInventory(null, 54, getTitleName());

        //adds the items to the gui
        inv = addItems(inv, player);

        player.openInventory(inv);
    }

    public Inventory addItems(Inventory inv, Player player){
        //creates the items
        for(int beds = 0;beds < getAmountOfBeds(player); beds++){
            inv.setItem(inv.firstEmpty(), createItem(Material.COMPASS, String.valueOf(beds+1), loreWorld(player, beds),  String.valueOf(loreLocationX(player,beds)), String.valueOf(loreLocationY(player,beds)), String.valueOf(loreLocationZ(player,beds))));
        }

        return inv;
    }

    //gets the location of the bed in X Y Z WORLD as lore of the bed
    public String loreWorld(Player player, Integer beds){
        return(Main.get().getConfig().getString("beds." + player.getUniqueId() + ".bedsLocation." + (beds+1) + ".world"));
    }

    public Integer loreLocationX(Player player, Integer beds){
        return (Main.get().getConfig().getInt("beds." + player.getUniqueId() + ".bedsLocation." + (beds+1) + ".X"));
    }

    public Integer loreLocationY(Player player, Integer beds){
        return (Main.get().getConfig().getInt("beds." + player.getUniqueId() + ".bedsLocation." + (beds+1) + ".Y"));
    }

    public Integer loreLocationZ(Player player, Integer beds){
        return (Main.get().getConfig().getInt("beds." + player.getUniqueId() + ".bedsLocation." + (beds+1) + ".Z"));
    }

    public Integer getAmountOfBeds(Player player){
        Boolean allBedsFound = false;
        int bedscount = 0;

        while(!allBedsFound){
            if((Main.get().getConfig().get("beds." + player.getUniqueId() + ".bedsLocation." + (bedscount + 1))) == null){
                allBedsFound = true;
            }else{
                bedscount ++;
            }
        }
        return bedscount;

    }

    public ItemStack createItem(final Material material, final String name, final String... lore){
        //creates the item to be added
        ItemStack item = new ItemStack(material,1);
        ItemMeta meta = item.getItemMeta();

        //sets the meta
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        //checks the name of the inv to see if its the same
        if (event.getView().getTitle().equals(getTitleName())) {

            //cancels the event and gets the clicked item
            event.setCancelled(true);
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
            Player player = (Player) event.getWhoClicked();

            //add time check

            //sends you to the clicked bed location
            //sends the player to the bed location
            if(event.getClick() == ClickType.LEFT){
                if(player.hasPermission("bed.teleport")){
                    teleportPlayer(player,clickedItem);
                    player.sendMessage(getSendingMessage());
                }
            }else if(event.getClick() == ClickType.RIGHT){
                if(player.hasPermission("bed.delete")){
                    new DeleteManager().deleteBed(player,clickedItem);
                    player.sendMessage(deletingBedMessage());
                }
            }
        }
    }

    public void teleportPlayer(Player player, ItemStack clickedItem){
        //teleports the player to the location of the bed
        Location loc = new Location(Bukkit.getWorld(Objects.requireNonNull(clickedItem.getItemMeta().getLore()).get(0)) , Double.parseDouble(clickedItem.getItemMeta().getLore().get(1)),Double.parseDouble(clickedItem.getItemMeta().getLore().get(2)),Double.parseDouble(clickedItem.getItemMeta().getLore().get(3)));
        player.teleport(loc);
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event){
        if (event.getView().getTitle().equals(getTitleName())) {
            //cancels the event
            event.setCancelled(true);
        }
    }

    public String deletingBedMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.deletingBedMessage")));
    }

    public String getNoPermMessage() {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.noPermMessage")));
    }

    public String getTitleName(){
        return ChatColor.translateAlternateColorCodes('&' , Objects.requireNonNull(Main.get().getConfig().getString("respawnTitleName")));
    }

    public String getSendingMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("messages.sendingMessage")));
    }

    public Boolean getWarningMessageEnabled(){
        return Main.get().getConfig().getBoolean("warningMessage.enabled");
    }

    public String getWarningMessage(){
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.get().getConfig().getString("warningMessage.message")));
    }

}
