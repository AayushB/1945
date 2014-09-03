package component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CreditsPanel extends JPanel
{

	private static final long serialVersionUID = -714459676235419749L;
	private CustomButton exitButton;
	private boolean exitClicked=false;

	public CreditsPanel(int panelWidth, int panelHeight)
	{
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		exitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CreditsPanel.this.exitClicked=!(CreditsPanel.this.exitClicked);
			}
		});
		
		this.add(exitButton);
	}
	
	//Get if exit is clicked
		public boolean getExit()
		{
			return exitClicked;
		}
}
