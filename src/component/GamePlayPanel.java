package component;
//import gameObjects.BattleShip;
import gameObjects.BattleShip;
import gameObjects.Player;
import gameObjects.RedWhitePlane;

import javax.swing.*;

import properties.ScreenDimension;
import characterImage.BattleShipImage;
//import characterImage.BattleShipImage;
import characterImage.BigOrangeAirplane;
import characterImage.RedWhitePlaneImage;
import CollisionEngine.CollisionEngine;
import background.Ocean;
import background.OceanGradient;
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
	private BattleShip ship;
	private RedWhitePlane plane;
	//---------------------------------------------------------//
	
	CollisionEngine collisionEngine;
	
	//Thread
	private Thread thread;
	private boolean end;
		
	public GamePlayPanel(int x, int y, int width, int height, KeyboardListener kListener)
	{
		//setting up screenDimension
		scr=new ScreenDimension(0,0,width,height);
		
		//setting up GamePlayPanel

		setBounds(x, y, width, height);
		setDoubleBuffered(true);
		
		//setting up keyboard listener
		this.addKeyListener(kListener);
		
		//pause feature
		pause=false;
		
		//Setting up screen contents
		int initX=462;//initial X Location of the plane
		int initY=370;//initial Y location of the plane
		player1= new Player(initX,initY,new BigOrangeAirplane("../img/spritesheet.png")
		 , new BigOrangeAirplane("../img/spritesheet-shadow.png"), kListener, scr);
		player1.setVelocity(3); // setting up player1 speed
		//player1.setBorderVisibility(true);
		
    	ship= new BattleShip(500,-200, new BattleShipImage("../img/spritesheet.png"),
								  new BattleShipImage("../img/spritesheet-shadow.png"));
    	ship.setVelocity(1);
		plane= new RedWhitePlane(500,-200, new RedWhitePlaneImage("../img/spritesheet.png"),
				  new RedWhitePlaneImage("../img/spritesheet-shadow.png"));
		plane.setVelocity(3);
		
		//c= new CObject(200,0, new BigOrangeAirplane("../img/spritesheet.png"));
		//ship.setBorderVisibility(true);
		
		//collisionEngine= new CollisionEngine();
		//collisionEngine.add(player1);
		//collisionEngine.add(c);
		
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
		ship.update();
		plane.update();
		//c.update();
	}	
	@Override
	public void paint(Graphics page)
	{
		super.paint(page); //Displaying the default background (avoid flickering)
		//Drawing Screen Contents
		oceanGradient.drawImage(page, 0, 0);
		ocean.draw(page);
		ship.drawShadow(page);
		ship.draw(page);
		plane.drawShadow(page);
		plane.draw(page);
		
		player1.drawShadow(page);
		player1.draw(page);
		//c.draw(page);
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
