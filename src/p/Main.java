package p;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "start");
		getCommand("place").setExecutor(new getcommand());
	}
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
}