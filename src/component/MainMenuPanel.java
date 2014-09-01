package component;
/*******************************************************************************
* An Independent thread that gives user access to several pages of game through
* 								buttons
*******************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import soundFactory.*;
import background.*;

public class MainMenuPanel extends JPanel implements Runnable
{
	private static final long serialVersionUID = -7343455852127981428L;
	
	//Thread
	private Thread thread;
	private boolean end;
	
	//Custom Buttons
	private CustomButton playButton;
	private CustomButton howToPlayButton;
	private CustomButton highscoreButton;
	private CustomButton creditsButton;	
	private MainMenu background;
	
	//Button clicked
	private boolean playClicked=false;
	private boolean howClicked=false;
	private boolean scoreClicked=false;
	private boolean creditsClicked=false;
	
	//Theme Music
	MP3Player theme;
	
	public MainMenuPanel(int panelWidth, int panelHeight)
	{
		//Set up Thread and set end of thread to false
		thread= new Thread(this);
		end=false;
		
		//setting up Main Menu Panel
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		this.setDoubleBuffered(true);
		this.setBackground(Color.blue);
		this.setLayout(null);

		//Set up main background
		background=new MainMenu("../img/main-menu.png");
		
		//set up theme music
		theme=new MP3Player();
		theme.load("../sound/air.mp3");
		
		/*****************************************************************
		* Setting up Buttons: Button(X, Y, Width, Height)
		* Colors, Sounds and Action Listeners
		******************************************************************/
		//Button Colors
		Color buttonBackground= new Color(0,0,0,50);
		Color buttonBackgroundHover= new Color (255,255,255,50);
		Color buttonForeground= new Color(255,255,255);
		Color buttonForegroundHover= new Color(0,0,0);
		String hoverSoundURL="../sound/menu-hover.wav";
		String clickSoundURL="../sound/click.wav";
		
		//Button Location and size
		playButton = new CustomButton(400, 420, 200, 35);
		howToPlayButton = new CustomButton(400, 465, 200, 35);
		highscoreButton = new CustomButton(400, 510, 200, 35);
		creditsButton = new CustomButton(400, 555, 200, 35);
		
		//Button Font
		playButton.setFont("Haettenschweiler", Font.PLAIN, 30);
		howToPlayButton.setFont("Haettenschweiler", Font.PLAIN, 30);
		highscoreButton.setFont("Haettenschweiler", Font.PLAIN, 30);
		creditsButton.setFont("Haettenschweiler", Font.PLAIN, 30);
		
		//Button Text
		playButton.setText("Play");
		howToPlayButton.setText("How to Play");
		highscoreButton.setText("High Score");
		creditsButton.setText("Credits");
		
		//Button Background
		playButton.setBackgroundColor(buttonBackground);
		howToPlayButton.setBackgroundColor(buttonBackground);
		highscoreButton.setBackgroundColor(buttonBackground);
		creditsButton.setBackgroundColor(buttonBackground);
		
		//Button Hover Background
		playButton.setHoverBackgroundColor(buttonBackgroundHover);
		howToPlayButton.setHoverBackgroundColor(buttonBackgroundHover);
		highscoreButton.setHoverBackgroundColor(buttonBackgroundHover);
		creditsButton.setHoverBackgroundColor(buttonBackgroundHover);
		
		//Button Foreground
		playButton.setForeground(buttonForeground);
		howToPlayButton.setForeground(buttonForeground);
		highscoreButton.setForeground(buttonForeground);
		creditsButton.setForeground(buttonForeground);
		
		//Button Hover Foreground
		playButton.setHoverForegroundColor(buttonForegroundHover);
		howToPlayButton.setHoverForegroundColor(buttonForegroundHover);
		highscoreButton.setHoverForegroundColor(buttonForegroundHover);
		creditsButton.setHoverForegroundColor(buttonForegroundHover);
		
		//Button Hover Sound
		playButton.setHoverSound(hoverSoundURL);
		howToPlayButton.setHoverSound(hoverSoundURL);
		highscoreButton.setHoverSound(hoverSoundURL);
		creditsButton.setHoverSound(hoverSoundURL);
		
		//Button Click Sound
		playButton.setClickSound(clickSoundURL);
		howToPlayButton.setClickSound(clickSoundURL);
		highscoreButton.setClickSound(clickSoundURL);
		creditsButton.setClickSound(clickSoundURL);
		
		//Action Listeners, sets toClicked to true
		playButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenuPanel.this.playClicked=true;
			}
		});
		
		howToPlayButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenuPanel.this.howClicked=true;
			}
		});
		
		highscoreButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenuPanel.this.scoreClicked=true;
			}
		});
		
		creditsButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenuPanel.this.creditsClicked=true;
			}
		});
		
		//Add Buttons to the screen
		this.add(playButton);
		this.add(howToPlayButton);
		this.add(highscoreButton);
		this.add(creditsButton);
	}
	
	/*****************************************************************
	*  		Running, starting and ending the thread,
	*****************************************************************/
	
	@Override
	public void run() 
	{
		while(!end)
		{
			try 
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e) {}
			repaint();
		}
	}
	
	//Starts the thread, and all other threads in the class
	public void start()
	{
		end=false;
		theme.play();
		thread.start();
	}
	
	//safely ends process of run in the Story Panel
	public void end()
	{
		theme.end();
		theme.terminate();//terminates, and garbage collects mp3 player
		end=true;
	}
		
	/*****************************************************************
	 *				 Painting of the menu panel
	 ****************************************************************/ 

	@Override
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		background.drawImage(page, 0, 0);
		playButton.draw(page);
		howToPlayButton.draw(page);
		highscoreButton.draw(page);
		creditsButton.draw(page);
	}
	
	/*****************************************************************
	* Getters and Setters for all the private data members
	*****************************************************************/
	
	public boolean getPlayClicked()
	{
		return playClicked;
	}
	
	public void setPlayClicked(boolean playClicked)
	{
		this.playClicked=playClicked;
	}
	
	public boolean getHowToPlayClicked()
	{
		return howClicked;
	}
	
	public void setHowToPlayClicked(boolean howClicked)
	{
		this.howClicked=howClicked;
	}
	
	public boolean getHighScoreClicked()
	{
		return scoreClicked;
	}
	
	public void setHighScoreClicked(boolean scoreClicked)
	{
		this.scoreClicked=scoreClicked;
	}
	
	public boolean getCreditsClicked()
	{
		return creditsClicked;
	}
	
	public void setCreditsClicked(boolean creditsClicked)
	{
		this.creditsClicked=creditsClicked;
	}
	
	/*****************************************************************/
}



