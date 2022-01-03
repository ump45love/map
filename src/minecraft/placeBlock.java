package minecraft;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;

import p.Main;

public class placeBlock extends Main{
	
	@SuppressWarnings("deprecation")
	public static void place(Material block,World world,Player player,ItemStack id) {
		
		    Location loc = player.getLocation();
		    World w = loc.getWorld();
		    Block b = null;
		    double x = loc.getX();
		    double y = loc.getY();
			for(int i = 0; i< 10; i++) {
				for(int j = 0; j<10; j++) {
					 b = w.getBlockAt(loc);
					 b.setType(block);
					 ItemFrame f = (ItemFrame) world.spawn(new Location(world,loc.getX(),loc.getY(),loc.getZ()+1), ItemFrame.class);
			         f.setItem(id);
					 b.setType(block);
					 loc.setX(x+j);
					 
					 
				}
				loc.setY(y+i);
			}
		
	}

}
