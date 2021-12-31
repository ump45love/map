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
			  if(args.length >0) {
				  if(args[0].equals("image")) {
					  if(args.length >1) {
						  if(args[1].equals("list")) {
								  player.sendMessage(show.fileList());
						  }
						  else if(args[1].equals("create")) {
							  String dir = "./plugins/makeMap/image/"+args[2];
							  if(check.chkFile(dir))
								  makeMap.createMap(dir,player);
							  else
								  player.sendMessage("없는 이름입니다.");
						  }
						  else {
							  player.sendMessage("/map image list");
							  player.sendMessage("/map image create");
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
							  player.sendMessage("/map map create");
					      }
					  }
				      else {
						  player.sendMessage("/map map list");
						  player.sendMessage("/map map create");
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
		  
			  
			  /*
			  if(args[0].equals("image")) {
				  if(args[1].equals("list")) {}
				  else if(args[1].equals("create")) {
					  if(check.chkFile("새폴더/image/"+args[2]))
						  makeMap.createMap(args[2]);
				  }
				  else {
					  player.sendMessage("/map image list");
					  player.sendMessage("/map image create");
				  }
			  }
			  else if(args[0].equals("map")) {
				  if(args[1].equals("list")) {}
				  else if(args[1].equals("create")) {}
			      else {
					  player.sendMessage("/map map list");
					  player.sendMessage("/map map create");
			      }
			  }
			  else {
				  player.sendMessage("/map image");
				  player.sendMessage("/map map");
			  }
			  */
		  
		  
		  
		  /*
		  Player player = (Player)sender;
		  
		  ItemStack item;
		  ItemStack i = new ItemStack(Material.MAP, 1);
		  ItemStack q = new ItemStack(Material.ITEM_FRAME, 1);
		  ItemFrame w = null;w.setItem(q);
		  MapView view = Bukkit.createMap(player.getWorld());
		  view.setCenterX(100000);
		  view.setCenterZ(100000);
		  List<MapRenderer> a = view.getRenderers();
		  MapCanvas test = null;
		  ImagePlus imgPlus = new ImagePlus("g.jpg");
		  test.drawImage(0, 0, imgPlus.getBufferedImage());
		  a.get(0).render(view, test, player);
		  for(MapRenderer renderer : view.getRenderers())
		        view.removeRenderer(renderer);
		  view.addRenderer(a.get(0));
		  view.getId();
		  i.setDurability((short) view.getId());
		  w.setItem(i);
		  w.setRotation(player.getLocation().getPitch(),player.getLocation().getYaw());
		  //placeBlock.place(0,0,0,w,player.getWorld(),player);
		   
		   */
			return false;
	     }
}
