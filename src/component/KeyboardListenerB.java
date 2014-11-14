package component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListenerB implements KeyListener, MyKeyControls 
{
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean upPressed;
	private boolean downPressed;
	
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
			case KeyEvent.VK_S:	
			{ 
				downPressed=true;
			}
			break;
			
			case KeyEvent.VK_W:	
			{ 
				upPressed=true;
			}
			break;
			
			case KeyEvent.VK_D:	
			{ 
				rightPressed=true;
			}
			break;
			
			case KeyEvent.VK_A:	
			{ 
				leftPressed=true;
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
			case KeyEvent.VK_S:	
			{ 
				downPressed=false;
			}
			break;
		
			case KeyEvent.VK_W:	
			{ 
				upPressed=false;
			}
			break;
			
			case KeyEvent.VK_D:	
			{ 
				rightPressed=false;
			}
			break;
		
			case KeyEvent.VK_A:	
			{ 
				leftPressed=false;
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

	@Override
	public boolean spacePressed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pPressed() {
		// TODO Auto-generated method stub
		return false;
	}
}
