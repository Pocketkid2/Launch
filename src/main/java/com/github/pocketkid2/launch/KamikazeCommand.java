package com.github.pocketkid2.launch;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class KamikazeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player player) {
			if (args.length < 1) {
				player.sendMessage(ChatColor.RED + "You must specify a power value! (creeper = 3, TNT = 4, etc)");
				return false;
			}
			try {
				int power = Integer.parseInt(args[0]);
				player.getWorld().createExplosion(player.getLocation(), power);
				player.sendMessage(ChatColor.GREEN + "Created an explosion of power " + power + " at your location");
			} catch (NumberFormatException e) {
				player.sendMessage(ChatColor.RED + "Unknown power value " + ChatColor.GRAY + args[0]);
				return false;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You must be a player!");
		}
		return true;
	}

}
