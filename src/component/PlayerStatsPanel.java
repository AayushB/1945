package component;

import java.awt.Color;

import javax.swing.JPanel;

public class PlayerStatsPanel extends JPanel {

	
	private static final long serialVersionUID = -1405872621927232312L;
	private Color backgroundColor=new Color(0,0,0);


	public PlayerStatsPanel(int x, int y, int width, int height)
	{
		setBounds(x, y, width, height);
		setBackground(backgroundColor);
	}
	
}
