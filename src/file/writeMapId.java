package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class writeMapId {
	ArrayList<Integer> array = new ArrayList<Integer>();;
	int size;
	public writeMapId(int size){
		this.size = size;
	}
	public void insert(int num) {
		array.add(num);
	}
	
	public void writeFile(String mapName) {
		  try {
			  if(mapName == null) {
				  mapName = array.get(0)+"";
			  }
			  String ori = mapName;
			  int chk = 0;
			  while(check.chkFile("./plugins/makeMap/map/"+mapName+".ump45"))
				  mapName = ori + chk++;
			FileOutputStream out = new FileOutputStream("./plugins/makeMap/map/"+mapName+".ump45");
			 for(int i = 0; i<array.size(); i++) {
				 out.write(array.get(i));
				 if(size == i)
					 out.write(0xFFFFFF);
			 }
			 out.close();
			 out = null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
