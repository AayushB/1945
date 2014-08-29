/* 
 * This class is used to load an audio from a relative URL
 * The class takes the path in as the parameter and returns the desired Audio Clip
 */
package soundFactory;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioClipLoader 
{
	public Clip loadClip(String pathRelativeToThis) throws UnsupportedAudioFileException, IOException, LineUnavailableException 
	{
		URL url= this.getClass().getResource(pathRelativeToThis);
		AudioInputStream sound = AudioSystem.getAudioInputStream(url);
		Clip clip = AudioSystem.getClip();
        clip.open(sound);
		return clip;
	}
}
