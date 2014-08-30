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
			
			//setting up component panels
			mainMenuPanel = new MainMenuPanel(appletWidth, appletHeight);
			storyPanel= new StoryPanel(appletWidth, appletHeight);
			
			Thread thread= new Thread(this);
			thread.start();
		}

		@Override
		public void run() 
		{
			 //this.add(storyPanel);
			//storyPanel.start();
			//storyPanel.invalidate();
			//this.removeAll();
			//mainMenuPanel=null;
			//this.add(storyPanel);
				
		}
		
	}

