package com.github.pocketkid2.launch;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

import net.md_5.bungee.api.ChatColor;

public class LaunchCommand implements CommandExecutor {

	private LaunchPlugin plugin;

	public LaunchCommand(LaunchPlugin p) {
		plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player player) {
			if (args.length < 1) {
				player.sendMessage(ChatColor.RED + "You must specify a type! (Press TAB to see a list)");
				return false;
			}
			for (Class<? extends Projectile> c : plugin.getTypes()) {
				if (c.getSimpleName().equalsIgnoreCase(args[0])) {
					player.launchProjectile(c);
					return true;
				}
			}
			player.sendMessage(ChatColor.RED + "Could not find projectile type '" + args[0] + "'");
			return false;
		}
		sender.sendMessage(ChatColor.RED + "You must be a player!");
		return true;
	}

}
