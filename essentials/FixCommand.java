package com.infinitycraft.plugin.general.essentials;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FixCommand implements CommandExecutor {

    //usage: /fix [hand/all] [player]

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command on console!");
            return true;
        }

        Player player = (Player) sender;

        if (CheckPermission.checkPerm("essentials.fix", player)) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.DARK_RED + "Usage: /fix [hand/all]");
                return true;
            }

            if (args.length >= 3) {
                player.sendMessage(ChatColor.DARK_RED + "Usage: /fix [hand/all]");
                return true;
            }

            if (CheckPermission.checkPerm("essentials.fix.hand", player)) {
                player.getInventory().getItemInMainHand().setDurability((short) 0);
                player.updateInventory();
                return true;
            }

            if (CheckPermission.checkPerm("essentials.fix.all", player)) {
                final List<ItemStack> itemsInInv = new ArrayList<>();

                for (ItemStack stack : player.getInventory().getContents()) {

                    if (stack != null
                            && stack.getType() != Material.AIR
                            && !stack.getType().isBlock()
                            && !stack.getType().isEdible()
                            && stack.getType().getMaxDurability() > 0
                            && stack.getDurability() != 0) {

                        itemsInInv.add(stack);
                    }

                    for (ItemStack items : itemsInInv) stack.setDurability((short) 0);
                    player.updateInventory();

                }

                return true;
            }


        }
        return true;
    }
}

