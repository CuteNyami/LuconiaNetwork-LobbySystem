package net.luconia.lobbysystem.item.impl;

import net.luconia.lobbysystem.item.ServerItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GameSelector extends ServerItem {
    @Override
    public void onClick(Inventory inventory, Player player, ItemStack item) {
        if (item.getType() != Material.APPLE && !inventory.getTitle().equals("§8Games")) return;
        System.out.println("It works");
    }

    @Override
    public void onInteract(Action action, Player player, ItemStack item) {
        Inventory inventory = Bukkit.createInventory(null, 27, "§8Games");

        if (!item.getItemMeta().getDisplayName().equals("§8Games")) return;
        inventory.addItem(new ItemStack(Material.APPLE));
        player.openInventory(inventory);
    }
}
