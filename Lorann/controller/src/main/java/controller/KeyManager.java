package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <h1>The Class KeyCode represents the keyboard code of a key pressed.</h1>
 *
 * @author Julien LIGUORI julien.liguori@viacesi.fr
 * @version 1.0
 */
public class KeyManager extends KeyAdapter implements KeyListener {
	
	/** The code of the last key pressed. */
	static int key = 0;
	
	/**
     * Called when a key is pressed
     */
	public void keyPressed(KeyEvent event) {
		key = event.getKeyCode();
	}
}
