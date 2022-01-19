package com.github.pocketkid2.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

public class LaunchTabCompleter implements TabCompleter {

	private LaunchPlugin plugin;

	public LaunchTabCompleter(LaunchPlugin p) {
		plugin = p;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length > 0) {
			List<String> types = plugin.getTypes().stream().map(Class::getSimpleName).collect(Collectors.toList());
			List<String> matches = new ArrayList<>();
			StringUtil.copyPartialMatches(args[0], types, matches);
			Collections.sort(matches);
			return matches;
		}
		return null;
	}

}
