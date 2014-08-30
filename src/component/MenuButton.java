package component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButton extends JButton 
{
	private static final long serialVersionUID = 4781159408264147811L;
	private Color background;
	private Color hoverBackground;
	private Color currentBackground;
	private Color foreground;
	private Color hoverForeground;
	private Font  font;
	
	public MenuButton(int x, int y, int width, int height)
	{
		super();
		setBounds(x, y, width, height);
		this.setBorder(null);
		setBorderPainted(false);
		setOpaque(true);
		setContentAreaFilled(false);
		this.setFocusPainted(false);

		//default color and font
		background=new Color(0,0,0, 50);
		currentBackground=background;
		hoverBackground= new Color(255,255,255,155);
		foreground=new Color(200,255,255);
		hoverForeground=new Color(0,0,0);
		font= new Font("Haettenschweiler", Font.PLAIN, 30);
		//Apply the effects
		this.setBackground(background);
		this.setForeground(foreground);
		this.setFont(font);
		//Add mouse listener
		this.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent evt) 
			{
				currentBackground=hoverBackground;
		        MenuButton.this.setForeground(hoverForeground);
		    }
		    public void mouseExited(MouseEvent evt) 
		    {
		    	currentBackground=background;
		    	 MenuButton.this.setForeground(foreground);
		    }
		});	
		this.setFocusable(true);
	}
	
	public void draw(Graphics page)
	{
		page.setColor(currentBackground);
		page.fillRoundRect(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 25, 25);
	}
	
	public void setBackgroundColor(Color background)
	{
		this.background=background;
	}
	
	public void setHoverBackground(Color hoverBackground)
	{
		this.hoverBackground=hoverBackground;
	}
	
	public void setForegroundColor(Color foreground)
	{
		this.foreground=background;
	}
	
	public void setHoverForeground(Color hoverForeground)
	{
		this.hoverForeground=hoverForeground;
	}
	
	public void setFont(String font, int style, int size)
	{
		this.font=new Font(font, style, size);
	}	
}
