# **LEssentials made by Isa**

This Plugin is made for every server that wants the features of essentials but with some more features.
This Plugin is a compact version of essentials, event system and job system.

This Plugin also supports PlotSquared meaning the PlayerMenu is specially made for PlotSquared and it supports
LuckPerms meaning it can change a users parent using the setgroup command.

## **Changelog**

## 04.02.2024 - LEssentials v7.5
```diff
- EnderChest Permission Bug
+ R command
+ Vanish indicator
- EnderChest Viewer Bug
```

## 21.01.2024 - LEssentials v7.0
```diff
+ Admin log
+ Admin menu
+ Paid for Farming (Ores/Logs)
+ Easter Eggs
+ Sallary reworked
- Discord Integration
+ Sell Reworked
+ Buy Reworked
+ Pay Reworked
- Bank
+ Money Reworked
+ Balance/bal
+ Permissions Reworked
+ Broadcast Reworked
+ Pay Reworked
+ Rename Reworked
+ Sign Reworked
+ Give Reworked
+ Kick Reworked
+ Tphere Reworked
+ Feed Reworked
+ Clearchat Reworked
+ Heal Reworked
+ Tpall Reworked
+ Sudo Reworked
+ Msg Reworked
+ Thunder Reworked
+ Storm Reworked
+ Sun Reworked
+ Night  Reworked
+ Day Reworked
+ EnderChest Reworked
+ SpawnMob Reworked
- Vanish Bugs
+ Vanish Reworked
+ GameMode Reworked
+ Tp Reworked
+ Fly Reworked
+ GameMode Reworked
- Reload command
- AI Integration (Temporary)
+ New Economy
+ Improved Performance
+ Reworked Commands
+ Reworked Configs
- Removed Multiple Translation
```

### 01.01.2024 - LEssentials v6.5
```diff
+ New fly method (/fly <speed> | /fly <target>)
+ New Wiki page
+ Vault Support (Check Wiki)
+ price command
+ buy command
- Warp config bug
- Home config bug
+ Home TabCompleter
+ Warp TabCompleter
+ Economy updated
+ AI updated
```

### 27.10.2023 - LEssentials v6

```diff
- Easter eggs (vinSTAR, ENTE)
+ Rickroll toggable in config
+ AI System is now working (ChatGPT Api key required)
+ Language French
- Public AFK
+ Language Romanian
+ Language Spanish
+ Gift command fixed
- Job system (Temporary)
+ Language Russian
+ Custom Enchantments fix
+ Changelanguage bugfix
- 1.8+ - 1.12 Sell Item list
+ New Commands
+ Multiple Version support
+ Un-/Jail system
- Local Economy system (Only MySQL is now available)
+ MOTD Customazible in config
+ Better discord log
+ Sell command fixed
- Status command for users (Only for users in Admin Mode and the required permissions)
+ Better EventManager
+ SetSpawn command
- Already in Admin bug fix
+ Spawn command
+ Teleport to Spawn on join (Toggable)
- Online Services changed
- Warp system bugs
+ Auto database tables creation
- Provided sql file
+ Api improved
- Jail Bug (reload plugin after /setjail)
```

## **API**
This is only a little preview of our API the entire usage is in the Wiki.

### Setup

```java
import org.bukkit.plugin.java.JavaPlugin;
import de.lemcraft.essentials.api.API;

public class Main extends JavaPlugin {

	private static Main instance;
  private static API api = null;

  public static API getApi() {
    return api;
  }

  public static Main getInstance() {
		return instance;
	}

  public void onEnable() {
		instance = this;
    api = new API();
  }

}
```

### Usage

```java
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestApi implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (Main.getApi().getPlayersAPI().isPlayerNew == false) {
				Main.getApi().getPlayersAPI().changeIsNewState(player, Main.getInstance(), true);
			} else {
				player.sendMessage(Core.getLanguageText("noPerm", true, player));
			}
		} else {
			sender.sendMessage(Core.getLanguageText("noPlayer", true, sender));
		}
		return false;
	}

}
```
