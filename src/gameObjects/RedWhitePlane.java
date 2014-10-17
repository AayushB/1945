package gameObjects;

import java.awt.Graphics;

import characterImage.RedWhitePlaneImage;
import properties.CollidableObject;
import properties.MobileObject;


public class RedWhitePlane extends CollidableObject implements MobileObject{
	
	//Images
		private RedWhitePlaneImage planeImage;
		private RedWhitePlaneImage shadowImage;
		//Location in component
		private int xLocation;//x Location on the component
		private int yLocation;//y Location on the component
		//Velocity of the Player
		private int velocity;

	public RedWhitePlane(int x, int y, RedWhitePlaneImage planeImage, RedWhitePlaneImage shadowImage) {
		super(x, y, planeImage);
		this.planeImage=planeImage;
		this.shadowImage=shadowImage;
		//Setting up the location of the Player in the component
		this.xLocation=x;
		this.yLocation=y;
		//changing the size of the image of the shadow
		this.shadowImage.newDimension((int)(shadowImage.getWidth()/1.5),
		(int)(shadowImage.getHeight()/1.5));
		//default velocity
		this.setVelocity(0);
	}

	@Override
	public void draw(Graphics page) {
		
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

	@Override
	public void update() {
		planeImage.updateImage();//Animates the ship
		//Updates Location Information for plane and collision
		//updateLocation(xLocation, yLocation);
		yLocation+=velocity;	
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
}
