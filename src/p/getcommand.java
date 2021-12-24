package p;

import java.awt.image.BufferedImage;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import ij.ImagePlus;

public class getcommand implements CommandExecutor {
	  @Override
	    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	    {
		  Player player = (Player)sender;
		  placeBlock.place(0,0,0,Material.GLOWSTONE,player.getWorld(),player);
		  ItemStack item;
		  ItemStack i = new ItemStack(Material.MAP, 1);
		  MapView view = Bukkit.createMap(world);
		  List<MapRenderer> a = view.getRenderers();
		  MapCanvas test;
		  ImagePlus imgPlus = new ImagePlus("g.jpg");
		  BufferedImage img;
		  test.drawImage(0, 0, img);
		  a.get(0).render(view, null, player);
		  for(MapRenderer renderer : view.getRenderers())
		        view.removeRenderer(renderer);
		  view.addRenderer(myCustomRenderer);
		  i.setDurability(view.getId());
			return false;
	     }
}
