package p;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import minecraft.makeMap;
import file.check;
import file.show;

public class getcommand implements CommandExecutor {
	  @Override
	    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	    {
		  Player player = (Player)sender;
		  if(player.isOp()) {
		  switch (args.length) {
		  	case 0:
		  		player.sendMessage("/map image");
		  		player.sendMessage("/map map");
		  		break;
		  		
		  		
		  	case 1:
		  		if(args[0].equals("image")) {
					  player.sendMessage("/map image list");
					  player.sendMessage("/map image create [fileName] [name]");
		  		}
		  		else {
					  player.sendMessage("/map map list");
					  player.sendMessage("/map map create [fileName]");
		  		}
		  	case 2:
		  		if(args[0].equals("image")) {
		  			if(args[1].equals("list"))
		  				player.sendMessage(show.fileList(Type.IMAGE_DIR));
		  			else {
						  player.sendMessage("/map image list");
						  player.sendMessage("/map image create [fileName] [name]");
		  			}
		  				
		  		}
		  		else if(args[0].equals("map")) {
		  			if(args[1].equals("list"))
		  				player.sendMessage(show.fileList(Type.MAP_DIR));
		  			else {
						  player.sendMessage("/map map list");
						  player.sendMessage("/map map create [fileName]");
		  			}
		  				
		  		}
		  		else {
					  player.sendMessage("/map image");
					  player.sendMessage("/map map");
		  		}
		  		break;
		  		
		  		
		  	case 3:
		  		if(args[0].equals("image")) {
		  			 if(args[1].equals("create")) {
		  				 String dir = "./plugins/makeMap/image/"+args[2];
						  if(check.chkFile(dir)) {
							  if(args.length >2)
								  makeMap.createMap(dir,player,args[3]);
							  else
								  makeMap.createMap(dir,player,null);
						  }				  
						  else
							  player.sendMessage("없는 이름입니다.");
		  			 }	
		  			 else
		  				 player.sendMessage("/map image create [fileName] [name]");
		  		}

		  		else if(args[0].equals("map")) {
		  			if(args[1].equals("create")) {}
		  			else
						  player.sendMessage("/map map create [fileName] [name]");
		  			
		  		}
		  		else {
					  player.sendMessage("/map image");
					  player.sendMessage("/map map");
		  		}
		  		break;
		  		
		  		
		  	default:
				  player.sendMessage("/map image");
				  player.sendMessage("/map map");
				  break;
		  		
		  		
		  }
		  }
		  
		  

			return false;
	     }
}
