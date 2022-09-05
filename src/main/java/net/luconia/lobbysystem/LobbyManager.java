package net.luconia.lobbysystem;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LobbyManager implements ILobbyHandler {

    private final List<LobbyItem> lobbyItems = new ArrayList<>();

    @Override
    public void setLobbyItems(LobbyItem... lobbyItems) {
        Collections.addAll(this.lobbyItems, lobbyItems);
    }

    @Override
    public void giveLobbyItemsToPlayer(Player player) {
        for (LobbyItem lobbyItem : lobbyItems) {
            player.getInventory().setItem(lobbyItem.getSlotIndex(), lobbyItem.getItemStack());
        }
    }

    @Override
    public List<LobbyItem> getLobbyItems() {
        return lobbyItems;
    }
}
