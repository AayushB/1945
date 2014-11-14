package component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListenerA implements KeyListener, MyKeyControls
{
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean upPressed;
	private boolean downPressed;
	private boolean spacePressed;
	private boolean pPressed;
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_DOWN:	
			{ 
				downPressed=true;
			}
			break;
			
			case KeyEvent.VK_UP:	
			{ 
				upPressed=true;
			}
			break;
			
			case KeyEvent.VK_RIGHT:	
			{ 
				rightPressed=true;
			}
			break;
			
			case KeyEvent.VK_LEFT:	
			{ 
				leftPressed=true;
			}
			break;
			
			case KeyEvent.VK_SPACE:
			{
				spacePressed=true;
			}
			break;
			
			case KeyEvent.VK_P:
			{
				pPressed=!pPressed;
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_DOWN:	
			{ 
				downPressed=false;
			}
			break;
		
			case KeyEvent.VK_UP:	
			{ 
				upPressed=false;
			}
			break;
			
			case KeyEvent.VK_RIGHT:	
			{ 
				rightPressed=false;
			}
			break;
		
			case KeyEvent.VK_LEFT:	
			{ 
				leftPressed=false;
			}
			break;
		
			case KeyEvent.VK_SPACE:
			{
				spacePressed=false;
			}
			break;
			
		}
	}
	
	public boolean leftPressed()
	{
		return leftPressed;
	}
	public boolean rightPressed()
	{
		return rightPressed;
	}
	public boolean upPressed()
	{
		return upPressed;
	}
	public boolean downPressed()
	{
		return downPressed;
	}
	public boolean spacePressed()
	{
		return spacePressed;
	}
	public boolean pPressed()
	{
		return pPressed;
	}
}
