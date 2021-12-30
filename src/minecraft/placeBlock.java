package minecraft;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

import p.Main;

public class placeBlock extends Main{
	
	public static void place(int x,int y, Material block,World world,Player player) {
		    Location loc = player.getLocation();
		    World w = loc.getWorld();
		    Block b = w.getBlockAt(loc);
		    b.setType(block);
			for(int i = 0; i< x; i++) {
				for(int j = 0; j<y; j++) {
					placeBlock.place(i,j,block,player.getWorld(),player);
				}
			}
		
	}

}
