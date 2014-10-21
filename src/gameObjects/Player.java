package gameObjects;
import java.awt.Graphics;
import component.KeyboardListener;
import properties.CollidableObject;
import properties.MobileObject;
import properties.ScreenDimension;
import characterImage.BigOrangeAirplane;

public class Player extends CollidableObject implements MobileObject
{
	//Images
	private BigOrangeAirplane planeImage;
	private BigOrangeAirplane shadowImage;
	//Location in component
	private int xLocation;//x Location on the component
	private int yLocation;//y Location on the component
	//Velocity of the Player
	private int velocity;
	//Screen Dimension player can exist in
	ScreenDimension scr;
	//Listener for keyboard
	private KeyboardListener kListener;
	
	public Player(	int x, int y,
					BigOrangeAirplane planeImage, BigOrangeAirplane shadowImage,
					KeyboardListener kListener, ScreenDimension scr)
	{
		//Setup Collidable Object
		super(x,y,planeImage);
		//setup screen Dimension
		this.scr=scr;
		//setup Plane and Shadow Image
		this.planeImage=planeImage;
		this.shadowImage=shadowImage;
		//Setting up the location of the Player in the component
		this.xLocation=x;
		this.yLocation=y;
		//changing the size of the image of the shadow
		this.shadowImage.newDimension((int)(shadowImage.getWidth()/1.5),
									(int)(shadowImage.getHeight()/1.5));
		velocity=0;//default velocity of the plane
		this.kListener=kListener;// KeyBoard Listener
	}
	
	private void updateLocation(int x, int y)
	{
		//Updates Image 
		this.xLocation=x;
		this.yLocation=y;
		//Updates CollisionBorder Location
		this.updateCollisionBoundry(x, y, planeImage);
	}
	
	//Draw planeImage
	public void draw(Graphics page)
	{
		planeImage.drawImage(page, xLocation, yLocation);//Draws the plane on the component
		//Draws the collision Border
		if(this.getBorderVisibility())
		{
			drawCollisionBorder(page,xLocation,yLocation,planeImage.getWidth(),planeImage.getHeight());
		}
	}
	
	//Draw shadowImage
	public void drawShadow(Graphics page)
	{
		shadowImage.drawImage(page, xLocation+55, yLocation+55);
	}
	
	//Getter and setter for velocity of the player
	public void setVelocity(int velocity)
	{
		this.velocity=velocity;
	}
	
	public int getVelocity()
	{
		 return velocity;
	}
	
	//Update the plane based on keyboard contents

	public void update() 
	{
		planeImage.updateImage();//Animates the plane
		
		//Updating based on keyBoard Listener
		if(kListener.downPressed() && kListener.leftPressed())
		{
			//Comparing if plane is outside of screen scr
			if (this.bottom <= scr.getbottom() && this.left >= scr.getLeft())
			{
				yLocation+=velocity;
				xLocation-=velocity;
			}
		}
		else if(kListener.downPressed() && kListener.rightPressed())
		{
			if (this.bottom <= scr.getbottom() && this.right <= scr.getRight())
			{
				yLocation+=velocity;
				xLocation+=velocity;
			}
		}
		else if(kListener.upPressed() && kListener.leftPressed())
		{
			if (this.top >= scr.getTop() && this.left >= scr.getLeft())
			{
				yLocation-=velocity;
				xLocation-=velocity;
			}
		}
		else if(kListener.upPressed() && kListener.rightPressed())
		{
			if (this.top >= scr.getTop() && this.right <= scr.getRight())
			{ 
				yLocation-=velocity;
				xLocation+=velocity;
			}
		}
		else if (kListener.downPressed())
		{
			if (this.bottom <= scr.getbottom())
				yLocation+=velocity;
		}
		else if (kListener.upPressed())
		{
			if (this.top >= scr.getTop())
				yLocation-=velocity;
		}
		else if (kListener.leftPressed())
		{
			if (this.left >= scr.getLeft())
				xLocation-=velocity;
		}
		else if (kListener.rightPressed())
		{
			if (this.right <= scr.getRight())
			xLocation+=velocity;
		}
		else
		{
			if (this.bottom <= scr.getbottom())
				yLocation+=velocity-1;
		}
		
		//Updates Location Information for plane and collision
		updateLocation(xLocation, yLocation);
		
	}

	@Override
	public void notify(CollidableObject cObject) 
	{
		// TODO Auto-generated method stub
		
	}
}
