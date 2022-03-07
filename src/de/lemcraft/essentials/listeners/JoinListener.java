package de.lemcraft.essentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.lemcraft.essentials.Core;

public class JoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.setJoinMessage("");
		if (Core.getConfig().getBoolean("allowJoinMessage")) {
			Bukkit.broadcastMessage(Core.convertPlayerString(Core.getMSG("customJoinMessage"), event.getPlayer()));
			for (Player all : Core.getInVanish()) {
				if (!all.hasPermission(Core.getPerm("vanish.see"))) {
					all.hidePlayer(all);
				}
			}
		}
	}

}
