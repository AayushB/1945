package characterImage;
import imageFactory.AnimatedImage;
import imageFactory.DrawableImage;

public class BattleShipImage extends DrawableImage implements AnimatedImage
{

	private static final int width=41;//width of the image
	private static final int height=197;//height of the image
	private static final int newWidth= width; 
	private static final int newHeight=height;
	private static final int xLocationSpriteSheet=466;
	private static final int yLocationSpriteSheet=301;
	private static final int delay=10;// total delay to change animation frame
	
	private int frameNumber;// describes the frame number for plane animation
	private int totalFrame; // total number of frames in an animation
	private int delayCounter; //count for delay
	
	
	public BattleShipImage(String imageURL)
	{
		super(imageURL);
		frameNumber=0; // initial frameNumber is 0
		totalFrame=2;
		delayCounter=0;
		this.setImage(xLocationSpriteSheet, yLocationSpriteSheet, width,height ,newWidth, newHeight);		
	}
	

	@Override
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
		this.setImage(frameNumber*width+xLocationSpriteSheet+frameNumber,yLocationSpriteSheet,width,height ,newWidth, newHeight );
		}
		
	}

}
