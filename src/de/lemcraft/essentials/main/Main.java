package de.lemcraft.essentials.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.lemcraft.essentials.Core;

public class Main extends JavaPlugin {

	private static Main instance;
	
	public void onEnable() {
		instance = this;
		System.out.println("Essentials enabled");
		Core.setupCore();
	}
	
	public void onDisable() {
		System.out.println("Essentials disabled");
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
