import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Frame extends JFrame implements WindowListener
{
	// Serial...
	private static final long serialVersionUID = 7093664450894032397L;
	
	private Panel panel;				// Le panneau dans lequel dessiner
	private JMenuBar menuBar;			// La barre de menu
	
	private MenuListener menuListener;	// L'écouteur du menu
	private MsListener msListener;		// L'écouteur de la souris
	private KListener kListener;		// L'écouteur du clavier
	
	public Frame()
	{
		super();
		
		this.panel = new Panel();
		
		this.menuListener = new MenuListener();
		this.msListener = new MsListener();
		this.kListener = new KListener();
		
		// Création du menu :
		JMenu menu;		// Le menu
		JMenuItem menuItem;		// L'objet du menu
		
		this.menuBar = new JMenuBar();

		// Menu "file" :
		menu = new JMenu("File");
		this.menuBar.add(menu);
		
		menuItem = new JMenuItem("New");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Load from file");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Load from BDD");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Save in BDD");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Delete from BDD");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Exit");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		
		// Menu "element" :
		menu = new JMenu("Element");
		this.menuBar.add(menu);
				
		menuItem = new JMenuItem("Air");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Start point");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Wall");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Horizontal bone");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Vertical bone");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Money");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Key");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Enemy - X:Bounce, Y:Bounce");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Enemy - X:Bounce, Y:Chase");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Enemy - X:Chase, Y:Bounce");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menuItem = new JMenuItem("Enemy - X:Chase, Y:Chase");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Exit point");
		menuItem.addActionListener(this.menuListener);
		menu.add(menuItem);
		
		// Paramétrage de la fenêtre :
		this.setTitle("Lorann - Level Editor");
		this.setResizable(false);
		this.setSize(646, 442);
		this.setLocationRelativeTo(null);
		this.setJMenuBar(this.menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(this.panel);
		this.setBackground(Color.BLACK);
		
		this.addWindowListener(this);
		this.addKeyListener(this.kListener);
		this.addMouseListener(this.msListener);
		this.addMouseMotionListener(this.msListener);
		
		this.setVisible(true);
	}
	
	@Override
	public void windowClosing(WindowEvent e)
	{
		// Fermeture de la connexion
		try
		{
			Main.st.close();
			Main.cn.close();
		}
		catch (SQLException ex)
		{
			JOptionPane.showMessageDialog(Main.frame, ex.getMessage(), "SQL Exception", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
	}
}
