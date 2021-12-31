package image;

import java.awt.Color;
import java.awt.image.BufferedImage;

import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class imageRead {
	public static ImagePlus[][] readImage(String name) {
		int num = 0;
		ImagePlus originImage = new ImagePlus(name);
		ImageProcessor originProcessor = originImage.getProcessor();
		BufferedImage originBufferedImage = originProcessor.getBufferedImage();
		colorFuntion f = new colorFuntion();
		for(int y=0;y<originBufferedImage.getHeight();y++)
		{
		    for(int x=0;x<originBufferedImage.getWidth();x++)
		    {
		        Color color = new Color(originBufferedImage.getRGB(x, y));
		        num = f.serch(color.getRed(),color.getGreen(),color.getBlue());
		    }
		}
		ImagePlus convertImage = new ImagePlus("asd", originBufferedImage);
		int paperWidth = (convertImage.getWidth()>>7)<<7;
		int paperHeight = (convertImage.getHeight()>>7)<<7;
		if(paperWidth <convertImage.getWidth())
		   paperWidth  = paperWidth+ 128;
		if(paperHeight <convertImage.getHeight())
		   paperHeight  = paperHeight+ 128;
		    
		int imageStartWidth = (paperWidth - convertImage.getWidth())>>1;
		int imageStartHeight = (paperHeight - convertImage.getHeight())>>1;
		int imageEndWidth = imageStartWidth + convertImage.getWidth();
		int imageEndHeight = imageStartHeight + convertImage.getHeight();
		ImageProcessor paperProcessor = new ColorProcessor(paperWidth, paperHeight);
		for(int i=imageStartWidth; i<=imageEndWidth; i++){
		    for(int j=imageStartHeight; j<=imageEndHeight; j++){
		        paperProcessor.putPixel(i, j, convertImage.getPixel(i-imageStartWidth, j-imageStartHeight));
		    }
		 }
		ImagePlus combinedImage = new ImagePlus();
		combinedImage.setProcessor(paperProcessor);
		imageCutting cut = new imageCutting(combinedImage);
		ImagePlus[][] array = new ImagePlus[paperWidth/128][paperHeight/128];
		return cut.cutImage();

 }
}
