package p;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable(){
		String path = "������\\mapData";
		File Folder = new File(path);
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //���� �����մϴ�.
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}     
		}
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "start");
		getCommand("place").setExecutor(new getcommand());
	}
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
}