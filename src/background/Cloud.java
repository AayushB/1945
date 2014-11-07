package background;
import java.awt.Graphics;

import properties.MobileObject;
import imageFactory.DrawableImage;

public class Cloud extends DrawableImage implements MobileObject
{
	private static final int width= 825;
	private static final int height=590;
	private static final int newWidth= width; 
	private static final int newHeight=height;
	
	private int xLocation;
	private int yLocation;
	int velocity;
	
	public Cloud(String imageURL)
	{
		//sets the Navbar image to  NavBar
		super(imageURL);
		this.setImage(0, 0, width,height ,newWidth*2, newHeight*2);
		xLocation=-200;
		yLocation=-1300;
		velocity=2;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	@Override
	public void draw(Graphics page) 
	{
		this.drawImage(page, xLocation, yLocation);
		
	}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		yLocation+=velocity;
	}
	
	public int getXLocation()
	{
		return xLocation;
	}
	
	public void setXLocation(int value)
	{
		xLocation=value;
	}
	
	public int getYLocation()
	{
		return yLocation;
	}
	
	public void setYLocation(int value)
	{
		yLocation=value;
	}
	
	public void randomize()
	{
		//Random random = new Random();
		double rnd= 1+ (int)(Math.random()*5); 
		xLocation=-1*(100+(int)(Math.random()*600));
		this.setImage(0, 0, width,height ,(int)(newWidth*rnd), (int)(newHeight*rnd));
	}
}
