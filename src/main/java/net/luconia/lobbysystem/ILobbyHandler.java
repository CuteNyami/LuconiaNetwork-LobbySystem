package net.luconia.lobbysystem;

import org.bukkit.entity.Player;

import java.util.List;

public interface ILobbyHandler {

    /**
     * Set the lobby items for the player
     *
     * @param lobbyItem The items for the player
     */
    void setLobbyItems(LobbyItem... lobbyItem);


    /**
     * Give the lobby items to a player
     *
     * @param player The given player
     */
    void giveLobbyItemsToPlayer(Player player);

    /**
     * Get the given items for the player
     *
     * @return All lobby items
     */
    List<LobbyItem> getLobbyItems();

}
