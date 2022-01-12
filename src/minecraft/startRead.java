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

import file.show;
import file.readMap;
import p.Type;

public class startRead {
	
	public static void read(){
		readMap readStart = new readMap(null);
		String fileNameArray[] = show.fileListArray(Type.MAP_DIR);
		MapView view = null;
		int getWidth = 0;
		int getHeight = 0;
		int[] getId = null;
		for(int i = 0; i<fileNameArray.length; i++) {
			readStart.setMapName(fileNameArray[i]);
			readStart.read();
			getWidth = readStart.getMapSize()[0];
			getHeight = readStart.getMapSize()[1];
			getId = readStart.getMapId();
			int num = 0;
			for(int j = 0; j<getWidth; j++) {
				for(int k = 0; k < getHeight; k++) {
					view = Bukkit.getMap(getId[num++]);
					  for(MapRenderer r : view.getRenderers()) {
						  view.removeRenderer(r);
					  }
					  BufferedImage save =readStart.getImage(j, k).getBufferedImage();
					  view.addRenderer(new MapRenderer() {
						  public void render(MapView view, MapCanvas canvas, Player player) {
						  canvas.drawImage(0, 0, save);
						  }
						  });
				}
			}
		}
	}

}
