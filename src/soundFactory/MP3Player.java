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
	private SourceDataLine line;
	private boolean play;
	private boolean pause;
	private boolean terminate;
	private boolean loaded;
	private String mp3URL;
	private static final int DELAY = 60;
	
	public MP3Player()
	{
		din=null;
		decodedFormat=null;
		in=null;
		play=false;
		pause=false;
		mp3URL=null;
		loaded=false;
		terminate=false;
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	//Sets Play to true, and will play the music if a URL has been loaded
	public void play()
	{ 
		play=true; 
	}

	//sets play to false, and won't play the song. Acts as a stop 
	public void end()
	{
		play=false;
	}

	//Pauses at the specific location of the mp3 file
	public void pause()
	{
		pause=true;
	}

	//Unpauses the mp3 file at the pause location
	public void unPause()
	{
		pause=false;
		line.start(); // in case a pause was in place, else won't do anything
	}	
	
	//terminates the mp3 player
	public void terminate()
	{
		terminate=true;
	}
	
	//Loads an mp3 file from a given URL
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

	
	//Run the Mp3 player in an independent thread
	@Override
	public void run()
	{
		while(!terminate) // Keeps the music player going....
		{
			if (loaded)// if a URL has been loaded then perform actions
			{
				byte[] data = new byte[4096];
				try 
				{
					line = getLine(decodedFormat);
					if (line != null)
					{
						// Point to the Location of play frame on the file
						line.start();
						int nBytesRead = 0 ;
						@SuppressWarnings("unused")
						int nBytesWritten = 0;
						
						//Play the music only if play is true
						while (play==true && nBytesRead != -1)
						{
							if(!pause) // won't execute in pause mode
							{
								nBytesRead = din.read(data, 0, data.length);
								if (nBytesRead != -1) nBytesWritten = line.write(data, 0, nBytesRead);
							}
							else
							{
								line.stop(); // stop at given address during pause so it can resume
							}
						}
						// Done Playing the music, stop
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
			//Delays the thread
			try 
			{
				Thread.sleep(DELAY);
			} 
			catch (InterruptedException e) {}
		}
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
