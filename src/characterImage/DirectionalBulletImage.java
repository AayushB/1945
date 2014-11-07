package characterImage;

import imageFactory.DrawableImage;


public class DirectionalBulletImage extends DrawableImage 
{
	
	public enum BulletDirection
	{
		SE, SW, NE, NW, E, W
	}
	
	private int width=31;//width of the image
	private int height=32;//height of the image
	private int newWidth= width; 
	private int newHeight=height;
	private int yLocationSpriteSheet=235;
	private BulletDirection direction;
	private int frameNumber;// describes the frame number for plane animation
	
	public DirectionalBulletImage(String imageURL, BulletDirection direction) 
	{
		super(imageURL);
		
		this.direction=direction;

		//Set the south east facing bullet
		if(direction==BulletDirection.SE)
		{
			frameNumber=0;
			
		}
		//Set the south west facing bullet
		else if(direction==BulletDirection.SW)
		{
			frameNumber=1;
		
		}
		//Set the north east facing bullet
		else if(direction==BulletDirection.NE)
		{
			frameNumber=2;
			
		}
		//Set the north west facing bullet
		else if(direction==BulletDirection.NW)
		{
			frameNumber=3;
		
		}
		//Set the south east facing bullet
		else if(direction==BulletDirection.E)
		{
			frameNumber=4;
			
		}
		//Set the west facing bullet
		else if(direction==BulletDirection.W)
		{
			frameNumber=5;
		}
		//Set the image for the plane
		this.setImage(frameNumber*32+frameNumber+5, yLocationSpriteSheet, width,height ,newWidth, newHeight);		

	}

	public BulletDirection getDirection() {
		return direction;
	}
}
