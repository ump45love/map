package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class writeMapId {
	ArrayList<Integer> array;
	int size;
	public writeMapId(int size){
		this.size = size;
	}
	public void insert(int num) {
		array.add(num);
	}
	
	public void writeFile() {
		  try {
			FileOutputStream out = new FileOutputStream(array.get(0)+".ump45");
			 for(int i = 0; i<array.size(); i++) {
				 out.write(array.get(i));
				 if(size == i)
					 out.write(array.get(0xFFFFFF));
			 }
			  out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
