package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.KeyManager;
import showboard.BoardFrame;
import model.IScene;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Hugo Le Boënnec hugo.leboennec@cesi.fr
 * @version 1.1
 */
public class ViewFacade extends Observable implements IView {
	
	/** The width. **/
	static private int WIDTH = 20;
	
	/** The height. **/
	static private int HEIGHT = 12;
	
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
    	
    	// Sprites loading :
    	this.scene.setupSprites();
    	
		// Call separate tread :
    	SwingUtilities.invokeLater(this);
    }
    
    @Override
    public void run() {
    	// Create a window named Lorann Game :
    	final BoardFrame window = new BoardFrame("Lorann Game");
    	
    	// Set the window parameters :
    	window.setDimension(new Dimension(WIDTH, HEIGHT));
    	window.setDisplayFrame(new Rectangle(0, 0, WIDTH, HEIGHT));
    	window.setSize(WIDTH * 32, HEIGHT * 32);
    	window.setFocusable(true);
    	window.setFocusTraversalKeysEnabled(false);
    	window.setDefaultCloseOperation(BoardFrame.EXIT_ON_CLOSE);
    	window.addKeyListener(keyManager);
    	
    	try {
			this.displayScene(window);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void displayScene(final BoardFrame frame) throws SQLException {
    	this.scene.loadLevel(1, frame);
    	
    	// Add to observer :
    	this.addObserver(frame.getObserver());
    	
    	frame.setVisible(true);
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
	}
    
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
