package component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class HelpPanel extends JPanel
{

	private static final long serialVersionUID = -714459676235419749L;
	private CustomButton exitButton;
	private boolean exitClicked=false;

	public HelpPanel(int panelWidth, int panelHeight)
	{
		this.setBackground(Color.green);
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		this.setLayout(null);
		
		exitButton = new CustomButton(574,17,96,62);
		exitButton.setText("Exit Image");
		
		exitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				HelpPanel.this.exitClicked=!(HelpPanel.this.exitClicked);
			}
		});
		
		this.add(exitButton);
	}
	
	//Get if exit is clicked
		public boolean getExit()
		{
			return exitClicked;
		}

		public void end() 
		{
			// TODO Auto-generated method stub
			exitClicked=false;
			
		}
}
