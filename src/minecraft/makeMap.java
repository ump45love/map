package minecraft;

import java.awt.image.BufferedImage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import file.writeMap;
import ij.ImagePlus;
import image.imageRead;

public class makeMap {
	public static void createMap(String name, Player player,String mapName){
		  ImagePlus array[][] = null;
		  array = imageRead.readImage(name);
		  ItemStack itemArray[][] = new ItemStack[array.length][array[0].length];
		  writeMap writefile = new writeMap(array.length);
		  for(int i = 0; i< array.length; i++ ) {
			  for(int j =0; j<array[0].length; j++) {
				  MapView view = Bukkit.createMap(player.getWorld());
				  for(MapRenderer r : view.getRenderers()) {
					  view.removeRenderer(r);
				  }
				  BufferedImage save = array[i][j].getBufferedImage();
				  view.addRenderer(new MapRenderer() {
				  public void render(MapView view, MapCanvas canvas, Player player) {
				  canvas.drawImage(0, 0, save);
				  }
				  });
				  writefile.insert(view.getId());
				  ItemStack stack = new ItemStack(Material.FILLED_MAP);
				  MapMeta meta = (MapMeta) stack.getItemMeta();
				  meta.setMapId(view.getId());
				  stack.setItemMeta(meta);
				  itemArray[i][j] = stack;
				  //player.getInventory().addItem(stack);
			  }
		  }
		 placeBlock.place(Material.STONE,player.getWorld(),player,itemArray);
		  writefile.write(mapName, array);
		  array = null;
		  
		  //ItemStack item = new ItemStack(Material.MAP, 1);
		 // item.setDurability((short) view.getId());//¾ÆÀÌÅÆ¾ò±â
	}
}
