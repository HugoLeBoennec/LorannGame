package view;

import showboard.BoardFrame;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView extends Runnable {
    
	/**
     * 
     * Creates the new window.
     */
    public void run();
    
	/**
     * Update all the frame.
     *
     */
    public void windowUpdate();
    
    /**
     * Gets the main window.
     * 
     * @return the main window
     */
    public BoardFrame getWindow();
    
    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(final String message);
}
