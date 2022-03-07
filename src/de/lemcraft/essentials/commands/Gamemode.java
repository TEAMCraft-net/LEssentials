package de.lemcraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lemcraft.essentials.Core;

public class Gamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
				if(args.length == 1) {
					if(player.hasPermission(Core.getPerm("gamemode.use"))) {
						if(player.hasPermission(Core.getPerm("gamemode.self"))) {
							if(args[0].equalsIgnoreCase("1")) {
								if(player.hasPermission(Core.getPerm("gamemode.creative"))) {
									player.setGameMode(GameMode.CREATIVE);
									player.sendMessage(Core.getPrefix() + "Du bist jetzt im §e"+player.getGameMode().toString().toLowerCase());
								}
							} else if(args[0].equalsIgnoreCase("2")) {
								if(player.hasPermission(Core.getPerm("gamemode.adventure"))) {
									player.setGameMode(GameMode.ADVENTURE);
									player.sendMessage(Core.getPrefix() + "Du bist jetzt im §e"+player.getGameMode().toString().toLowerCase());
								}
							} else if(args[0].equalsIgnoreCase("3")) {
								if(player.hasPermission(Core.getPerm("gamemode.spectator"))) {
									player.setGameMode(GameMode.SPECTATOR);
									player.sendMessage(Core.getPrefix() + "Du bist jetzt im §e"+player.getGameMode().toString().toLowerCase());
								}
							} else if(args[0].equalsIgnoreCase("0")) {
								if(player.hasPermission(Core.getPerm("gamemode.survival"))) {
									player.setGameMode(GameMode.SURVIVAL);
									player.sendMessage(Core.getPrefix() + "Du bist jetzt im §e"+player.getGameMode().toString().toLowerCase());
								} else {
									player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("noPerm")));
								}
							} else {
								player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("pleaseUse") + label +" <0,1,2,3>"));
							}
						} else {
							player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("pleaseUse") + label));
						}
					} else {
						player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("pleaseUse") + label));
					}
				} else if(args.length == 2) {
					if(player.hasPermission(Core.getPerm("gamemode.use"))) {
						if(player.hasPermission(Core.getPerm("gamemode.others"))) {
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null) {
								if(args[1].equalsIgnoreCase("1")) {
									if(player.hasPermission(Core.getPerm("gamemode.creative"))) {
										target.setGameMode(GameMode.CREATIVE);
										target.sendMessage(Core.getPrefix() + "Du bist jetzt im §e"+target.getGameMode().toString().toLowerCase() + "§7 durch §a" + player.getName());
										player.sendMessage(Core.getPrefix() + "Du hast §a" + target.getName() + " §7in den §e"+ target.getGameMode().toString().toLowerCase() + " §7gesetzt");
									} else {
										player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("noPerm")));
									}
								} else if(args[1].equalsIgnoreCase("2")) {
									if(player.hasPermission(Core.getPerm("gamemode.adventure"))) {
										target.setGameMode(GameMode.ADVENTURE);
										target.sendMessage(Core.getPrefix() + "Du bist jetzt im §e"+target.getGameMode().toString().toLowerCase() + "§7 durch §a" + player.getName());
										player.sendMessage(Core.getPrefix() + "Du hast §a" + target.getName() + " §7in den §e"+ target.getGameMode().toString().toLowerCase() + " §7gesetzt");
									} else {
										player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("noPerm")));
									}
								} else if(args[1].equalsIgnoreCase("3")) {
									if(player.hasPermission(Core.getPerm("gamemode.spectator"))) {
										target.setGameMode(GameMode.SPECTATOR);
										target.sendMessage(Core.getPrefix() + "Du bist jetzt im §e"+target.getGameMode().toString().toLowerCase() + "§7 durch §a" + player.getName());
										player.sendMessage(Core.getPrefix() + "Du hast §a" + target.getName() + " §7in den §e"+ target.getGameMode().toString().toLowerCase() + " §7gesetzt");
									} else {
										player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("noPerm")));
									}
								} else if(args[1].equalsIgnoreCase("0")) {
									if(player.hasPermission(Core.getPerm("gamemode.survival"))) {
										target.setGameMode(GameMode.SURVIVAL);
										target.sendMessage(Core.getPrefix() + "Du bist jetzt im §e"+target.getGameMode().toString().toLowerCase() + "§7 durch §a" + player.getName());
										player.sendMessage(Core.getPrefix() + "Du hast §a" + target.getName() + " §7in den §e"+ target.getGameMode().toString().toLowerCase() + " §7gesetzt");
									} else {
										player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("noPerm")));
									}
								} else {
									player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("pleaseUse") + label + " <0,1,2,3>"));
								}
							} else {
								player.sendMessage(Core.getMSG("targetIsNotOnline"));
							}
						} else {
							player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("noPerm")));
						}
					} else {
						player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("noPerm")));
					}
				} else {
					player.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("pleaseUse") + label));
				}
		} else {
			sender.sendMessage(Core.getPrefix() + Core.convertString(Core.getMSG("noPlayer")));
		}
		return false;
	}

}
