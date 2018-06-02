import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	// Serial...
	private static final long serialVersionUID = -1088791985604822702L;
	
	public void paintComponent(final Graphics g)
	{
		int t;
		
		// Dessin des éléments :
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 12; j++)
			{
				switch (Main.elements[i][j])
				{
					case EL_START	: g.drawImage(Main.imgStart, i * 32, j * 32, null); break;
					case EL_WALL	: g.drawImage(Main.imgWall, i * 32, j * 32, null); break;
					case EL_HBONE	: g.drawImage(Main.imgHBone, i * 32, j * 32, null); break;
					case EL_VBONE	: g.drawImage(Main.imgVBone, i * 32, j * 32, null); break;
					case EL_MONEY	: g.drawImage(Main.imgMoney, i * 32, j * 32, null); break;
					case EL_KEY		: g.drawImage(Main.imgKey, i * 32, j * 32, null); break;
					case EL_DEMONN	: g.drawImage(Main.imgDemonn, i * 32, j * 32, null); break;
					case EL_DEMONW	: g.drawImage(Main.imgDemonw, i * 32, j * 32, null); break;
					case EL_DEMONS	: g.drawImage(Main.imgDemons, i * 32, j * 32, null); break;
					case EL_DEMONE	: g.drawImage(Main.imgDemone, i * 32, j * 32, null); break;
					case EL_EXIT	: g.drawImage(Main.imgExit, i * 32, j * 32, null); break;
					default			: break;
				}
			}
		}
		
		// Dessin de la grille :
		g.setColor(Color.WHITE);
				
		for (int i = 0; i < 19; i++)
		{
			t = i * 32 + 32;
			g.drawLine(t, 0, t, 384);
		}
				
		for (int i = 0; i < 11; i++)
		{
			t = i * 32 + 32;
			g.drawLine(0, t, 640, t);
		}
		
		// Dessin du rectangle de séléction :
		g.setColor(new Color(255, 160, 0, 64));
		g.fillRect(Math.round((MsListener.mouseX - 19) / 32.0f) * 32, Math.round((MsListener.mouseY - 70) / 32.0f) * 32, 32, 32);
		
		// Dessin du rectangle de clic :
		g.setColor(new Color(255, 64, 0, 130));
		g.fillRect(MsListener.clickX, MsListener.clickY, 32, 32);
	}
}
