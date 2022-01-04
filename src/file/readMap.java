package file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class readMap {
	Byte size[] = new Byte[2];
	Byte mapId[];
	ImagePlus image[][];
	public readMap(int size){
	}
	
	void readImage(DataInputStream read) throws IOException {
		 for(int i = 0; i<size[0]; i++) {
			 for(int j = 0; i<size[1]; j++) {
					 ImageProcessor paperProcessor = new ColorProcessor(128, 128);
				 for(int k = 0; k<128; k++) {
					 for(int l = 0; l<128; l++) {
						 paperProcessor.putPixel(k, l, read.readInt());
							 }
					 }
				 image[i][j].setProcessor(paperProcessor);
			 }
		 }
		 read.close();
		
	}
	void readFile(DataInputStream read) throws IOException {
		 for(int i = 1; i<=size[0]*size[1]; i++) {
			 size[i] = read.readByte();
			 if(i%size[1] == 0)
				 read.readByte();
		 }
		 read.readByte();

	}
	
	void readSize(DataInputStream read) throws IOException {
		size[0] = read.readByte();
		size[1] = read.readByte();
		mapId = new Byte[size[0]*size[1]];
		image = new ImagePlus[size[0]][size[1]];
	}

	
	public ImagePlus[][] read(String mapName) {
		  try {
			  String ori = mapName;
			  int chk = 0;
			  while(check.chkFile("./plugins/makeMap/map/"+mapName+".ump45"))
				  mapName = ori + chk++;
			  DataInputStream read = new DataInputStream(new FileInputStream("./plugins/makeMap/map/"+mapName+".ump45"));
			  readSize(read);
			  readFile(read);
			  readImage(read);
			  read.close();
			  read = null;
			  return image;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
