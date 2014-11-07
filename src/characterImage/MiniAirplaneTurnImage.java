package characterImage;
import imageFactory.AnimatedImage;
import imageFactory.DrawableImage;

public class MiniAirplaneTurnImage extends DrawableImage implements AnimatedImage
{
	private final int width=31;//width of the image
	private final int height=32;//height of the image
	private final int newWidth= width; 
	private final int newHeight=height;
	//private final int xLocationSpriteSheet=none;
	private int yLocationSpriteSheet;
	private final int delay=5;// total delay to change animation frame
	
	private int frameNumber;// describes the frame number for plane animation
	private int totalFrame; // total number of frames in an animation
	private int delayCounter; //count for delay
	//private int firstFrame;
	
	
	
	public MiniAirplaneTurnImage(String imageURL, PlaneColor color) 
	{
		super(imageURL);
		totalFrame=8;//3 frames per plane
		delayCounter=0;//delay counter starts at 0
		
		//Set the image to military color
		if(color==PlaneColor.MILITARY)
		{
			yLocationSpriteSheet=136;
		}
		//Set the image to white color
		else if(color==PlaneColor.WHITE)
		{
			yLocationSpriteSheet=103;
		}
		//Set the image to green color
		else if(color==PlaneColor.GREEN)
		{
			yLocationSpriteSheet=70;
		}
		//Set the image to blue color
		else if(color==PlaneColor.BLUE)
		{
			yLocationSpriteSheet=37;
		}
		//Set the image for the plane
		this.setImage(frameNumber*32+frameNumber+5, yLocationSpriteSheet, width,height ,newWidth, newHeight);		
	}
	
	public void updateImage()
	{
		delayCounter++;
		if(delayCounter>delay)
		{
		delayCounter=0;
		frameNumber++;//updates frame to next frame
		frameNumber%=totalFrame;// if surpass 3rd frame, back to frameNumber 0
		//sets image to specific frameNumber by multiplying it with 500, aka width of the image
		this.setImage(frameNumber*32+frameNumber+5,yLocationSpriteSheet,width,height ,newWidth, newHeight );
		}
	}
}
