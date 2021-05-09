package me.paradis.main.GUI;

import me.paradis.main.locations.GetAllLocations;
import me.paradis.main.utils.CreateItems;
import me.paradis.main.utils.CreateLore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OpenRemoveLocationGui {

    public void open(Player player){
        int totalLocs = new GetAllLocations().getLocs();


        Inventory removeLocsInv = Bukkit.createInventory(null, 54,"remove location");

        //removeLocsInv = new AddDefaultItems().add(removeLocsInv);

        for(int locs = 0; locs < totalLocs; locs++){
            //up to 28 locations before having to add another page
            //add the listener
            try{
                //Adds the location of the chest to the lore
                ItemStack locItem = createItem(Material.COMPASS, "Click here to delete chest ID: " + locs,
                        world(locs),
                        X(locs),
                        Y(locs),
                        Z(locs));

                removeLocsInv.setItem(removeLocsInv.firstEmpty(), locItem);
            }catch (Exception e){
                System.out.println("Add error message OpenRemoveLocationGui.open");
            }
        }

        player.openInventory(removeLocsInv);
    }

    public ItemStack createItem(final Material material, final String name, final String... lore){
        return new CreateItems().create(material,name,lore);
    }

    public String world(Integer chestId){
        return new CreateLore().getWorld(chestId);
    }

    public String X(Integer chestId){
        return String.valueOf(new CreateLore().getX(chestId));
    }

    public String Y(Integer chestId){
        return String.valueOf(new CreateLore().getY(chestId));
    }

    public String Z(Integer chestId){
        return String.valueOf(new CreateLore().getZ(chestId));
    }
}
