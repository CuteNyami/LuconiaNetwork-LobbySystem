package net.luconia.lobbysystem.utils;

import net.luconia.lobbysystem.LobbyItem;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ItemBuilder for creating Items with custom names or other stuff
 *
 * @author Nyami
 */
public class ItemBuilder {

    private final ItemStack itemStack;

    /**
     * Create a new ItemBuilder with an existing ItemStack
     *
     * @param itemStack The ItemStack to create the ItemBuilder
     */
    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * Create a new ItemBuilder using a material
     *
     * @param material The Material of the item
     */
    public ItemBuilder(Material material) {
        this(material, 1);
    }

    /**
     * Create a new ItemBuilder with a material and an amount of the item
     *
     * @param material The Material of the item
     * @param amount   The amount of the item
     */
    public ItemBuilder(Material material, int amount) {
        itemStack = new ItemStack(material, amount);
    }

    /**
     * Create a new ItemBuilder with a material and an amount and with the durability of the item
     *
     * @param material   The Material of the item
     * @param amount     The amount of the item
     * @param durability The durability of the item
     */
    public ItemBuilder(Material material, int amount, byte durability) {
        itemStack = new ItemStack(material, amount, durability);
    }

    /**
     * Change the durability of the item
     *
     * @param durability The durability to set it to
     */
    public ItemBuilder setDurability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }

    /**
     * Change the name of the item
     *
     * @param name The name to set it to
     */
    public ItemBuilder setName(String name) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        return this;
    }

    /**
     * Add an enchantment to the item
     *
     * @param enchantment The enchantment to add
     * @param level       The level for the enchantment
     */
    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.addEnchant(enchantment, level, true);
        itemStack.setItemMeta(meta);
        return this;
    }

    /**
     * Add multiple enchantments to the item
     *
     * @param enchantments The enchantments to add
     */
    public ItemBuilder addEnchantments(Map<Enchantment, Integer> enchantments) {
        itemStack.addEnchantments(enchantments);
        return this;
    }

    /**
     * Remove an enchantment from the item
     *
     * @param enchantment The enchantment to remove
     */
    public ItemBuilder removeEnchantment(Enchantment enchantment) {
        itemStack.removeEnchantment(enchantment);
        return this;
    }

    /**
     * Sets the durability to infinite
     */
    public ItemBuilder setInfinityDurability() {
        itemStack.setDurability(Short.MAX_VALUE);
        return this;
    }

    /**
     * Set the skull owner for the item. The item must be a skull.
     *
     * @param owner The name of the skull owner
     */
    public ItemBuilder setSkullOwner(String owner) {
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwner(owner);
        return this;
    }

    /**
     * Set the item lore
     *
     * @param lore The lore to set it to
     */
    public ItemBuilder setLore(String... lore) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(meta);
        return this;
    }

    /**
     * Remove a lore line
     *
     * @param line The line to remove
     */
    public ItemBuilder removeLoreLine(String line) {
        ItemMeta meta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>(meta.getLore());

        if (!lore.contains(lore)) return this;
        lore.remove(line);

        meta.setLore(lore);

        itemStack.setItemMeta(meta);
        return this;
    }

    /**
     * Remove a lore line with its index
     *
     * @param index The index of the lore line
     */
    public ItemBuilder removeLoreLine(int index) {
        ItemMeta meta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>(meta.getLore());

        if (index < 0 || index > lore.size()) return this;
        lore.remove(index);

        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return this;
    }

    /**
     * Add a lore line
     *
     * @param line The given line
     */
    public ItemBuilder addLoreLine(String line) {
        ItemMeta meta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>();

        if (meta.hasLore()) lore = new ArrayList<>(meta.getLore());
        lore.add(line);

        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return this;
    }

    /**
     * Add a lore line
     *
     * @param line  The given line
     * @param index The index of the line
     */
    public ItemBuilder addLoreLine(String line, int index) {
        ItemMeta meta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>();

        if (meta.hasLore()) lore = new ArrayList<>(meta.getLore());
        lore.set(index, line);

        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return this;
    }

    /**
     * Sets the dye color on an item.
     *
     * @param color The color to put.
     */
    public ItemBuilder setDyeColor(DyeColor color) {
        itemStack.setDurability(color.getDyeData());
        return this;
    }

    /**
     * Sets the dye color of a wool item. Works only on wool.
     *
     * @param color The DyeColor to set the wool item to.
     */
    public ItemBuilder setWoolColor(DyeColor color) {
        if (!itemStack.getType().equals(Material.WOOL)) return this;
        itemStack.setDurability(color.getWoolData());
        return this;
    }

    /**
     * Sets the armor color of a leather armor piece. Works only on leather armor pieces.
     *
     * @param color The color to set it to.
     */
    public ItemBuilder setLeatherArmorColor(Color color) {
        LeatherArmorMeta im = (LeatherArmorMeta) itemStack.getItemMeta();
        im.setColor(color);
        itemStack.setItemMeta(im);
        return this;
    }

    /**
     * Retrieves the ItemStack from the ItemBuilder.
     *
     * @return The ItemStack modified by the ItemBuilder instance.
     */
    public ItemStack toItemStack() {
        return itemStack;
    }

    /**
     * Get a new instance of a LobbyItem
     *
     * @param slotIndex The given slot for the {@link LobbyItem}
     * @return The new instance of the {@link LobbyItem}
     */
    public LobbyItem toLobbyItem(int slotIndex) {
        return new LobbyItem(itemStack, slotIndex);
    }
}
