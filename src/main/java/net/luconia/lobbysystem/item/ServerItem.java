package net.luconia.lobbysystem.item;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class ServerItem {

    /**
     * Called when a player clicks on an item
     *
     * @param inventory The given inventory
     * @param player    The given player
     */
    public abstract void onClick(Inventory inventory, Player player, ItemStack item);

    /**
     * Called when the player interacts with an item
     *
     * @param action The given {@link Action}
     * @param player The given player
     * @param item   The given Item
     */
    public abstract void onInteract(Action action, Player player, ItemStack item);

}
