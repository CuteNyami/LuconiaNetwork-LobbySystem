package net.luconia.lobbysystem.cape;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public interface ICapeHandler {

    /**
     * Give the player a banner cape
     *
     * @param player The player who gets the cape
     * @param banner The banner to give
     */
    void setCape(Player player, ItemStack banner);

    /**
     * Remove a banner cape from the player
     *
     * @param player The player who loses the cape
     * @return "true" if cape was removed, "false" if not
     */
    boolean removeCape(Player player);

    /**
     * Check if the player has a cape
     *
     * @param player The given player
     * @return "true" if the player have a cape, "false" if not
     */
    boolean haveCape(Player player);

    /**
     * Get the cape of a specific player
     *
     * @param player The given player
     * @return The {@link ItemStack} of the players cape, if the player don't have a cape "null"
     */
    ItemStack getCape(Player player);

    /**
     * Get all capes
     *
     * @return The cape map
     */
    Map<String, ArmorStand> getCapes();
}
