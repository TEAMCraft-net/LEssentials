package de.lemcraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lemcraft.essentials.Core;

public class Vanish implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission(Core.getPerm("vanish.use"))) {
				if(args.length == 0) {
					if(Core.getInVanish().contains(player)) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							if(!all.hasPermission(Core.getPerm("vanish.see"))) {
								all.showPlayer(player);
							} else {
								if(all.getName() == player.getName()) {
									all.sendMessage(Core.getPrefix() + "Du bist jetzt nicht mehr im Vanish");
								} else {
									all.sendMessage(Core.getPrefix() + "Der Spieler §a" + player.getName() + " §7ist jetzt nicht mehr im Vanish");
								}
							}
						}
					} else {
						for(Player all : Bukkit.getOnlinePlayers()) {
							if(!all.hasPermission(Core.getPerm("vanish.see"))) {
								all.hidePlayer(player);
							} else {
								if(all.getName() == player.getName()) {
									all.sendMessage(Core.getPrefix() + "Du bist jetzt im Vanish");
								} else {
									all.sendMessage(Core.getPrefix() + "Der Spieler §a" + player.getName() + " §7ist jetzt im Vanish");
								}
							}
						}
					}
				} else {
					player.sendMessage(Core.getMSG("pleaseUse")+label);
				}
			} else {
				player.sendMessage(Core.getMSG("noPerm"));
			}
		} else {
			sender.sendMessage(Core.getMSG("noPlayer"));
		}
		return false;
	}

}
