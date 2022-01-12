package file;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import ij.ImagePlus;

public class writeMap {
	ArrayList<Integer> array = new ArrayList<Integer>();
	int size;
	public writeMap(int size){
		this.size = size;
	}
	public void insert(int num) {
		array.add(num);
	}
	
	void writeImage(ImagePlus image[][],DataOutputStream writer) throws IOException {
		int[] save = new int[3];
		byte[] r = new byte[128];
		byte[] g = new byte[128];
		byte[] b = new byte[128];
		 for(int i = 0; i<image.length; i++) {
			 for(int j = 0; j<image[0].length; j++) {
				 for(int k = 0; k<128; k++) {
					 for(int l = 0; l<128; l++) {
					 save = image[i][j].getPixel(k, l);
					 r[l] = (byte)save[0];
					 g[l]= (byte)save[1];
					 b[l] = (byte)save[2];
					 }
					 writer.write(r,0,128);
					 writer.write(g,0,128);
					 writer.write(b,0,128);
				 }
			 }
		 }
		
		
	}
	void writeFile(DataOutputStream writer) throws IOException {
		 for(int i = 1; i<=array.size(); i++) {
			 writer.writeInt(array.get(i-1));
			 if(i%size == 0)
				 writer.writeByte(-1);
		 }
		 writer.writeByte(-2);

	}
	
	void writeSize(DataOutputStream writer) throws IOException {
		 writer.writeByte(array.size()/size);
		 writer.writeByte(size);
	}

	
	public void write(String mapName,ImagePlus image[][]) {
		  try {
			  if(mapName == null) {
				  mapName = array.get(0)+"";
			  }
			  String ori = mapName;
			  int chk = 0;
			  while(check.chkFile("./plugins/makeMap/map/"+mapName+".ump45"))
				  mapName = ori + chk++;
			  DataOutputStream writer = new DataOutputStream(new FileOutputStream("./plugins/makeMap/map/"+mapName+".ump45"));
			  writeSize(writer);
			  writeFile(writer);
			  writeImage(image,writer);
			  writer.close();
			  writer = null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
