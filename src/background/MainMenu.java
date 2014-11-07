package background;

import imageFactory.DrawableImage;

public class MainMenu extends DrawableImage
{
	private int width= 1000;
	private int height=616;
	private int newWidth= width; 
	private int newHeight=height;
	
	public MainMenu(String imageURL)
	{
		//sets the Navbar image to  NavBar
		super(imageURL);
		this.setImage(0, 0, width,height ,newWidth, newHeight);
	}
}
