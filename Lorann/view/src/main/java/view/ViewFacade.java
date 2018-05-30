package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.KeyManager;
import model.IScene;
import showboard.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Hugo Le Boënnec hugo.leboennec@cesi.fr
 * @version 1.1
 */
public class ViewFacade extends Observable implements Runnable, IView {
	
	/** The width. */
	static private int WIDTH = 20;
	
	/** The height. */
	static private int HEIGHT = 12;
	
	/** The key listener. */
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
    	this.keyManager = new KeyManager();
    	this.scene = scene;
    	
		// Call separate tread :
    	SwingUtilities.invokeLater(this);
    }
    
    /**
     * 
     * Creates the new window.
     */
    public void run() {
    	// Create a window named Lorann Game :
    	BoardFrame window = new BoardFrame("Lorann Game");
    	
    	// Set the window parameters :
    	window.setDimension(new Dimension(WIDTH * 32, HEIGHT * 32));
    	window.setDisplayFrame(new Rectangle(0, 0, WIDTH * 32, HEIGHT * 32));
    	window.setSize(WIDTH * 32, HEIGHT * 32);
    	window.setFocusable(true);
    	window.setFocusTraversalKeysEnabled(false);
    	window.setDefaultCloseOperation(BoardFrame.EXIT_ON_CLOSE);
    	window.addKeyListener(keyManager);
    	window.setBackground(Color.BLACK);
    	window.setVisible(true);
    	
    	//window.addSquare(new Mur(0, 0, Sprite.SPRITE_MUR, this), 0, 0);
    	
    	// Add to observer :
    	addObserver(window.getObserver());
    }
    
    /*public void displayScene(final Scene scene) {
        for( int y = 0; y < HEIGHT; y++) {
        	
        	for( int x = 0; x < WIDTH; x++) {
        		
        		//window.addSquare(lel, x, y);
        		
        	}
        	
        }
    }*/
    
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
	public void update() {
		setChanged();
		notifyObservers();
	}
    
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
