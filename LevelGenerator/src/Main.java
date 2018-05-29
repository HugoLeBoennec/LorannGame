import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public abstract class Main
{
	static String URL		= "jdbc:mysql://localhost/lorann?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String USER		= "root";
	static String PASSWORD	= "";
	
	static String FICHIER	= "map.txt";
	
	static int LEVEL		= 1;
	
	public static void main(String[] args)
	{
		final BufferedReader buf;	// Buffer de lecture
		
		Connection cn;				// Connection à la base
		Statement st;				// Statement qui permet l'exécution de requêtes
		
		String line;				// La ligne lue en cours
		
		try
		{
			// Initialisation du driver :
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Mise en place de la connexion :
			cn = DriverManager.getConnection(URL, USER, PASSWORD);
			st = cn.createStatement();
			
			// Ouverture du fichier :
			buf = new BufferedReader(new InputStreamReader(new FileInputStream(FICHIER)));
			
			for (int y = 0; y < 12; y++)
			{
				line = buf.readLine();	// Lecture de la ligne
	        	
	        	if (line != null)
	        	{
	        		// Ajout caractère par caractère :
		            for (int x = 0; x < line.toCharArray().length; x++)
		            	st.executeUpdate("INSERT INTO levels VALUES (" + x + ", " + y + ", " + LEVEL + ", \"" + line.toCharArray()[x] + "\");");
	        	}
			}
			
			// Fermeture de la connexion :
			st.close();
			cn.close();
		}
		catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		catch (ClassNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
		catch (FileNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
