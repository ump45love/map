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
	int mapId[];
	ImagePlus image[][];
	String mapName;
	public readMap(String mapName){
		this.mapName = mapName;
	}
	public void setMapName(String mapName){
		this.mapName = mapName;
	}
	public String getMapName(){
		return mapName;
	}
	
	public ImagePlus[][] getImageArray(){
		return image;
	}
	public ImagePlus getImage(int x,int y){
		if((x>= size[0]) || (y>= size[1]))
			return null;
		return image[x][y];
	}
	
	public int[] getMapId() {
		return mapId;
	}
	public Byte[] getMapSize() {
		return size;
	}
	
	void readImage(DataInputStream read) throws IOException {
		byte r[] = new byte[128];
		byte g[] = new byte[128];
		byte b[] = new byte[128];
		 for(int i = 0; i<size[0]; i++) {
			 for(int j = 0; j<size[1]; j++) {
				 	 ImageProcessor paperProcessor = new ColorProcessor(128, 128);
				 	 ImagePlus combinedImage = new ImagePlus();
				 for(int k = 0; k<128; k++) {
					 read.read(r,0,128);
					 read.read(g,0,128);
					 read.read(b,0,128);
					 for(int l = 0; l<128; l++) {
						 paperProcessor.putPixel(k, l, ((r[l]<<16)+(g[l]<<8)+b[l]));
							 }
					 }
				 combinedImage.setProcessor(paperProcessor);
				 image[i][j] = combinedImage;
			 }
		 }
		 read.close();
		
	}
	void readFile(DataInputStream read) throws IOException {
		 for(int i = 1; i<=size[0]*size[1]; i++) {
			 mapId[i-1] = read.readInt();
			 if(i%size[1] == 0)
				 read.readByte();
		 }
		 read.readByte();

	}
	
	void readSize(DataInputStream read) throws IOException {
		size[0] = read.readByte();
		size[1] = read.readByte();
		mapId = new int[size[0]*size[1]];
		image = new ImagePlus[size[0]][size[1]];
	}

	
	public void read() {
		  try {
			  String saveName = this.mapName;
			  int chk = 0;
			  if(check.chkFile("./plugins/makeMap/map/"+mapName)) {
				  DataInputStream read = new DataInputStream(new FileInputStream("./plugins/makeMap/map/"+saveName));
				  readSize(read);
				  readFile(read);
				  readImage(read);
				  read.close();
				  read = null;
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
