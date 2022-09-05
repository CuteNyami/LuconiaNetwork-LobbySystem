package net.luconia.lobbysystem.cape;

import net.luconia.lobbysystem.LobbySystem;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class CapeManager implements ICapeHandler {
    @Override
    public void setCape(Player player, ItemStack banner) {
        removeCape(player);

        ArmorStand armorStand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);

        if (armorStand != null) armorStand.getEquipment().setHelmet(banner);
        if (armorStand == null) return;
        armorStand.setVisible(false);
        armorStand.setMarker(true);
        armorStand.setHeadPose(new EulerAngle(-3, 0, 0));
        armorStand.setSmall(true);
        armorStand.addScoreboardTag("luconia.capes");
        armorStand.setGravity(false);

        getCapes().put(player.getName(), armorStand);
    }

    @Override
    public boolean removeCape(Player player) {
        ArmorStand armorStand = getCapes().remove(player.getName());

        if(armorStand == null) return false;
        armorStand.remove();

        return true;
    }

    @Override
    public boolean haveCape(Player player) {
        return getCapes().get(player.getName()) != null;
    }

    @Override
    public ItemStack getCape(Player player) {
        ArmorStand armorStand = getCapes().get(player.getName());
        return armorStand == null ? null : armorStand.getEquipment().getHelmet();
    }

    @Override
    public Map<String, ArmorStand> getCapes() {
        return LobbySystem.getInstance().getCapes();
    }
}
