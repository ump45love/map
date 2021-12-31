package file;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

public class show {

	public static String fileList() {
		File Folder = new File("./plugins/makeMap/image");
		String[] combine = Folder.list();
		String content = "";
		for(int i =0; i<combine.length; i++)
			content = content +" || " + combine[i];
		return content;
	}
	void folderList() {
		
	}
}
