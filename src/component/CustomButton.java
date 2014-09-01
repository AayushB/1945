package component;
/*******************************************************************************
* Extends the JButton Class and provides a framework and supports the following:
* Hover Background and foreground 
* Hover and click sound
* Background and Hover Image
* Font name, style and size
******************************************************************/
import imageFactory.*;
import javax.swing.*;
import soundFactory.*;
import java.awt.*;
import java.awt.event.*;

public class CustomButton extends JButton 
{
	private static final long serialVersionUID = 4781159408264147811L;
	//Background Color
	private Color backgroundColor;
	private Color hoverBackgroundColor;
	//Foreground Color
	private Color foregroundColor;
	private Color hoverForegroundColor;
	//Font
	private Font font;
	//Hover and Click Sound
	private SoundClip hoverSound;
	private SoundClip clickSound;
	//Buffered Image and Graphics
	private DrawableImage backgroundImage;
	private DrawableImage hoverImage;
	//Status of hover
	private boolean hover;
	
	public CustomButton(int x, int y, int width, int height)
	{
		//Construct the button
		super();
		setBounds(x, y, width, height);
		//Set all the visibility to false, besides the text
		this.setBorder(null);
		setBorderPainted(false);
		setOpaque(true);
		setContentAreaFilled(false);
		this.setFocusPainted(false);
		//Set hover to false
		hover=false;
		
		//default color
		backgroundColor=Color.black;
		hoverBackgroundColor=Color.white;
		foregroundColor=Color.white;
		hoverForegroundColor=Color.black;

		/*****************************************************************
		 * Add Mouse Listener to play sounds, change hover status,
		 * foreground Color and cursor
		 *****************************************************************/
		this.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent evt) 
			{
				CustomButton.this.setForeground(hoverForegroundColor);
				//Sets the cursor to hand cursor
				CustomButton.this.setCursor(new Cursor(12));
				//only play if the sound is not null
				if(hoverSound!=null)
				{
					hoverSound.play();
				}
				CustomButton.this.hover=true;
		    }
			
		    public void mouseExited(MouseEvent evt) 
		    {
		    	CustomButton.this.setForeground(foregroundColor);
		    	CustomButton.this.hover=false; 	
		    }
		    
		    public void mouseClicked(MouseEvent evt)
		    {
		    	//only play if the sound is not null
		    	if(clickSound!=null)
		    	{
		    		clickSound.play();
		    	}
		    }
		});	
		/*****************************************************************/
	}
	
	/*****************************************************************
	 * Draw Image, background and Shape of the button
	 *****************************************************************/
	public void draw(Graphics page)
	{
		if (hover) //Draw Hovered Parts
		{
			page.setColor(hoverBackgroundColor);
			page.fillRoundRect(this.getX(), this.getY(), this.getWidth(), 
							   this.getHeight(), 25, 25);
			page.fillRoundRect(this.getX()+2, this.getY()-2, 
							   this.getWidth(), this.getHeight(), 25, 25);
			//only draw if the image is not null
			if(hoverImage!=null)
			{
				hoverImage.drawImage(page, this.getX(), this.getY());
			}
		}
		else // Draw Non Hovered Parts
		{
			page.setColor(backgroundColor);
			page.fillRoundRect(this.getX(), this.getY(), this.getWidth(), 
					   this.getHeight(), 25, 25);
			page.fillRoundRect(this.getX()+2, this.getY()-2, 
					   this.getWidth(), this.getHeight(), 25, 25);
			//only draw if the image is not null
			if(backgroundImage!=null)
			{
				backgroundImage.drawImage(page, this.getX(), this.getY());
			}
		}
	}

	/*****************************************************************/
	
	
	/*****************************************************************
	 * Getters and Setters for all the private data members
	 *****************************************************************/
	
	public Color getBackgroundColor() 
	{
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) 
	{
		this.backgroundColor = backgroundColor;
	}

	public Color getHoverBackgroundColor() 
	{
		return hoverBackgroundColor;
	}

	public void setHoverBackgroundColor(Color hoverBackgroundColor) 
	{
		this.hoverBackgroundColor = hoverBackgroundColor;
	}

	public Color getForegroundColor() 
	{
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor)
	{
		this.foregroundColor = foregroundColor;
	}

	public Color getHoverForegroundColor()
	{
		return hoverForegroundColor;
	}

	public void setHoverForegroundColor(Color hoverForegroundColor) 
	{
		this.hoverForegroundColor = hoverForegroundColor;
	}

	public Font getFont()
	{
		return font;
	}
	
	//Uses font name, style and size to change the font
	public void setFont(String fontName, int style, int size)
	{
		font= new Font(fontName, style, size);
		this.setFont(font);
	}
	
	public DrawableImage getBackgroundImage() 
	{
		return backgroundImage;
	}

	//Changes the background Image to the URL Image
	public void setBackgroundImage(String imageURL) 
	{
		this.backgroundImage= new DrawableImage(imageURL);
	}

	public DrawableImage getHoverImage() 
	{
		return hoverImage;
	}

	//Changes the Hover Background Image to the URL Image
	public void setHoverImage(String imageURL)
	{
		this.hoverImage= new DrawableImage(imageURL);
	}
	
	/*****************************************************************/
}
