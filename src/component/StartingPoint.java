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
			
			//Applet setup and add KeyBoard Listener
			this.setSize(appletWidth, appletHeight); // width, height
			this.setBackground(Color.BLACK); 
			this.setFocusable(true);
			kListener=new KeyboardListener();
			this.addKeyListener(kListener);
			
			//setting up component panels
			mainMenuPanel = new MainMenuPanel(appletWidth, appletHeight);
			storyPanel= new StoryPanel(appletWidth, appletHeight, kListener);
			
			
			//Start the thread
			Thread thread= new Thread(this);
			thread.start();
		}

		@Override
		public void run() 
		{
			//We start the game with main menu
			mainMenuPanel.start();
			this.add(mainMenuPanel);
			
			while (true)
			{
				//while in menu
				if(mainMenuPanel.getPlayClicked())
				{
					//Remove main menu from the applet
					mainMenuPanel.setPlayClicked(false);
					mainMenuPanel.end();
					this.remove(mainMenuPanel);
					//Add Story Panel to the applet
					storyPanel=null;
					storyPanel= new StoryPanel(appletWidth, appletHeight, kListener);
					storyPanel.start();
					this.add(storyPanel);			
				}	
				
				//while in a different screen
				if(storyPanel.getExit())
				{
					//do stuff
					storyPanel.end();
					this.remove(storyPanel);
					mainMenuPanel=null;
					mainMenuPanel = new MainMenuPanel(appletWidth, appletHeight);
					mainMenuPanel.start();
					this.add(mainMenuPanel);
				}
				
				//Validate to Paint the a new Panel
				this.validate();
				
				try 
				{
					Thread.sleep(60);
				} 
				catch (InterruptedException e) {}
			}
				
		}
}

