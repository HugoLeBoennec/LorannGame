package view;

import java.awt.event.KeyListener;

import showboard.BoardFrame;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
	 * Gets the window
	 * 
	 * @return the window
	 */
    public BoardFrame getWindow();
    
    /**
	 * Sets the window
	 * 
	 * @return the window
	 */
    public void setWindow(final BoardFrame window);
    
    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
}
