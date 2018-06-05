import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.sql.SQLException;

public abstract class Main
{
	// Sprites :
	static public Image imgStart;
	static public Image imgWall;
	static public Image imgHBone;
	static public Image imgVBone;
	static public Image imgMoney;
	static public Image imgKey;
	static public Image imgDemonn;
	static public Image imgDemonw;
	static public Image imgDemons;
	static public Image imgDemone;
	static public Image imgExit;
	
	static public Frame frame;			// La fenêtre principale
	
	static public Connection cn;		// Connection à la base
	static public Statement st;			// Statement qui permet l'exécution de requêtes
	
	static public Element elements[][];	// La matrice constituant le niveau
	
	public static void main(String[] args)
	{
		try
		{
			// Initialisation du driver :
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Mise en place de la connexion :
			String s = (String)JOptionPane.showInputDialog(Main.frame, "Enter the database IP :", "Database IP", JOptionPane.PLAIN_MESSAGE, null, null, "192.168.0.14");
			
			if (s == null)
				return;
			
			cn = DriverManager.getConnection("jdbc:mysql://" + s + "/lorann?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			st = cn.createStatement();
			
			// Chargement des sprites :
			imgStart	= ImageIO.read(new File("sprites/lorann_b.png"));
			imgWall		= ImageIO.read(new File("sprites/bone.png"));
			imgHBone	= ImageIO.read(new File("sprites/horizontal_bone.png"));
			imgVBone	= ImageIO.read(new File("sprites/vertical_bone.png"));
			imgMoney	= ImageIO.read(new File("sprites/purse.png"));
			imgKey		= ImageIO.read(new File("sprites/crystal_ball.png"));
			imgDemonn	= ImageIO.read(new File("sprites/monster_1.png"));
			imgDemonw	= ImageIO.read(new File("sprites/monster_2.png"));
			imgDemone	= ImageIO.read(new File("sprites/monster_3.png"));
			imgDemons	= ImageIO.read(new File("sprites/monster_4.png"));
			imgExit		= ImageIO.read(new File("sprites/gate_closed.png"));
			
			// Création de la fenêtre :
			frame = new Frame();
			
			// Chargement d'un niveau vide :
			elements = new Element[20][12];
			
			for (int i = 0; i < 20; i++)
			{
				for (int j = 0; j < 12; j++)
					elements[i][j] = Element.EL_AIR;
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(frame, e.getMessage(), "SQL Exception", JOptionPane.ERROR_MESSAGE);
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Class not found Exception", JOptionPane.ERROR_MESSAGE);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(frame, e.getMessage(), "IO Exception", JOptionPane.ERROR_MESSAGE);
		}
	}
}
