package gameObjects;

import java.awt.Graphics;
import characterImage.DoubleForwardBulletImage;
import properties.*;

public class DoubleForwardBullet extends CollidableObject implements MobileObject
{
	//Images
	private DoubleForwardBulletImage BulletImage;
	//Location in component
	private int xLocation;//x Location on the component
	private int yLocation;//y Location on the component
	//Velocity of the Bullet
	private int velocity;

	public DoubleForwardBullet(int x, int y, DoubleForwardBulletImage image)
	{
		super(x, y, image);
		BulletImage=image;
		xLocation=x;
		yLocation=y;
	}

	@Override
	public void draw(Graphics page) 
	{
		BulletImage.drawImage(page, xLocation, yLocation);//Draws the plane on the component
		//Draws the collision Border
		if(this.getBorderVisibility())
		{
			drawCollisionBorder(page,xLocation,yLocation,BulletImage.getWidth(),BulletImage.getHeight());
		}
		
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	@Override
	public void update() 
	{
		yLocation-=velocity;//moves bullet forward
		
	}

	@Override
	public void notify(CollidableObject cObject) 
	{
		// TODO Auto-generated method stub
	}

}
