package p;


import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

public class plaveBlock extends Main{
	
	void placeBlock(int x,int y,int z, BlockData type,World world,Player player) {
		    Location loc = player.getLocation();
		    World w = loc.getWorld();
		    Block b = w.getBlockAt(loc);
		    b.setBlockData(type);
		
	}

}
