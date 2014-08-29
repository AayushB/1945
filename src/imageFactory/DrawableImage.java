package imageFactory;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
public class DrawableImage 
{
	private BufferedImageLoader ImageLoader;
	private BufferedImage bufferedImage;
	private BufferedImage grabbedImage;
	
	private int newWidth;
	private int newHeight;
	private String imageURL;
	
	public DrawableImage(String imageURL)
	{
		this.imageURL=imageURL;

		//Loading the image from URL into bufferedImage
		ImageLoader=new BufferedImageLoader();
		try {
			bufferedImage=ImageLoader.loadImage(imageURL);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void setImage(int x, int y, int width, int height, int newWidth, int newHeight)
	{
		//Setting specific part of the sprite as the image
		grabbedImage=bufferedImage.getSubimage(x, y, width, height);
		this.newHeight = newHeight;
		this.newWidth = newWidth;
	}
	
	public void drawImage(Graphics page, int x, int y)
	{
		//drawing the image in a given components page
		page.drawImage(grabbedImage, x, y ,newWidth,newHeight, null);
	}
	
	public String getImageURL()
	{
		return imageURL;
	}
	
	public void setImageURL(String imageURL)
	{
		this.imageURL=imageURL;
	}
	
	public int getWidth() 
	{
		return newWidth;
	}
	
	public int getHeight()
	{
		return newHeight;
	}
	
	public void newDimension(int width, int height)
	{
		newWidth=width;
		newHeight=height;
	}
}
