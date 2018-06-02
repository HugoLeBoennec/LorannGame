import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MsListener implements MouseListener, MouseMotionListener
{
	// Position de la souris :
	static public int mouseX = 0;
	static public int mouseY = 0;
	
	// Position du clic :
	static public int clickX = -32;
	static public int clickY = -32;

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		final Element el;
		final int currentX = Math.round((e.getX() - 19) / 32.0f) * 32;
		final int currentY = Math.round((e.getY() - 70) / 32.0f) * 32;
		
		// Si on clique sur un objet déjà séléctionné, on change son contenu :
		if (currentX == clickX && currentY == clickY)
		{
			el = Main.elements[MsListener.clickX / 32][MsListener.clickY / 32];
			
			if (e.getButton() == MouseEvent.BUTTON3)
			{
				switch (el)
				{
					case EL_AIR		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_EXIT; break;
					case EL_START	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_AIR; break;
					case EL_WALL	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_START; break;
					case EL_HBONE	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_WALL; break;
					case EL_VBONE	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_HBONE; break;
					case EL_MONEY	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_VBONE; break;
					case EL_KEY		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_MONEY; break;
					case EL_DEMONN	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_KEY; break;
					case EL_DEMONW	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONN; break;
					case EL_DEMONS	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONW; break;
					case EL_DEMONE	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONS; break;
					case EL_EXIT	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONE; break;
				}
			}
			else
			{
				switch (el)
				{
					case EL_AIR		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_START; break;
					case EL_START	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_WALL; break;
					case EL_WALL	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_HBONE; break;
					case EL_HBONE	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_VBONE; break;
					case EL_VBONE	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_MONEY; break;
					case EL_MONEY	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_KEY; break;
					case EL_KEY		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONN; break;
					case EL_DEMONN	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONW; break;
					case EL_DEMONW	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONS; break;
					case EL_DEMONS	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONE; break;
					case EL_DEMONE	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_EXIT; break;
					case EL_EXIT	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_AIR; break;
				}
			}
		}
		else
		{
			clickX = currentX;
			clickY = currentY;
		}
		
		// On redessine la fenêtre :
		Main.frame.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		
		// On redessine la fenêtre :
		Main.frame.repaint();
	}
}
