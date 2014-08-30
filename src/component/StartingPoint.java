package component;
import java.applet.*;
import java.awt.*;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class StartingPoint extends Applet implements Runnable
{
	private static final long serialVersionUID = 1729212401853792501L;
	private MainMenuPanel mainMenuPanel;
	private StoryPanel storyPanel;
	private int appletWidth;
	private int appletHeight;
	private KeyboardListener kListener;
	
	//Initialize the Applet
		@Override
		public void init() 
		{
			
			//Platform independence for swing
		    try 
		    {
				UIManager.setLookAndFeel(
				        UIManager.getCrossPlatformLookAndFeelClassName());
			} 
		    catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) 
		    {
				e.printStackTrace();
			}

			//setting up height and width 
			appletWidth=1000;
			appletHeight=616;
			
			//Applet setup and component adding
			this.setSize(appletWidth, appletHeight); // width, height
			this.setBackground(Color.BLACK); 
			this.setFocusable(true);
			kListener=new KeyboardListener();
			this.addKeyListener(kListener);
			
			//setting up component panels
			mainMenuPanel = new MainMenuPanel(appletWidth, appletHeight);
			storyPanel= new StoryPanel(appletWidth, appletHeight, kListener);
			
			Thread thread= new Thread(this);
			thread.start();
		}

		@Override
		public void run() 
		{
			mainMenuPanel.start();
			this.add(mainMenuPanel);
			
			while (true)
			{
				//while in menu
				if(mainMenuPanel.getPlayClicked())
				{
					 //System.out.println("Here");
					mainMenuPanel.setPlayClicked(false);
					mainMenuPanel.end();
					this.remove(mainMenuPanel);
					//mainMenuPanel=null;
					this.setFocusable(true);
					
					
					storyPanel.start();
					this.add(storyPanel);
					this.validate();			
				}
				//while in a different screen
				try 
				{
					Thread.sleep(10);
				} 
				catch (InterruptedException e) {}
			}
				
				
				
				
				//
				
			}

		
}

