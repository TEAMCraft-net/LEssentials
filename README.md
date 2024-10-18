# **LEssentials made by Isa**

This Plugin is made for every server that wants the features of essentials but with some more features.

**NET Services currently down**

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
