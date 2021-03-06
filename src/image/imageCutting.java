package image;

import ij.ImagePlus;
import ij.io.FileSaver;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class imageCutting {
	ImagePlus cutImage;
	public imageCutting(ImagePlus image){
		cutImage = image;
	}
	
	ImagePlus[][] cutImage() {
		int imageWidth = cutImage.getWidth();
		int imageHeight = cutImage.getHeight();
		ImagePlus[][] array = new ImagePlus[imageWidth/128][imageHeight/128];
		for(int i =0; i< imageWidth; i=i+128) {
			for(int j = 0; j< imageHeight; j=j+128) {
				ImagePlus combinedImage = new ImagePlus();
				ImageProcessor cutProcessor = new ColorProcessor(128, 128);
				for(int k = 0; k< 128; k++)
					for(int l = 0; l< 128; l++)
						cutProcessor.putPixel(k, l, cutImage.getPixel(k+i, l+j));
				combinedImage.setProcessor(cutProcessor);
				array[i/128][j/128] = combinedImage;
			}
		}
		return array;
	}
}
