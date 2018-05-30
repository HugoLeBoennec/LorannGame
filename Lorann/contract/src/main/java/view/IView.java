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
     * Update all the frame.
     *
     */
    void update();
    
    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
}
