package component;
import java.applet.*;
import java.awt.*;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class StartingPoint extends Applet
{
	private static final long serialVersionUID = 1729212401853792501L;
	
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
			int appletWidth=1000;
			int appletHeight=616;
			//setting up story panel
			
			//StoryPanel storyPanel= new StoryPanel(appletWidth, appletHeight);
			MainMenuPanel mainMenuPanel = new MainMenuPanel(appletWidth, appletHeight);
			
			//Applet setup and component adding
			this.setSize(appletWidth, appletHeight); // width, height
			this.setBackground(Color.BLACK); 
			//this.add(storyPanel);
			//storyPanel.end();
			//this.remove(storyPanel);
			this.add(mainMenuPanel);
			}
}
