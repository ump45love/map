package p;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import ij.ImagePlus;
import ij.gui.ImageCanvas;
import ij.io.FileSaver;
import ij.process.ImageProcessor;

public class imageRead {
	void start() {
		Image imgPlus = new Image("path-to-sample.jpg");
		ImageProcessor imgProcessor = imgPlus.getProcessor();
		imgProcessor.invert();
		FileSaver fs = new FileSaver(imgPlus);
		fs.saveAsJpeg("path-to-inverted.jpg");
		BufferedImage bufferedImage = imgProcessor.getBufferedImage();
		for(int y=0;y<bufferedImage.getHeight();y++)
		{
		    for(int x=0;x<bufferedImage.getWidth();x++)
		    {
		        Color color = new Color(bufferedImage.getRGB(x, y));
		        int num = (color.getRed()/64)*4194304 + (color.getGreen()/64)*10240 + (color.getBlue()/ 64)*64;
		        bufferedImage.setRGB(x, y, num);
		    }
		}
		ImagePlus grayImg = new ImagePlus("gray", bufferedImage);
		fs = new FileSaver(grayImg);
		fs.saveAsJpeg("path-to-gray.jpg");
	}

}
