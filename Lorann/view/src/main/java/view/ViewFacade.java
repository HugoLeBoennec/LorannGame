package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.KeyManager;
import model.IScene;
import showboard.BoardFrame;
import showboard.BoardPanel;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Hugo Le Boënnec hugo.leboennec@viacesi.fr
 * @version 1.1
 */
public class ViewFacade extends Observable implements IView {
	
	/** The width. **/
	static private int WIDTH = 20;
	
	/** The height. **/
	static private int HEIGHT = 12;
	
	/** The main window. **/
	private BoardFrame window;
	
	/** The key listener. **/
    private KeyManager keyManager;
    
    /** The main scene. */
    private IScene scene;
	
	/**
     * 
     * Instantiates a new view facade.
     * 
     * @param scene
     *            the scene
     */
    public ViewFacade(final IScene scene) {
    	super();
    	
    	this.keyManager = new KeyManager();
    	this.scene = scene;
    	
		// Call separate tread :
    	SwingUtilities.invokeLater(this);
    }
    
    @Override
    public void run() {
    	// Create a window named Lorann Game :
    	try {
			this.window = new BoardFrame("Lorann Game");
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
    	
    	// Set the window parameters :
    	this.window.setDimension(new Dimension(WIDTH, HEIGHT));
    	this.window.setDisplayFrame(new Rectangle(0, 0, WIDTH, HEIGHT + 2));
    	this.window.setSize(WIDTH * 32, HEIGHT * 32 + 64);
    	this.window.setFocusable(true);
    	this.window.setFocusTraversalKeysEnabled(false);
    	this.window.setBackground(Color.BLACK);
    	this.window.setDefaultCloseOperation(BoardFrame.EXIT_ON_CLOSE);
    	this.window.addKeyListener(keyManager);
    	
		this.displayScene();
    }
    
    public void displayScene() {
    	// Load the first level here :
    	try {
    		this.scene.loadLevel(this.scene.getCurrentLevel(), this.window);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	this.addObserver(this.window.getObserver());
    	
    	this.window.setVisible(true);
    }
    
    /**
     * Gets the main scene.
     *
     * @return the main scene
     */
	public IScene getScene() {
		return this.scene;
	}
	
	/**
     * Sets the main scene.
     *
     * @param scene
     *            the scene
     */
	public void setScene(final IScene scene) {
		this.scene = scene;
	}
    
    @Override
	public void windowUpdate() {
		this.setChanged();
		this.notifyObservers();
		
		if (this.scene.hasToReloadLevel()) {
			final BoardPanel panel = this.window.getBoardPanel();
			
			this.scene.unloadLevel();
			this.scene.reloadLevel(false);
			
			panel.clear();
			panel.resetScore();
			
			try {
	    		this.scene.loadLevel(this.scene.getCurrentLevel(), this.window);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
    
    @Override
	public BoardFrame getWindow() {
		return this.window;
	}
    
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
