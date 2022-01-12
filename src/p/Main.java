package p;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import minecraft.startRead;

public class Main extends JavaPlugin{
	@Override
	public void onEnable(){
		File cfile = new File(getDataFolder(),"config.yml");
		if(cfile.length() == 0) {
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		File Folder = new File(getDataFolder(),"image");
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}     
		}
		Folder = new File(getDataFolder(),"map");
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}     
		}
		else {
			startRead.read();
		}
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "start");
		getCommand("map").setExecutor(new getcommand());
	}
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
}