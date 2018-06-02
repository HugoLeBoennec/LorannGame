import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KListener implements KeyListener
{
	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (MsListener.clickX >= 0 && MsListener.clickX <= 608 && MsListener.clickY >= 0 && MsListener.clickY <= 352)
		{
			// Change le carreau séléctionné :
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_A		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_AIR; break;
				case KeyEvent.VK_D		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_START; break;
				case KeyEvent.VK_R		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_WALL; break;
				case KeyEvent.VK_H		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_HBONE; break;
				case KeyEvent.VK_V		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_VBONE; break;
				case KeyEvent.VK_O		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_MONEY; break;
				case KeyEvent.VK_B		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_KEY; break;
				case KeyEvent.VK_N		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONN; break;
				case KeyEvent.VK_W		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONW; break;
				case KeyEvent.VK_S		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONS; break;
				case KeyEvent.VK_E		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONE; break;
				case KeyEvent.VK_P		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_EXIT; break;
				case KeyEvent.VK_DELETE	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_AIR; break;
				default : break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
}
