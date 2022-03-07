package de.lemcraft.essentials;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import de.lemcraft.essentials.commands.Fly;
import de.lemcraft.essentials.commands.Gamemode;
import de.lemcraft.essentials.commands.Teleport;
import de.lemcraft.essentials.commands.Vanish;
import de.lemcraft.essentials.file.FileWriter;
import de.lemcraft.essentials.listeners.JoinListener;
import de.lemcraft.essentials.listeners.QuitListener;
import de.lemcraft.essentials.main.Main;

public class Core {

	public static FileWriter getConfig() {
		return new FileWriter(Main.getInstance().getDataFolder().getPath(), "config.yml");
	}

	public static void setupCore() {
		setupDefaultConfig();
	}
	
	private static ArrayList<Player> inVanish = new ArrayList<>();
	
	public static ArrayList<Player> getInVanish() {
		return inVanish;
	}

	private static void setupDefaultConfig() {
		FileWriter config = getConfig();
		Main main = Main.getInstance();
		config.setDefaultValue("prefix", "&6LEssentials &8> &7");
		config.setDefaultValue("noPerm", "Du hast dafür keine Rechte");
		config.setDefaultValue("noPlayer", "Dafür musst du ein Spieler sein");
		config.setDefaultValue("pleaseUse", "Bitte benutze: &c/");
		config.setDefaultValue("targetIsNotOnline", "Der Spieler ist nicht online");
		config.setDefaultValue("allowJoinMessage", true);
		config.setDefaultValue("allowLeaveMessage", true);
		config.setDefaultValue("customJoinMessage", "&7[&a+&7] &7%player.name%");
		config.setDefaultValue("customLeaveMessage", "&7[&c+&7] &7%player.name%");
		
		setupCommands("gamemode", new Gamemode(), main);
		setupPerms("gamemode.use", config);
		setupPerms("gamemode.others", config);
		setupPerms("gamemode.survival", config);
		setupPerms("gamemode.creative", config);
		setupPerms("gamemode.adventure", config);
		setupPerms("gamemode.spectator", config);
		setupCommands("fly", new Fly(), main);
		setupPerms("fly.use", config);
		setupPerms("fly.others", config);
		
		setupCommands("vanish", new Vanish(), main);
		setupPerms("vanish.see", config);
		setupPerms("vanish.use", config);
		
		setupCommands("tp", new Teleport(), main);
		setupPerms("tp.use", config);
		
		config.save();
		
		setupListener(new JoinListener(), main);
		setupListener(new QuitListener(), main);
	}
	
	private static void setupCommands(String command,CommandExecutor commandE, Main main) {
		main.getCommand(command).setExecutor(commandE);
		setupPerms(command, getConfig());
	}
	
	private static void setupListener(Listener listener, Plugin plugin) {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(listener, plugin);
	}
	
	private static void setupPerms(String command, FileWriter config) {
		config.setDefaultValue("permissions."+command, "lessentials."+command);
		config.save();
	}

	public static String convertString(String label) {
		return label.replaceAll("&", "§");
	}

	public static String convertPlayerString(String label, Player player) {
		return label.replaceAll("%player.name%", player.getName());
	}

	public static String getPrefix() {
		return convertString(getConfig().getString("prefix"));
	}

	public static String getPerm(String command) {
		return getConfig().getString("permission." + command);
	}

	public static String getMSG(String label) {
		return getConfig().getString(label);
	}

}
