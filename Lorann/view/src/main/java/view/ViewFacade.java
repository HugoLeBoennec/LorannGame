package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.dao.ElementDAO;
import showboard.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Hugo Le Boënnec jhugo.leboennec@cesi.fr
 * @version 1.1
 */
public class ViewFacade implements Runnable{
	
    /**
     * 
     * Instantiates a new view facade.
     */
	/** The width. */
	static private int WIDTH = 20;
	/** The height. */
	static private int HEIGHT = 12;
	
	
    public ViewFacade() {
		super();
		
		/** call separate tread **/
    	SwingUtilities.invokeLater(this);
    	
    }
    
    public void run() {
    	/** Create **/
    	final BoardFrame window;
    	
    	window = new BoardFrame("Lorann Game");
    	window.setDimension(new Dimension(WIDTH * 32, HEIGHT * 32));
    	window.setDisplayFrame(new Rectangle(0, 0, WIDTH * 32, HEIGHT * 32));
    	window.setSize(WIDTH * 32, HEIGHT * 32);
    	
    for( int y = 0; y < HEIGHT; y++) {
    	
    	for( int x = 0; x < WIDTH; x++) {
    		
    		window.addSquare(lel, x, y);
    		
    	}
    	
    }
    }
    
    
    
    
    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
}
