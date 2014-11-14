package component;

import characterImage.*;
import gameObjects.*;
import background.*;
import properties.*;
import CollisionEngine.*;
import javax.swing.*;
import java.awt.*;

public class GamePlayPanel extends JPanel implements Runnable
{
	private static final long serialVersionUID = -665006501171953584L;
	//Defining FPS for the screen
	private static final int DELAY = 15;
	//Listens to Keyboard
	//Defined Game Screen
	ScreenDimension scr;
	//Pause-Play feature of the game
	private  boolean pause;
	//-------------------------Screen Visible Contents----------//
	private Ocean ocean;
	private OceanGradient oceanGradient;
	private Player player1;
	private Player player2;
	//---------------------------------------------------------//
	
	CollisionEngine collisionEngine;
	
	//Thread
	private Thread thread;
	private boolean end;
		
	public GamePlayPanel(int x, int y, int width, int height, KeyboardListenerA kListenerA, KeyboardListenerB kListenerB)
	{
		//setting up screenDimension
		scr=new ScreenDimension(0,0,width,height);
		//setting up GamePlayPanel
		setBounds(x, y, width, height);
		setDoubleBuffered(true);
		//setting up keyboard listener
		this.addKeyListener(kListenerA);
		this.addKeyListener(kListenerB);
		//pause feature
		pause=false;
		//Setting up screen contents
		int initX=662;//initial X Location of the plane
		int initY=370;//initial Y location of the plane
		player1=new Player(initX,initY,(BigAirplaneImage) CharacterImage.image.get("BigOrangeAirplane"),
				(BigAirplaneImage) CharacterImage.image.get("BigOrangeAirplaneShadow"),(MyKeyControls) kListenerA, scr);
		player1.setVelocity(3); // setting up player1 speed
		//player1.setBorderVisibility(true);
		
		
		//Setting up screen contents
		initX=262;//initial X Location of the plane
		initY=370;//initial Y location of the plane
		player2=new Player(initX,initY,(BigAirplaneImage) CharacterImage.image.get("BigGreenAirplane"),
				(BigAirplaneImage) CharacterImage.image.get("BigGreenAirplaneShadow"),(MyKeyControls) kListenerB, scr);
		player2.setVelocity(3); // setting up player1 speed
		//player1.setBorderVisibility(true);
		
		collisionEngine= new CollisionEngine();
		collisionEngine.add(player1);

		oceanGradient= new OceanGradient("../img/ocean-gradient.png");
		ocean= new Ocean();
		ocean.setVelocity(1);// How fast the ocean moves
		
		//Lets set up our thread and run it 
		// The this here refers to the run() method as our JPanel implements Runnable
		//This will automatically start the run() method
		end=false;
		thread= new Thread(this);
	}
	
	@Override
	public void run() 
	{
		while (!end)
		{
			//-------------------------------------------------------
			//						Updates
			//-------------------------------------------------------
			if(!pause) // if not pause update
			{
				updateScreen();
			}
			//-------------------------------------------------------
			//-------------------------------------------------------
			
			repaint(); //Calls the paint method and displays updated data accordingly
			try 
			{
				Thread.sleep(DELAY);
			} 
			catch (InterruptedException e) {}
		}
	}
	private void updateScreen()
	{
		//Updating Screen Contents
		ocean.update();
		player1.update();
		player2.update();
	}	
	@Override
	public void paint(Graphics page)
	{
		super.paint(page); //Displaying the default background (avoid flickering)
		//Drawing Screen Contents
		oceanGradient.drawImage(page, 0, 0);
		ocean.draw(page);
		player1.drawShadow(page);
		player2.drawShadow(page);
		player1.draw(page);
		player2.draw(page);
		drawPauseScreen(page);
	}
	
	
	//Getter and Setter for pause
	public boolean getPause()
	{
		return pause;
	}
	
	public void setPause(boolean pause)
	{
		this.pause=pause;
	}
	
	//Draws Pause Screen on the game screen
	private void drawPauseScreen(Graphics page)
	{
		if(pause)
		{
			//Screen Fade out
			page.setColor(new Color(0,0,0,150));
			page.fillRect(0,0,this.getWidth(), this.getHeight());
			//Middle Box
			page.setColor(new Color(255,255,255,40));
			page.fillRoundRect(160, 50, 670, 325,25,25);
			//Pause Sign
			page.setColor(new Color(255,255,255));
			page.fillRect(485, 200, 10, 30);
			page.fillRect(505, 200, 10, 30);
		}
	}
	
	//Start
	public void start()
	{
		end=false;
		thread.start();
	}
	
	//safely ends process of run in the Story Panel
	public void end()
	{
		end=true;
	}

}
