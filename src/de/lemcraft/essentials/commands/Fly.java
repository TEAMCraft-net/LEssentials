package de.lemcraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lemcraft.essentials.Core;

public class Fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission(Core.getPerm("fly.use"))) {
				if(args.length == 0) {
					if(player.getAllowFlight()) {
						player.setAllowFlight(false);
						player.setFlying(false);
						player.sendMessage(Core.getPrefix() + "Du kannst jetzt nicht mehr §eFliegen");
					} else {
						player.setAllowFlight(true);
						player.setFlying(true);
						player.sendMessage(Core.getPrefix() + "Du kannst jetzt §eFliegen");
					}
				} else if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						if(player.hasPermission(Core.getPerm("fly.others"))) {
							
						} else {
							player.sendMessage(Core.getMSG("noPerm"));
						}
					} else {
						player.sendMessage(Core.getMSG("targetIsNotOnline"));
					}
				} else {
					player.sendMessage(Core.getMSG("pleaseUse") + label);
					if(player.hasPermission(Core.getPerm("fly.others")))
						player.sendMessage(Core.getMSG("pleaseUse") + label + " <name>");
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
