package component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import soundFactory.MP3Player;

import background.MainMenu;

public class MainMenuPanel extends JPanel implements Runnable
{

	private static final long serialVersionUID = -7343455852127981428L;
	//Button Panel
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
	//Theme
	MP3Player theme;
	//Thread
	private Thread thread;
	private boolean end;
	
	public MainMenuPanel(int panelWidth, int panelHeight)
	{
		background=new MainMenu("../img/main-menu.png");//placeholder for now
		//setting up Main Menu Panel
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		this.setDoubleBuffered(true);
		this.setBackground(Color.blue);
		this.setLayout(null);
		
		//set up theme music
		theme=new MP3Player();
		theme.load("../sound/air.mp3");
		
		//setting up user options
		
		playButton = new CustomButton(400, 420, 200, 35);
		playButton.setText("Play");
		playButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenuPanel.this.playClicked=true;
			}
		});
		this.add(playButton);
		
		howToPlayButton = new CustomButton(400, 465, 200, 35);
		howToPlayButton.setText("How to Play");
		howToPlayButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenuPanel.this.howClicked=true;
			}
		});
		this.add(howToPlayButton);
		
		highscoreButton = new CustomButton(400, 510, 200, 35);
		highscoreButton.setText("High Score");
		highscoreButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenuPanel.this.scoreClicked=true;
			}
		});
		this.add(highscoreButton);
		
		creditsButton = new CustomButton(400, 555, 200, 35);
		creditsButton.setText("Credits");
		creditsButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenuPanel.this.creditsClicked=true;
			}
		});
		this.add(creditsButton);
		
		end=false;
		thread= new Thread(this);
		
	}
	
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
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		
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
			theme.terminate();
			//theme=null;
			end=true;
		}
		
	
}



