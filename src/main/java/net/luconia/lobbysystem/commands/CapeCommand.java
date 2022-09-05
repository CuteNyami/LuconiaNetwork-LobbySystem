package net.luconia.lobbysystem.commands;

import net.luconia.lobbysystem.LobbySystem;
import net.luconia.lobbysystem.cape.ICapeHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CapeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            ICapeHandler capeHandler = LobbySystem.getInstance().getCapeManager();

            if (args.length == 0) {
                sender.sendMessage("/cape <set, remove>");
                return true;
            }
            Player p = (Player) sender;
            switch (args[0]) {

                case "set":
                    if (!p.hasPermission("capes.set")) {
                        sender.sendMessage("no permissions");
                        break;
                    }

                    ItemStack is = p.getInventory().getItemInMainHand();
                    if (is == null || !is.getType().toString().contains("BANNER")) {
                        p.sendMessage("error");
                        break;
                    }

                    capeHandler.setCape(p, is);

                    ArmorStand as = capeHandler.getCapes().get(sender.getName());
                    if (((Player) sender).isSneaking()) {
                        as.setHeadPose(new EulerAngle(-2.5, 0, 0));
                        as.teleport(((Player) sender).getLocation().clone().add(0, 0.8, 0));
                    } else {
                        double yaw = Math.toRadians(((Player) sender).getLocation().getYaw());
                        double sin = Math.sin(yaw);
                        double cos = Math.cos(yaw);

                        as.teleport(((Player) sender).getLocation().clone().add(sin / 4, 1, -cos / 4));
                        as.setHeadPose(new EulerAngle(-3, 0, 0));
                    }

                    p.sendMessage("ok");
                    break;

                case "remove":
                    if (!p.hasPermission("capes.remove")) {
                        sender.sendMessage("no permissions");
                        break;
                    }

                    if (!capeHandler.removeCape(p)) p.sendMessage("error");
                    else p.sendMessage("ok");
                    break;

                default:
                    p.sendMessage("/cape <set, remove>");
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(command.getName().equalsIgnoreCase("cape")) {
            if (args.length == 1) {
                return Stream.of("set", "remove").filter(s -> s.startsWith(args[0].toLowerCase())).collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }
}
