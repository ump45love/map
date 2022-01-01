package minecraft;

import java.awt.image.BufferedImage;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import file.writeMapId;
import ij.ImagePlus;
import ij.io.FileSaver;
import image.imageRead;

public class makeMap {
	static int countX = 10000;
	static int countZ = 10000;
	public static void createMap(String name, Player player,String mapName){
		  player.sendMessage("asd");
		  ImagePlus array[][];
		  array = imageRead.readImage(name);
		  player.sendMessage("asdasddas");
		  writeMapId writefile = new writeMapId(array.length);
		  for(int i = 0; i< array.length; i++ ) {
			  for(int j =0; j<array[0].length; j++) {
				  MapView view = Bukkit.createMap(player.getWorld());
				  view.setCenterX(countX);
				  view.setCenterZ(countZ);
				  countX += 128;
				  System.out.printf("%d\n",array[i][j].getID());
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
				  player.getInventory().addItem(stack);
				  player.sendMessage(view.getId()+"");
			  }
		  }
		  writefile.writeFile(mapName);
		  
		  //ItemStack item = new ItemStack(Material.MAP, 1);
		 // item.setDurability((short) view.getId());//¾ÆÀÌÅÆ¾ò±â
	}
}
