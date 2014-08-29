package background;

import imageFactory.DrawableImage;

public class OceanGradient extends DrawableImage
{
	private static final int width= 1000;
	private static final int height=415;
	private static final int newWidth= width; 
	private static final int newHeight=height;
	
	public OceanGradient(String imageURL)
	{
		//sets the gradient image to OceanGradient
		super(imageURL);
		this.setImage(0, 0, width,height ,newWidth, newHeight);
	}
	
}
