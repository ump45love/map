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
		  				player.sendMessage(show.fileList());
		  			else {
						  player.sendMessage("/map image list");
						  player.sendMessage("/map image create [fileName] [name]");
		  			}
		  				
		  		}
		  		else if(args[0].equals("map")) {
		  			if(args[1].equals("list")) {}
		  			else {
						  player.sendMessage("/map map list");
						  player.sendMessage("/map map create [fileName]");
		  			}
		  				
		  		}
		  		else {
					  player.sendMessage("/map image");
					  player.sendMessage("/map map");
		  		}
		  	case 3:
		  		
		  			
		  }
		  if(player.isOp()) {
			  if(args.length >0) {
				  if(args[0].equals("image")) {
					  if(args.length >1) {
						  if(args[1].equals("list")) {
								  player.sendMessage(show.fileList());
						  }
						  else if(args[1].equals("create")) {
							  if(args.length >2) {
							  String dir = "./plugins/makeMap/image/"+args[2];
							  if(check.chkFile(dir)) {
								  if(args.length >2)
									  makeMap.createMap(dir,player,args[3]);
								  else
									  makeMap.createMap(dir,player,null);
							  }
							  }					  
							  else
								  player.sendMessage("없는 이름입니다.");
						  }
						  else {
							  player.sendMessage("/map image list");
							  player.sendMessage("/map image create [fileName] [name]");
						  }
					  }
					  else {
						  player.sendMessage("/map image list");
						  player.sendMessage("/map image create");
					  }
					  }
				  else if(args[0].equals("map")) {
					  if(args.length >1) {
						  if(args[1].equals("list")) {}
						  else if(args[1].equals("create")) {}
					      else {
							  player.sendMessage("/map map list");
							  player.sendMessage("/map map create [fileName] [name]");
					      }
					  }
				      else {
						  player.sendMessage("/map map list");
						  player.sendMessage("/map map create [fileName] [name]");
				      }
				  }
				  else {
					  player.sendMessage("/map image");
					  player.sendMessage("/map map");
				  }
				  }
			  else {
				  player.sendMessage("/map image");
				  player.sendMessage("/map map");
			  }
		  }

			return false;
	     }
}
