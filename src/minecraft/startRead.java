package minecraft;

import java.awt.image.BufferedImage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class startRead {
	
	void read(){
		  MapView view = Bukkit.getMap(0);
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
