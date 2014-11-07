package characterImage;

import imageFactory.DrawableImage;

public class DoubleForwardBulletImage extends DrawableImage
{
	private int width=31;//width of the image
	private int height=32;//height of the image
	private int newWidth= width; 
	private int newHeight=height;
	//private static final int xLocationSpriteSheet=none;
	private int yLocationSpriteSheet=202;
	
	public DoubleForwardBulletImage(String imageURL) 
	{
		super(imageURL);
		this.setImage(5, yLocationSpriteSheet, width, height, newWidth, newHeight);
	}
}
