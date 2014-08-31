package component;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import soundFactory.SoundClip;
public class ButtonPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3579765191490746123L;
	private Color backgroundColor=new Color(19,32,48);
	private SoundClip hover;
	private SoundClip click;
	private boolean clicked;//once=clicked, twice=unclicked

	public ButtonPanel(int x, int y, int width, int height)
	{
		setBounds(x, y, width, height);
		setCursor(new Cursor(12)); //hand cursor
		setBackground(backgroundColor);
		hover=new SoundClip("../sound/menu-hover.wav");
		click=new SoundClip("../sound/click.wav");
		clicked=false;
		addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				clicked=!clicked;
				click.play();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				ButtonPanel.this.setBackground(new Color(39,62,68));
				ButtonPanel.this.hover.play();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				ButtonPanel.this.setBackground(backgroundColor);
			}
		});
	}
	
	//Getter for button clicked, once= clicked, twice= unclicked
	public boolean getClicked()
	{
		return clicked;
	}
	
	public void setClicked(boolean clicked)
	{
		this.clicked=clicked;
	}
	
	@Override
	public void paint(Graphics page)
	{
		super.paint(page);
		//this.setBackground(Color.red);
		//System.out.println("repainting");
	}
}
