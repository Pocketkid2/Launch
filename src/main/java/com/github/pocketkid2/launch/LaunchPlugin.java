package com.github.pocketkid2.launch;

import java.util.Arrays;
import java.util.Set;

import org.bukkit.entity.Projectile;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class LaunchPlugin extends JavaPlugin {

	private Set<Class<? extends Projectile>> types;

	@Override
	public void onEnable() {
		saveDefaultConfig();

		getCommand("launch").setExecutor(new LaunchCommand(this));
		getCommand("launch").setTabCompleter(new LaunchTabCompleter(this));

		Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(Arrays.asList(ClasspathHelper.forClass(Projectile.class))));
		types = reflections.getSubTypesOf(Projectile.class);

		getLogger().info("Enabled!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabled!");
	}

	public Set<Class<? extends Projectile>> getTypes() {
		return types;
	}
}
