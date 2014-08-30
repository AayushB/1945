package background;
import imageFactory.AnimatedImage;
import imageFactory.DrawableImage;

public class Radar extends DrawableImage implements AnimatedImage
{

	private static final int width=500;//width of the image
	private static final int height=500;//height of the image
	private static final int newWidth= width/5; 
	private static final int newHeight=height/5;
	//private static final int xLocationSpriteSheet=none;
	//private static final int yLocationSpriteSheet=none;
	private static final int delay=5;// total delay to change animation frame
	
	private int frameNumber;// describes the frame number for radar animation
	private int totalFrame;//total number of frames in radar animation
	private int delayCounter;//count for delay
	
	public Radar(String imageURL) 
	{
		super(imageURL);
		frameNumber=11; // initial frameNumber is 0
		totalFrame=12;
		delayCounter=0;
		this.setImage(frameNumber*500,0,width,height ,newWidth, newHeight );
	}
	
	public void updateImage()
	{
		//we will update animation when delay counter reaches delay, then reset delay counter
		delayCounter++;
		if(delayCounter>delay)
		{
			delayCounter=0;
			frameNumber--;//updates frame to next frame
			if(frameNumber < totalFrame-12)
			{
				frameNumber=11;// if surpass 12th frame, back to frameNumber 0
			}
			//sets image to specific frameNumber by multiplying it with 500, aka width of the image
			this.setImage(frameNumber*500,0,width,height ,newWidth, newHeight );
		}
	}

}
