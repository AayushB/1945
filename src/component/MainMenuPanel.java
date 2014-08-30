package component;

import java.awt.*;

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
		//playButton.addActionListener(l);
		this.add(playButton);
		
		howToPlayButton = new MenuButton(400, 330, 200, 70);
		howToPlayButton.setText("How to Play");
		this.add(howToPlayButton);
		
		highscoreButton = new MenuButton(400, 410, 200, 70);
		highscoreButton.setText("High Score");
		this.add(highscoreButton);
		
		creditsButton = new MenuButton(400, 490, 200, 70);
		creditsButton.setText("Credits");
		this.add(creditsButton);
		
		Thread thread= new Thread(this);
		thread.start();
		
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
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			try 
			{
				Thread.sleep(60);
			} 
			catch (InterruptedException e) {}
			
			repaint();
		}
		
	}
	
}



