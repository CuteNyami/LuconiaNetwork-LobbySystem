package net.luconia.lobbysystem;

import org.bukkit.inventory.ItemStack;

public class LobbyItem {

    private final ItemStack itemStack;

    private final int slotIndex;

    /**
     * @param itemStack The {@link ItemStack} of the Item
     * @param slotIndex The index of the slot
     */
    public LobbyItem(ItemStack itemStack, int slotIndex) {
        this.itemStack = itemStack;
        this.slotIndex = slotIndex;
    }

    /**
     * Get the slot index
     *
     * @return The given slot index
     */
    public int getSlotIndex() {
        return slotIndex;
    }

    /**
     * Get the ItemStack of the LobbyItem
     *
     * @return the instance of the given {@link ItemStack}
     */
    public ItemStack getItemStack() {
        return itemStack;
    }
}
