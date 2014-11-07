package gameObjects;
import java.awt.Graphics;
import characterImage.DirectionalBulletImage;
import characterImage.DirectionalBulletImage.BulletDirection;
import properties.CollidableObject;
import properties.MobileObject;

public class DirectionalBullet extends CollidableObject implements MobileObject
{
	//Images
	private DirectionalBulletImage BulletImage;
	//Location in component
	private int xLocation;//x Location on the component
	private int yLocation;//y Location on the component
	//Velocity of the Bullet
	private int velocity;

	public DirectionalBullet(int x, int y, DirectionalBulletImage image)
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

	@Override
	public void update() 
	{
		if(BulletImage.getDirection()==BulletDirection.E)
		{
			xLocation+=velocity;//moves bullet east
		}
		else if(BulletImage.getDirection()==BulletDirection.W)
		{
			xLocation-=velocity;
		}
		else if(BulletImage.getDirection()==BulletDirection.SW)
		{
			xLocation-=velocity;
			yLocation+=velocity;
		}
		else if(BulletImage.getDirection()==BulletDirection.NW)
		{
			xLocation-=velocity;
			yLocation-=velocity;
		}
		else if(BulletImage.getDirection()==BulletDirection.SE)
		{
			xLocation+=velocity;
			yLocation+=velocity;
		}
		else if(BulletImage.getDirection()==BulletDirection.NE)
		{
			xLocation+=velocity;
			yLocation-=velocity;
			
		}
		
		
	}

	public int getVelocity() 
	{
		return velocity;
	}

	public void setVelocity(int velocity)
	{
		this.velocity = velocity;
	}

	@Override
	public void notify(CollidableObject cObject) 
	{
		// TODO Auto-generated method stub
	}

}
