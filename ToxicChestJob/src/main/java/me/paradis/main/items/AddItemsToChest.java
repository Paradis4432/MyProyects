package me.paradis.main.items;

import me.paradis.main.Main;
import me.paradis.main.utils.RandomNumber;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AddItemsToChest {

    public void add(Location chestLocation){

        Block b = chestLocation.getBlock();
        Chest chest = (Chest) b.getState();
        Inventory chestInv = chest.getInventory();

        int items = new GetAllItems().getItems();

        for(int i = 0; i<items;i++){
            ItemStack item = ItemStack.deserialize(Main.get().getConfig().getConfigurationSection("items." + i).getValues(true));

            int num = getRandomNum();

            if(num <= 80) chestInv.addItem(item);
            else System.out.println("noup");

            System.out.println(item);

            System.out.println("item " + i + " printed");

        }

        //limit set to 10 with a 80% chance of spawning
        //adds items with a % of happening
        //create random number from 0 to 100 and check if its <= than the number
    }

    public Integer getRandomNum(){
        return new RandomNumber().create();
    }
}
