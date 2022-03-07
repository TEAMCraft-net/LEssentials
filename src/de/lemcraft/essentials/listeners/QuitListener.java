package de.lemcraft.essentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.lemcraft.essentials.Core;

public class QuitListener implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage("");
		if(Core.getConfig().getBoolean("allowLeaveMessage")) {
			Bukkit.broadcastMessage(Core.convertPlayerString(Core.getMSG("customLeaveMessage"), event.getPlayer()));
		}
	}
	
}
