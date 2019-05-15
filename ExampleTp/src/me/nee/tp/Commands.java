package me.nee.tp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    private Main main;

    public Commands(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("Teleport")) {
            if (args.length < 1) {
                p.sendMessage(format("&f&l[&4&l!&f&l] &7Please specify a player!"));
                return true;
            }
            Player teleportTo = Bukkit.getPlayer(args[0]);
            if (teleportTo == null) {
                p.sendMessage(format("&f&l[&4&l!&f&l] &b" + args[0] + " &7Is a invalid or offline player!"));
                return true;
            }
            if (teleportTo.getName().equalsIgnoreCase(p.getName())){
                p.sendMessage(format("&f&l[&4&l!&f&l] &7You cannot telport to yourself!"));
                return true;

            }
            p.teleport(teleportTo);
            p.sendMessage(format("&f&l[&a&l+&f&l] &7Teleported to: &b" + teleportTo.getName()));
        }
        return true;
    }

    private String format(String format) {
        return ChatColor.translateAlternateColorCodes('&', format);
    }

}
