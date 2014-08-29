/* 
 * This class is used to load a Buffered Image from a relative URL
 * The class takes the path in as the parameter and returns the desired Buffered Image
 */
package imageFactory;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


public class BufferedImageLoader 
{
	public BufferedImage loadImage(String pathRelativeToThis) throws IOException
	{
		URL url= this.getClass().getResource(pathRelativeToThis);
		BufferedImage img= ImageIO.read(url);
		return img;
	}
}
