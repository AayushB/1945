package characterImage;
import imageFactory.AnimatedImage;
import imageFactory.DrawableImage;

public class MiniAirplaneImage extends DrawableImage implements AnimatedImage
{
	private final int width=31;//width of the image
	private final int height=32;//height of the image
	private final int newWidth= width; 
	private final int newHeight=height;
	//private static final int xLocationSpriteSheet=none;
	private final int yLocationSpriteSheet=466;
	private final int delay=5;// total delay to change animation frame
	
	private int frameNumber;// describes the frame number for plane animation
	private int totalFrame; // total number of frames in an animation
	private int delayCounter; //count for delay
	private int firstFrame;
	
	public MiniAirplaneImage(String imageURL, PlaneColor color) 
	{
		super(imageURL);
		totalFrame=3;//3 frames per plane
		delayCounter=0;//delay counter starts at 0
		
		//Set the image to military color
		if(color==PlaneColor.MILITARY)
		{
			frameNumber=0;
			firstFrame=0;
		}
		//Set the image to white color
		else if(color==PlaneColor.WHITE)
		{
			frameNumber=3;
			firstFrame=3;
		}
		//Set the image to green color
		else if(color==PlaneColor.GREEN)
		{
			frameNumber=6;
			firstFrame=6;
		}
		//Set the image to blue color
		else if(color==PlaneColor.BLUE)
		{
			frameNumber=9;
			firstFrame=9;
		}
		//Set the image for the plane
		this.setImage(frameNumber*32+frameNumber+5, yLocationSpriteSheet, width,height ,newWidth, newHeight);		
	}
	
	public void updateImage()
	{
		//we will update animation when delay counter reaches delay, then reset delay counter
		delayCounter++;
		if(delayCounter>delay)
		{
		delayCounter=0;
		frameNumber++;//updates frame to next frame
	    //if surpass 3rd frame, back to frameNumber 0
		if (frameNumber>=firstFrame+totalFrame)
		{
			frameNumber=firstFrame;
		}
		//sets image to specific frameNumber by multiplying width of the image
		this.setImage(frameNumber*32+frameNumber+5,yLocationSpriteSheet,width,height ,newWidth, newHeight );
		}
	}
}
