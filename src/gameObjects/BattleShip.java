package gameObjects;

import java.awt.Graphics;

import characterImage.BattleShipImage;
import properties.CollidableObject;
import properties.MobileObject;

public class BattleShip extends CollidableObject implements MobileObject
{
	//Images
	private BattleShipImage shipImage;
	private BattleShipImage shadowImage;
	//Location in component
	private int xLocation;//x Location on the component
	private int yLocation;//y Location on the component
	//Velocity of the Player
	private int velocity;
	
	public BattleShip(int x, int y, BattleShipImage shipImage, BattleShipImage shadowImage)
	{
		super(x, y, shipImage);
		this.shipImage=shipImage;
		this.shadowImage=shadowImage;
		//Setting up the location of the Player in the component
		this.xLocation=x;
		this.yLocation=y;
		//default velocity
		this.velocity=0;
	}

	@Override
	public void draw(Graphics page) 
	{
		shipImage.drawImage(page, xLocation, yLocation);//Draws the plane on the component
		//Draws the collision Border
		if(this.getBorderVisibility())
		{
			drawCollisionBorder(page,xLocation,yLocation,shipImage.getWidth(),shipImage.getHeight());
		}
		
	}
	
	//Draw shadowImage
		public void drawShadow(Graphics page)
		{
			shadowImage.drawImage(page, xLocation+3, yLocation+15);
		}

	@Override
	public void update() 
	{
		shipImage.updateImage();//Animates the ship
		//Updates Location Information for plane and collision
		//updateLocation(xLocation, yLocation);
		yLocation++;
		
	}
	
}
