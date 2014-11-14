package component;

import java.awt.event.KeyListener;

public interface MyKeyControls extends KeyListener
{
	public boolean leftPressed();
	public boolean rightPressed();
	public boolean upPressed();
	public boolean downPressed();
	public boolean spacePressed();
	public boolean pPressed();

}
