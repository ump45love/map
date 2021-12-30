package file;

import java.io.File;

public class check {
	public static boolean chkFile(String name) {
		File f = new File(name);
		if(f.exists()) {
		     return true;
		} else {
			return false;            
		}
	}
	
	public static boolean chkFolder(String name) {
		File f = new File(name);
		if(f.exists()) {
		     return true;
		} else {
			return false;            
		}
	}
}
