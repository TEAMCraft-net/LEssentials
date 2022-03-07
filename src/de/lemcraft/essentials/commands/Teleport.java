package de.lemcraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lemcraft.essentials.Core;

public class Teleport implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission(Core.getPerm("tp.use"))) {
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						player.teleport(target);
						player.sendMessage(Core.getPrefix() + "Du hast dich zu §e"+ player.getName() + " §7teleportiert");
						if(!Core.getInVanish().contains(player)) {
							target.sendMessage(Core.getPrefix() + "§a"+player.getName() + " §7hat sich zu dir teleportiert");
						}
					} else {
						player.sendMessage(Core.getMSG("targetIsNotOnline"));
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
