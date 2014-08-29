package background;

import imageFactory.DrawableImage;

public class NavBar extends DrawableImage
{
	private static final int width= 1000;
	private static final int height=616;
	private static final int newWidth= width; 
	private static final int newHeight=height;
	
	public NavBar(String imageURL)
	{
		//sets the Navbar image to  NavBar
		super(imageURL);
		this.setImage(0, 0, width,height ,newWidth, newHeight);
	}
}
