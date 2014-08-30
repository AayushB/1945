package component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import background.MainMenu;

public class MainMenuPanel extends JPanel implements Runnable
{

	private static final long serialVersionUID = -7343455852127981428L;
	//Button Panel
	private MenuButton playButton;
	private MenuButton howToPlayButton;
	private MenuButton highscoreButton;
	private MenuButton creditsButton;	
	private MainMenu background;
	//Button clicked
	private boolean playClicked=false;
	private boolean howClicked=false;
	private boolean scoreClicked=false;
	private boolean creditsClicked=false;
	//Thread
	private Thread thread;
	private boolean end;
	
	public MainMenuPanel(int panelWidth, int panelHeight)
	{
		background=new MainMenu("../img/sky.jpg");//placeholder for now
		//setting up Main Menu Panel
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		this.setDoubleBuffered(true);
		this.setBackground(Color.blue);
		this.setLayout(null);
		
		//setting up user options
		
		playButton = new MenuButton(400, 250, 200, 70);
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
		
		howToPlayButton = new MenuButton(400, 330, 200, 70);
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
		
		highscoreButton = new MenuButton(400, 410, 200, 70);
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
		
		creditsButton = new MenuButton(400, 490, 200, 70);
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
				Thread.sleep(1);
			} 
			catch (InterruptedException e) {}
			
			repaint();
		}
		
	}
	
	//Starts the thread, and all other threads in the class
		public void start()
		{
			end=false;
			thread.start();
			this.validate();
		}
		
		//safely ends process of run in the Story Panel
		public void end()
		{
			end=true;
		}
		
	
}



