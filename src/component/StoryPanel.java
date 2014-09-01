package component;
import javax.swing.*;

import soundFactory.MP3Player;

import background.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoryPanel extends JPanel implements Runnable
{
	private static final long serialVersionUID = 5090489860496503908L;
	private static final int DELAY = 35;
	
	//Keyboard Listener
	private KeyboardListener kListener;	
	
	//Background Image for game status
	NavBar navBar;
	Radar radar;
	
	//Game Play, where the main game play occurs
	GamePlayPanel gamePanel;
	
	//Player Status
	private PlayerStatsPanel player1StatsPanel;
	private PlayerStatsPanel player2StatsPanel;
	
	//Buttons
	private CustomButton pauseButton;
	private CustomButton settingsButton;
	private CustomButton exitButton;
	
	//Button clicked
	private boolean pauseClicked=false;
	private boolean settingsClicked=false;
	private boolean exitClicked=false;
	
	private MP3Player happyBackgroundSound;
	private MP3Player pauseSound;
	
	//Thread
	private Thread thread;
	private boolean end;
	
	public StoryPanel(int panelWidth, int panelHeight, KeyboardListener kListener)
	{
		//Lets set up our thread and run it 
		// The this here refers to the run() method as our JPanel implements Runnable				//This will automatically start the run() method
		end=false;
		thread= new Thread(this);
		
		//setting up StoryPanel
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		//this.setDoubleBuffered(true);
		this.setBackground(Color.black);
		this.setLayout(null);
		
		//Setting up Status Frame
		navBar= new NavBar("../img/game-stats.png");
		
		//Radar Animation
		radar=new Radar("../img/radar-sprite.png");
		
		//Setting up and adding gamePanel to storyPanel
		//need to fix this
		int gamePanelX=6;
		int gamePanelY=80;
		int gamePanelWidth=985;
		int gamePanelHeight=415;
	
		//setting up KeyboardListener
		this.kListener=kListener;
		this.addKeyListener(kListener);
		
		//SetUp Game Panel and add it to this container
		gamePanel= new GamePlayPanel(gamePanelX,gamePanelY, 
				 gamePanelWidth, gamePanelHeight, kListener);
		this.add(gamePanel);
		
		//setting up Background Music
		happyBackgroundSound= new MP3Player();
		happyBackgroundSound.load("../sound/happy-background.mp3");
		
		pauseSound=new MP3Player();
		pauseSound.load("../sound/pause.mp3");
		
		
		/*****************************************************************
		* Setting up Buttons: Button(X, Y, Width, Height)
		* Colors, Sounds and Action Listeners
		******************************************************************/
		String hoverSoundURL="../sound/menu-hover.wav";
		String clickSoundURL="../sound/click.wav";
		
		pauseButton = new CustomButton(338,17,96,62);
		settingsButton = new CustomButton(456,17,96,62);
		exitButton = new CustomButton(574,17,96,62);
		
		pauseButton.setText("Pause");
		settingsButton.setText("Settings");
		exitButton.setText("Exit");
		
		pauseButton.setHoverSound(hoverSoundURL);
		settingsButton.setHoverSound(hoverSoundURL);
		exitButton.setHoverSound(hoverSoundURL);
		
		pauseButton.setClickSound(clickSoundURL);
		settingsButton.setClickSound(clickSoundURL);
		exitButton.setClickSound(clickSoundURL);
		
		//Action Listeners, sets toClicked to true
		pauseButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StoryPanel.this.pauseClicked=!(StoryPanel.this.pauseClicked);
			}
		});
		
		settingsButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StoryPanel.this.settingsClicked=!(StoryPanel.this.settingsClicked);
			}
		});
		
		exitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StoryPanel.this.exitClicked=!(StoryPanel.this.exitClicked);
			}
		});
		
		//Add to this component
		this.add(pauseButton);
		this.add(settingsButton);
		this.add(exitButton);
		
		/*****************************************************************/
		
		
		player1StatsPanel = new PlayerStatsPanel(165,507,250,85);
		this.add(player1StatsPanel);
		
		player2StatsPanel = new PlayerStatsPanel(586,507,250,85);
		this.add(player2StatsPanel);
		
	}
	
	@Override
	public void run() 
	{
		while (!end)
		{
			//mp3Player
			//-------------------------------------------------------
			//					Main code here
			//-------------------------------------------------------
			
			//pause or unpause the gamepanel
			//xor logic for connecting buttons pause with keyboard p
			//only pause when only one of them is true
			boolean pause= !(kListener.pPressed()==pauseClicked);
			gamePanel.setPause((pause));
			//mp3Player=null;
			////pause or unpause story panel
			if(!pause)
			{
				updateScreen();//update
				pauseSound.end();
				happyBackgroundSound.play();
				happyBackgroundSound.unPause();
			}
			else
			{
				//mp3Player.end();
				happyBackgroundSound.pause();
				pauseSound.play();

			}
			//-------------------------------------------------------
			//-------------------------------------------------------
			
			repaint(); //Calls the paint method and displays updated data accordingly
			//Delays the thread
			try 
			{
				Thread.sleep(DELAY);
			} 
			catch (InterruptedException e) {}
		}
		
	}
	
	private void updateScreen()
	{
		
		//----------------------Radar Animation Update----------------------
		
		radar.updateImage(); //updates Radar Image every delayed second
		this.requestFocus();
		
		//------------------------------------------------------------------
		//------------------------------------------------------------------
	}
	
	@Override
	public void paint(Graphics page)
	{
		super.paint(page); //Displaying the default background (avoid flickering)
		radar.drawImage(page, 450, 502);
		navBar.drawImage(page, 0, 0);
	}
	
	
	//Starts the thread, and all other threads in the class
	public void start()
	{
		end=false;
		thread.start();
		gamePanel.start();
		
	}
	
	//safely ends process of run in the Story Panel
	public void end()
	{
		pauseClicked=false;
		settingsClicked=false;
		exitClicked=false;
		happyBackgroundSound.end();
		happyBackgroundSound.terminate();
		//happyBackgroundSound=null;
		pauseSound.end();
		pauseSound.terminate();
		//pauseSound=null;
		end=true;
	}
	
	//Get if exit is clicked
	public boolean getExit()
	{
		return exitClicked;
	}
	
}
