package net.luconia.lobbysystem.listener;

import net.luconia.lobbysystem.LobbySystem;
import net.luconia.lobbysystem.item.ServerItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();

        if (item == null) return;
        for (ServerItem serverItem : LobbySystem.getInstance().getItems()) {
            serverItem.onClick(event.getClickedInventory(), (Player) event.getWhoClicked(), item);
        }
    }

}
