package p;

import java.awt.Color;
import java.awt.image.BufferedImage;

import ij.ImagePlus;
import ij.process.ImageProcessor;

public class imageRead {
	void start() {
		int num = 0;
		ImagePlus imgPlus = new ImagePlus("g.jpg");
		ImageProcessor imgProcessor = imgPlus.getProcessor();
		BufferedImage bufferedImage = imgProcessor.getBufferedImage();
		colorFuntion f = new colorFuntion();
		for(int y=0;y<bufferedImage.getHeight();y++)
		{
		    for(int x=0;x<bufferedImage.getWidth();x++)
		    {
		        Color color = new Color(bufferedImage.getRGB(x, y));
		        num = f.serch(color.getRed(),color.getGreen(),color.getBlue());
		    }
	}

 }
}
