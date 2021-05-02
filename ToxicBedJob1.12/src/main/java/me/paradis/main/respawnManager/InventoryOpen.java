package me.paradis.main.respawnManager;

import me.paradis.main.bedManager.CheckIfBedIsAlive;
import me.paradis.main.bedManager.DeleteBedsManager;
import me.paradis.main.utils.Lores;
import me.paradis.main.utils.Names;
import me.paradis.main.utils.PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class InventoryOpen {
    public void openInventory(Player player) {
        //create the inventory
        Inventory inv = Bukkit.createInventory(null, new InventorySizeManager().setSize(player), new Names().getTitleName());

        ItemStack whitePanel = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)0);
        ItemStack blackPanel = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)15);

        //adds default items
        inv = addDefaultItems(whitePanel,player,inv);
        //adds the items to the gui
        inv = addItems(inv, player);
        //adds the black panel items
        inv = addFillItems(blackPanel,player, inv);

        player.openInventory(inv);
    }

    public Inventory addFillItems(ItemStack blackPanel,Player player, Inventory inv){
        int size = new InventorySizeManager().setSize(player);
        for(int pos=0;pos < size; pos++){
            if(inv.getItem(pos) == null) inv.setItem(pos,blackPanel);
        }
        return inv;
    }

    public Inventory addDefaultItems(ItemStack whitePanel,Player player, Inventory inv){
        int size = new InventorySizeManager().setSize(player);
        for(int pos = 0; pos < size; pos++){
            if(pos <= 8) inv.setItem(pos, whitePanel);
            if(pos % 9 == 0 && pos > 1){
                inv.setItem((pos-1), whitePanel);
                inv.setItem(pos, whitePanel);
            }
            if(pos >= (size - 9)) inv.setItem(pos,whitePanel);
        }
        return inv;
    }
    public Inventory addItems(Inventory inv, Player player) {

        //creates the items
        for (int beds = 0; beds < new PlayerInfo().getAmountOfBeds(player); beds++) {
            if (new CheckIfBedIsAlive().IsBed(player, beds)) {
                ItemStack item = createItem(Material.BED, String.valueOf(beds + 1),
                        new Lores().loreWorld(player, beds),
                        String.valueOf(new Lores().loreLocationX(player, beds)),
                        String.valueOf(new Lores().loreLocationY(player, beds)),
                        String.valueOf(new Lores().loreLocationZ(player, beds)));
                inv.setItem(inv.firstEmpty(), item);
            }else{
                new DeleteBedsManager().deleteBedIfNotAlive(player, (beds+1));
            }
        }
        return inv;
    }

    public ItemStack createItem(final Material material, final String name, final String... lore) {
        //creates the item to be added
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        //sets the meta
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }
}
