package properties;

//Defines an existing dimension for a screen
public class ScreenDimension 
{
	private int top;
	private int bottom;
	private int right;
	private int left;
	
	public ScreenDimension(int x , int y, int width, int height)
	{
		setTop(y);
		setBottom(height-y);
		setRight(width-x);
		setLeft(x);
	}

	public int getTop() 
	{
		return top;
	}

	public void setTop(int top) 
	{
		this.top = top;
	}

	public int getbottom() 
	{
		return bottom;
	}

	public void setBottom(int bottom) 
	{
		this.bottom = bottom;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) 
	{
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) 
	{
		this.left = left;
	}

	
}
