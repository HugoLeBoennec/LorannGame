import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MenuListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
			case "New"							: New(); break;
			case "Load from file"				: LoadFile(); break;
			case "Load from BDD"				: LoadBDD(); break;
			case "Save in BDD"					: SaveBDD(); break;
			case "Delete from BDD"				: DeleteBDD(); break;
			case "Exit"							: Exit(); break;
			
			case "Air"							: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_AIR; break;
			case "Start point"					: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_START; break;
			case "Wall"							: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_WALL; break;
			case "Horizontal bone"				: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_HBONE; break;
			case "Vertical bone"				: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_VBONE; break;
			case "Money"						: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_MONEY; break;
			case "Key"							: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_KEY; break;
			case "Enemy - X:Bounce, Y:Bounce"	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONN; break;
			case "Enemy - X:Bounce, Y:Chase"	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONW; break;
			case "Enemy - X:Chase, Y:Bounce"	: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONS; break;
			case "Enemy - X:Chase, Y:Chase"		: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_DEMONE; break;
			case "Exit point"					: Main.elements[MsListener.clickX / 32][MsListener.clickY / 32] = Element.EL_EXIT; break;
			
			default								: break;
		}
	}
	
	// Efface le niveau en cours :
	static public void New()
	{
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 12; j++)
				Main.elements[i][j] = Element.EL_AIR;
		}
	}
	
	// Charge un niveau à partir d'un fichier :
	static public void LoadFile()
	{
		final BufferedReader buf;
		final JFileChooser fc = new JFileChooser();
		
		String line;
		
		if (fc.showOpenDialog(Main.frame) != JFileChooser.APPROVE_OPTION)
			return;
		
		// On efface le niveau précédent :
		New();
			
		try
		{
			buf = new BufferedReader(new InputStreamReader(new FileInputStream(fc.getSelectedFile())));
			
			for (int j = 0; j < 12; j++)
			{
				// Lecture de la ligne :
				line = buf.readLine();
					
		        if (line != null)
		        {
		        	// Ajout caractère par caractère :
			        for (int i = 0; i < line.toCharArray().length; i++)
			        {
			            switch (line.toCharArray()[i])
			            {
				            case 'd' : Main.elements[i][j] = Element.EL_START; break;
				            case 'r' : Main.elements[i][j] = Element.EL_WALL; break;
							case 'h' : Main.elements[i][j] = Element.EL_HBONE; break;
							case 'v' : Main.elements[i][j] = Element.EL_VBONE; break;
							case 'o' : Main.elements[i][j] = Element.EL_MONEY; break;
				            case 'b' : Main.elements[i][j] = Element.EL_KEY; break;
							case 'n' : Main.elements[i][j] = Element.EL_DEMONN; break;
							case 'w' : Main.elements[i][j] = Element.EL_DEMONW; break;
							case 's' : Main.elements[i][j] = Element.EL_DEMONS; break;
							case 'e' : Main.elements[i][j] = Element.EL_DEMONE; break;
							case 'p' : Main.elements[i][j] = Element.EL_EXIT; break;
							default : break;
			            }
		        	}
				}
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(Main.frame, e.getMessage(), "IO Exception", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Charge un niveau à partir de la base de donnée :
	static public void LoadBDD()
	{
		String s = (String)JOptionPane.showInputDialog(Main.frame, "Enter the level number :", "Level number", JOptionPane.PLAIN_MESSAGE, null, null, "1");
		
		if (s == null)
			return;
		
		// On efface le niveau précédent :
		New();
		
		int n = Math.max(1, Integer.parseInt(s));
		
		try
		{
			ResultSet res = Main.st.executeQuery("SELECT x, y, type FROM levels WHERE level = " + n);
			
			res.first();
			
			for (int i = 0; i < 20; i++)
			{
				for (int j = 0; j < 12; j++)
				{
					switch (res.getString(3).charAt(0))
	            	{
		            	case 'd' : Main.elements[i][j] = Element.EL_START; break;
		            	case 'r' : Main.elements[i][j] = Element.EL_WALL; break;
						case 'h' : Main.elements[i][j] = Element.EL_HBONE; break;
						case 'v' : Main.elements[i][j] = Element.EL_VBONE; break;
						case 'o' : Main.elements[i][j] = Element.EL_MONEY; break;
		            	case 'b' : Main.elements[i][j] = Element.EL_KEY; break;
						case 'n' : Main.elements[i][j] = Element.EL_DEMONN; break;
						case 'w' : Main.elements[i][j] = Element.EL_DEMONW; break;
						case 's' : Main.elements[i][j] = Element.EL_DEMONS; break;
						case 'e' : Main.elements[i][j] = Element.EL_DEMONE; break;
						case 'p' : Main.elements[i][j] = Element.EL_EXIT; break;
						default : break;
	            	}
					
					if (!res.next())
						return;
				}
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(Main.frame, e.getMessage(), "SQL Exception", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Sauvegarde un niveau dans la base de donnée :
	static public void SaveBDD()
	{
		String s = (String)JOptionPane.showInputDialog(Main.frame, "Enter the level number :", "Level number", JOptionPane.PLAIN_MESSAGE, null, null, "1");
			
		if (s == null)
			return;
			
		int n = Math.max(1, Integer.parseInt(s));
		char c;
			
		try
		{
			// Supprime le niveau précédent :
			Main.st.executeUpdate("DELETE FROM levels WHERE level = " + n);
			
			for (int i = 0; i < 20; i++)
			{
				for (int j = 0; j < 12; j++)
				{
					switch (Main.elements[i][j])
		            {
		            	case EL_START	: c = 'd'; break;
						case EL_WALL	: c = 'r'; break;
						case EL_HBONE	: c = 'h'; break;
						case EL_VBONE	: c = 'v'; break;
						case EL_MONEY	: c = 'o'; break;
						case EL_KEY		: c = 'b'; break;
						case EL_DEMONN	: c = 'n'; break;
						case EL_DEMONW	: c = 'w'; break;
						case EL_DEMONS	: c = 's'; break;
						case EL_DEMONE	: c = 'e'; break;
						case EL_EXIT	: c = 'p'; break;
						default			: c = 'a'; break;
		           	}
					
					Main.st.executeUpdate("INSERT INTO levels VALUES (" + i + ", " + j + ", " + n + ", \"" + c + "\");");
				}
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(Main.frame, e.getMessage(), "SQL Exception", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Supprime un niveau dans la base de donnée :
	static public void DeleteBDD()
	{
		String s = (String)JOptionPane.showInputDialog(Main.frame, "Enter the level number :", "Level number", JOptionPane.PLAIN_MESSAGE, null, null, "1");
				
		if (s == null)
			return;
				
		int n = Math.max(1, Integer.parseInt(s));
		
		if (JOptionPane.showConfirmDialog(Main.frame, "Do you really want to delete the level " + n + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
			return;
		
		try
		{
			Main.st.executeUpdate("DELETE FROM levels WHERE level = " + n);
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(Main.frame, e.getMessage(), "SQL Exception", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Ferme la fenêtre :
	static public void Exit()
	{
		Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
	}
}
