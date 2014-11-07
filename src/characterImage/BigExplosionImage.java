package characterImage;
import imageFactory.AnimatedImage;
import imageFactory.DrawableImage;

public class BigExplosionImage extends DrawableImage implements AnimatedImage
{
	private int width=62;//width of the image
	private int height=65;//height of the image
	private int newWidth= width; 
	private int newHeight=height;
	//private static final int xLocationSpriteSheet=none;
	private int yLocationSpriteSheet=301;
	private int delay=5;// total delay to change animation frame
	
	private int frameNumber;// describes the frame number for plane animation
	private int totalFrame; // total number of frames in an animation
	private int delayCounter; //count for delay

	public BigExplosionImage(String imageURL) 
	{
		super(imageURL);
		frameNumber=0; // initial frameNumber is 0
		totalFrame=7;
		delayCounter=0;
		this.setImage(frameNumber*65+frameNumber+5, yLocationSpriteSheet, width,height ,newWidth, newHeight);		
	}
	
	public void updateImage()
	{
		//we will update animation when delay counter reaches delay, then reset delay counter
		delayCounter++;
		if(delayCounter>delay)
		{
		delayCounter=0;
		frameNumber++;//updates frame to next frame
		frameNumber%=totalFrame;// if surpass 3rd frame, back to frameNumber 0
		//sets image to specific frameNumber by multiplying it with 500, aka width of the image
		this.setImage(frameNumber*65+frameNumber+5,yLocationSpriteSheet,width,height ,newWidth, newHeight );
		}
	}
	
	

}
