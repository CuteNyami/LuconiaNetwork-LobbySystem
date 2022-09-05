package net.luconia.lobbysystem.listener;

import net.luconia.lobbysystem.LobbySystem;
import net.luconia.lobbysystem.item.ServerItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            for (ServerItem serverItem : LobbySystem.getInstance().getItems()) {
                serverItem.onInteract(event.getAction(), player, item);
            }
        }
    }
}
