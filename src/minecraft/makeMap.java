package minecraft;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import ij.ImagePlus;
import image.imageRead;

public class makeMap {
	Player player;
	static int countX = 10000;
	static int countZ = 10000;
	public makeMap(Player palyer){
		this.player = player;
	}
	void createMap(){
		  ImagePlus array[][] = imageRead.readImage();
		  for(int i = 0; i< array.length; i++ ) {
			  for(int j =0; j<array[0].length; j++) {
				  MapView view = Bukkit.createMap(player.getWorld());
				  view.setCenterX(countX);
				  view.setCenterZ(countZ);
				  countX += 129;
				  List<MapRenderer> a = view.getRenderers();
				  MapCanvas test = null;
				  test.drawImage(0, 0, array[i][j].getBufferedImage());
				  a.get(0).render(view, test, player);
				  for(MapRenderer renderer : view.getRenderers())
				        view.removeRenderer(renderer);
				  view.addRenderer(a.get(0));
			  }
		  }
		  
		  //ItemStack item = new ItemStack(Material.MAP, 1);
		 // item.setDurability((short) view.getId());//æ∆¿Ã≈∆æÚ±‚
	}
}
