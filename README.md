# **LEssentials made by Isa**

This Plugin is made for every server that wants the features of essentials but with some more features.
This Plugin is a compact version of essentials, event system and job system.

This Plugin also supports PlotSquared meaning the PlayerMenu is specially made for PlotSquared and it supports
LuckPerms meaning it can change a users parent using the setgroup command.

## **Changelog**

### 01.01.2024 - LEssentials v6.5
```diff
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
