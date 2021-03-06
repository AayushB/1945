package properties;
import imageFactory.DrawableImage;
import java.awt.Color;
import java.awt.Graphics;

//Abstract Collidable Object
public abstract class CollidableObject 
{
	protected int left;
	protected int right;
	protected int top;
	protected int bottom;
	private boolean drawCollisionBorder;
	
	//Constructor requiring an image
	public CollidableObject(int x, int y, DrawableImage image)
	{
		this.left=x;
		this.right=x+image.getWidth();
		this.top=y;
		this.bottom=y+image.getHeight();
		drawCollisionBorder=false;
	}
	
	//Constructor requiring no image
	public CollidableObject(int x, int y, int width, int height)
	{
		this.left=x;
		this.right=x+width;
		this.top=y;
		this.bottom=y+height;
		drawCollisionBorder=false;
	}
	
	//Notifies collidable Object of what it collides with
	public abstract void notify(CollidableObject cObject);
	
	protected void updateCollisionBoundry(int newX, int newY, DrawableImage image)
	{
		this.left=newX;
		this.right=newX+image.getWidth();
		this.top=newY;
		this.bottom=newY+image.getHeight();
	}
	
	//Rectangle collision logic
	public boolean collidesWith(CollidableObject co)
	{
		//Logic of two rectangles colliding with one another
		 return ! ( co.left > right
			        || co.right < left
			        || co.top > bottom
			        || co.bottom < top);
	}
	
	//Draws collision boundary
	public void drawCollisionBorder(Graphics page, int x, int y, int width, int height)
	{
		page.setColor(Color.green);
		page.drawRect(x, y, width, height);
	}
	
	//Set the collision boundary to true
	public void setBorderVisibility(boolean value)
	{
		drawCollisionBorder=value;
	}
	
	//Returns the status of border visibility
	public boolean getBorderVisibility()
	{
		return drawCollisionBorder;
	}

	
		
}