package component;
import java.applet.*;
import java.awt.*;

public class StartingPoint extends Applet
{
	private static final long serialVersionUID = 1729212401853792501L;
	//Initialize the Applet
		@Override
		public void init() 
		{
			//setting up height and width 
			int appletWidth=1000;
			int appletHeight=616;
			int storyPanelWidth=appletWidth;
			int storyPanelHeight=appletHeight;
			//setting up story panel
			
			StoryPanel storyPanel= new StoryPanel(storyPanelWidth, storyPanelHeight);
			
			//Applet setup and component adding
			this.setSize(appletWidth, appletHeight); // width, height
			this.setBackground(Color.BLACK); 
			this.add(storyPanel);
			}
}
