package net.luconia.lobbysystem;

import net.luconia.lobbysystem.cape.CapeManager;
import net.luconia.lobbysystem.cape.ICapeHandler;
import net.luconia.lobbysystem.commands.CapeCommand;
import net.luconia.lobbysystem.item.ServerItem;
import net.luconia.lobbysystem.item.impl.GameSelector;
import net.luconia.lobbysystem.listener.InteractListener;
import net.luconia.lobbysystem.listener.InventoryClickListener;
import net.luconia.lobbysystem.listener.JoinListener;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LobbySystem extends JavaPlugin {

    private static LobbySystem instance;

    private final Map<String, ArmorStand> capes = new HashMap<>();

    private final List<ServerItem> items = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        registerListeners(new JoinListener(), new InteractListener(), new InventoryClickListener());
        getCommand("cape").setExecutor(new CapeCommand());

        registerServerItem(new GameSelector());
    }

    /**
     * Register multiple {@link Listener} at once
     *
     * @param listeners The {@link Listener} to register
     */
    public void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            this.getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    /**
     * Unregister multiple {@link Listener} at once
     *
     * @param listeners The {@link Listener} to unregister
     */
    public void unregisterListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            HandlerList.unregisterAll(listener);
        }
    }

    /**
     * Register a ItemInteract to for adding a function to a Item
     *
     * @param item The {@link ServerItem} to register
     */
    public void registerServerItem(ServerItem item) {
        this.items.add(item);
    }

    /**
     * Get the LobbyManager
     *
     * @return A new instance of the {@link LobbyManager} class
     * @see ILobbyHandler
     */
    public ILobbyHandler getLobbyManager() {
        return new LobbyManager();
    }

    /**
     * Get the CapeManager
     *
     * @return A new instance of the {@link CapeManager} class
     * @see ICapeHandler
     */
    public ICapeHandler getCapeManager() {
        return new CapeManager();
    }

    /**
     * Get the instance of the {@link LobbySystem} class
     *
     * @return The instance of the class
     * @see LobbySystem
     */
    public static LobbySystem getInstance() {
        return instance;
    }

    /**
     * Get the instance of the capes map
     *
     * @return The instance of the Map
     */
    public Map<String, ArmorStand> getCapes() {
        return capes;
    }

    /**
     * Get the items list
     *
     * @return The list
     */
    public List<ServerItem> getItems() {
        return items;
    }
}
