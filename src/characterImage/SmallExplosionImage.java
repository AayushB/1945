package characterImage;
import imageFactory.AnimatedImage;
import imageFactory.DrawableImage;

public class SmallExplosionImage extends DrawableImage implements AnimatedImage
{
	private int width=32;//width of the image
	private int height=31;//height of the image
	private int newWidth= width; 
	private int newHeight=height;
	private int xLocationSpriteSheet=70;
	private int yLocationSpriteSheet=169;
	private int delay=5;// total delay to change animation frame
	
	private int frameNumber;// describes the frame number for plane animation
	private int totalFrame; // total number of frames in an animation
	private int delayCounter; //count for delay

	public SmallExplosionImage(String imageURL) 
	{
		super(imageURL);
		frameNumber=0; // initial frameNumber is 0
		totalFrame=6;
		delayCounter=0;
		this.setImage(xLocationSpriteSheet+frameNumber*width+frameNumber, yLocationSpriteSheet, width,height ,newWidth, newHeight);		
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
		this.setImage(xLocationSpriteSheet+frameNumber*width+frameNumber, yLocationSpriteSheet, width,height ,newWidth, newHeight);	
		}
	}
	
	

}
