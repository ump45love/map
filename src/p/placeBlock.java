package p;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

public class placeBlock extends Main{
	
	public static void place(int x,int y,int z, Material block,World world,Player player) {
		    Location loc = player.getLocation();
		    World w = loc.getWorld();
		    Block b = w.getBlockAt(loc);
		    b.setType(block);
		
	}

}
