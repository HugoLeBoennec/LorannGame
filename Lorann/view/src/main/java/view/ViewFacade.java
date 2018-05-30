package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.KeyManager;
import showboard.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Hugo Le Boënnec hugo.leboennec@cesi.fr
 * @version 1.1
 */
public class ViewFacade implements Runnable, IView {
	
	/** The width. */
	static private int WIDTH = 20;
	
	/** The height. */
	static private int HEIGHT = 12;
	
	/** The window. */
	private BoardFrame window;
	
	/** The key listener. */
    private KeyManager keyManager;
	
	/**
     * 
     * Instantiates a new view facade.
     */
    public ViewFacade() {
    	this.keyManager = new KeyManager();
    	
		// Call separate tread :
    	SwingUtilities.invokeLater(this);
    }
    
    /**
     * 
     * Creates the new window.
     */
    public void run() {
    	// Create a window named Lorann Game :
    	this.window = new BoardFrame("Lorann Game");
    	
    	// Set the window parameters :
    	this.window.setDimension(new Dimension(WIDTH * 32, HEIGHT * 32));
    	this.window.setDisplayFrame(new Rectangle(0, 0, WIDTH * 32, HEIGHT * 32));
    	this.window.setSize(WIDTH * 32, HEIGHT * 32);
    	this.window.setFocusable(true);
    	this.window.setFocusTraversalKeysEnabled(false);
    	this.window.setDefaultCloseOperation(BoardFrame.EXIT_ON_CLOSE);
    	this.window.addKeyListener(keyManager);
    	this.window.setBackground(Color.BLACK);
    	this.window.setVisible(true);
    	
    	//
    	
    	// Add to observer :
    	//getObserver().addObserver(frame.getObserver());
    }
    
    public BoardFrame getWindow() {
    	return this.window;
    }
    
    public void setWindow(final BoardFrame window) {
    	this.window = window;
    }
    
    /*public void displayScene(final Scene scene) {
        for( int y = 0; y < HEIGHT; y++) {
        	
        	for( int x = 0; x < WIDTH; x++) {
        		
        		//window.addSquare(lel, x, y);
        		
        	}
        	
        }
    }*/
    
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
}
