package net.luconia.lobbysystem.listener;

import net.luconia.lobbysystem.ILobbyHandler;
import net.luconia.lobbysystem.LobbyItem;
import net.luconia.lobbysystem.LobbySystem;
import net.luconia.lobbysystem.cape.ICapeHandler;
import net.luconia.lobbysystem.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    /**
     * It's called when a player is joining the server
     *
     * @param event The given event
     * @see PlayerJoinEvent
     */
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ILobbyHandler handler = LobbySystem.getInstance().getLobbyManager();
        ICapeHandler capeHandler = LobbySystem.getInstance().getCapeManager();

        LobbyItem gameSelector = new ItemBuilder(Material.COMPASS).setName("§8Games").toLobbyItem(4);
        handler.setLobbyItems(gameSelector);
        handler.giveLobbyItemsToPlayer(player);

        //capeHandler.setCape(player, new ItemStack(Material.BANNER));
    }

}
