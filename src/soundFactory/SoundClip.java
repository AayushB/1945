package soundFactory;
import java.io.IOException;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundClip 
{
	private AudioClipLoader clipLoader;
	private Clip clip;
	
    public SoundClip(String clipURL) 
    {
    	clipLoader = new AudioClipLoader();
    	try {
			clip=clipLoader.loadClip(clipURL);
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) 
		{
			e.printStackTrace();
		}
    }
    
    public void play()
    {
        clip.setFramePosition(0);  // Must always rewind!
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
            clip.stop();
    }
    
}