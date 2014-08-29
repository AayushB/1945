//A MP3 Player that lets you load, play, pause and stop an mp3 song
package soundFactory;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

public class MP3Player implements Runnable
{
	private AudioInputStream din;
	private AudioFormat decodedFormat;
	private AudioInputStream in;
	private boolean play;
	private boolean pause;
	private boolean loaded;
	private String mp3URL;
	
	public MP3Player()
	{
		din=null;
		decodedFormat=null;
		in=null;
		play=false;
		pause=false;
		mp3URL=null;
		loaded=false;
		
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run()
	{
		while(true) // Keeps the music player going....
		{
			//System.out.println("x");
			if (loaded)
			{
				byte[] data = new byte[4096];
				SourceDataLine line;
				try 
				{
					line = getLine(decodedFormat);
					if (line != null)
					{
						// Point to the Location of play address
						line.start();
						int nBytesRead = 0 ;
						@SuppressWarnings("unused")
						int nBytesWritten = 0;
						while (play==true && nBytesRead != -1)
						{
							if(!pause) // won't execute in pause mode
							{
								line.start(); // in case a pause was in place, else won't do anything
								nBytesRead = din.read(data, 0, data.length);
								if (nBytesRead != -1) nBytesWritten = line.write(data, 0, nBytesRead);
							}
							else
							{
								line.stop(); // stop at given address during pause so it can resume
							}
						}
						// Done Playing the music
						line.drain();
						line.stop();
						line.close();
						din.close();
						in.close();
					} 
				} 
				catch (LineUnavailableException | IOException e) 
				{
					e.printStackTrace();
				} 
				//ReLoads music to play again.  
			}
			// Loads/Refreshes the mp3 URL again, when its complete
			load(mp3URL);
		}
	}
	
	
	public void play()
	{ 
		play=true; 
	}

	public void end()
	{
		play=false;
	}

	public void pause()
	{
		pause=true;
	}

	public void unPause()
	{
		pause=false;
	}	
	
	public void load(String mp3URL)
	{
		this.mp3URL=mp3URL;
		URL url= this.getClass().getResource(mp3URL);
		try 
		{
			in= AudioSystem.getAudioInputStream(url);
		}
		catch (UnsupportedAudioFileException | IOException e) 
		{
			e.printStackTrace();
		}
    
		din = null;
		AudioFormat baseFormat = in.getFormat();
		decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
										baseFormat.getSampleRate(),
	                                    16,
	                                    baseFormat.getChannels(),
	                                    baseFormat.getChannels() * 2,
	                                    baseFormat.getSampleRate(),
	                                    false);
	    din = AudioSystem.getAudioInputStream(decodedFormat, in);
	    loaded=true;
	} 

	private SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException
	{
		SourceDataLine res = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		res = (SourceDataLine) AudioSystem.getLine(info);
		res.open(audioFormat);
		return res;
	} 
}
