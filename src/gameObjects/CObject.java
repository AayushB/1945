package gameObjects;
import java.awt.Graphics;
import characterImage.BigOrangeAirplane;
import properties.CollidableObject;
import properties.MobileObject;

public class CObject extends CollidableObject implements MobileObject
{

	private BigOrangeAirplane planeImage;
	//Location in component
	private int xLocation;//x Location on the component
	private int yLocation;//y Location on the component
	
	public CObject(int x, int y, BigOrangeAirplane image)
	{
		super(x, y, image);
		// TODO Auto-generated constructor stub
		this.xLocation=x;
		this.yLocation=y;
		planeImage=image;
	}

	@Override
	public void draw(Graphics page) 
	{
		// TODO Auto-generated method stub
		planeImage.drawImage(page, xLocation, yLocation);
		if(this.getBorderVisibility())
		{
			drawCollisionBorder(page,xLocation,yLocation,planeImage.getWidth(),planeImage.getHeight());
		}
		
		
	}
	
	private void updateLocation(int x, int y) 
	{
		// TODO Auto-generated method stub
		xLocation=x;
		yLocation=y;
		this.updateCollisionBoundry(x, y, planeImage);
		
	}
	
	public void update()
	{
		yLocation++;
		updateLocation(xLocation, yLocation);
	}
}
