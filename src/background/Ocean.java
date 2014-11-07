package background;
import java.awt.Graphics;
import properties.MobileObject;
import imageFactory.DrawableImage;

public class Ocean implements MobileObject
{
	private DrawableImage oceanSprite;
	private static final int amountX=33;//total columns
	private static final int amountY=15; // row 
	
	private int xLocation; // draw location in a component
	private int yLocation; // draw location in a component
	private int oceanHeight; // total height of the ocean
	private int velocity; // velocity of how fast ocean image changes
		
	public Ocean()
	{
		//grabbing 2 ocean sprite images and setting a 2D array of sprite
		int spriteWidth=31;
		int spriteHeight=32;
		
		oceanSprite= new DrawableImage("../img/spritesheet.png");
		oceanSprite.setImage(268, 367, spriteWidth, spriteWidth, spriteWidth, spriteHeight);
		
		// setting up basic characteristics
		oceanHeight=amountY*32;
		velocity=0;
		xLocation=0;
		yLocation=0;
	}
	
	//draws the ocean sprite from 2D array in a  given component
	@Override
	public void draw(Graphics page) 
	{
		for (int i=0; i<amountX; i++)
		{
			for (int j=0; j<amountY; j++)
			{
				oceanSprite.drawImage(page, xLocation+i*31, yLocation+j*32);
				oceanSprite.drawImage(page, xLocation+i*31, yLocation+j*32-480);
				oceanSprite.drawImage(page, xLocation+i*31, yLocation+j*32+480);
			}
		}	
	}

	//updating the precise location of the ocean in a component
	private void updateLocation(int x, int y) 
	{
		xLocation=x;
		yLocation=y;
	}
	
	// update of the ocean Image
	public void update()
	{
		yLocation+=velocity;
		if (yLocation >= oceanHeight)
		{
			yLocation=-1*oceanHeight;
		}
		updateLocation(xLocation, yLocation);
	}
	
	//setter and getter of the velocity  ocean
	public void setVelocity(int velocity)
	{
		this.velocity=velocity;
	}
	
	public int getVelocity()
	{
		return velocity;
	}
	
}