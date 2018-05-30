package view;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.dao.ElementDAO;
import showboard.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements Runnable{
	
    /**
     * 
     * Instantiates a new view facade.
     */
    public ViewFacade() {
    	m_cam = new Rectangle(0, 0, (640), (384));
    	SwingUtilities.invokeLater(this);
    	super();
    }
    
    public void run() {
    	
    	final BoardFrame window;
    	
    	window = new BoardFrame("Lorann Game");
    	window.setDimension(new Dimension(640, 384));
    	window.setDisplayFrame(m_cam);
    	window.setSize(640, 384);
    	
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
