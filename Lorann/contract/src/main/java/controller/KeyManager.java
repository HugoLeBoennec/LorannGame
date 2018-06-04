package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <h1>The Class KeyCode represents the keyboard code of a key pressed.</h1>
 *
 * @author Julien LIGUORI julien.liguori@viacesi.fr
 * @version 1.0
 */
public class KeyManager implements KeyListener {
	
	/** The handlers for axis-aligned moves. */
	static boolean left = false;
	static boolean right = false;
	static boolean up = false;
	static boolean down = false;
    
    /** The handlers for diagonals moves. */
	static boolean downleft = false;
	static boolean downright = false;
	static boolean upleft = false;
	static boolean upright = false;
    
    /** The attack move. */
	static boolean attack = false;
	static boolean attacked = false;
	
	/**
     * Called when a key is pressed
     */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			// Basic arrows :
			case KeyEvent.VK_LEFT		: left = true;		break;
	    	case KeyEvent.VK_RIGHT		: right = true; 	break;
	    	case KeyEvent.VK_UP			: up = true;		break;
	    	case KeyEvent.VK_DOWN		: down = true;		break;
	    		
	    	// Numpad :
	    	case KeyEvent.VK_NUMPAD4	: left = true;		break;
	    	case KeyEvent.VK_NUMPAD6	: right = true; 	break;
	    	case KeyEvent.VK_NUMPAD8	: up = true;		break;
	    	case KeyEvent.VK_NUMPAD2	: down = true;		break;
	    	case KeyEvent.VK_NUMPAD1	: downleft = true;	break;
	    	case KeyEvent.VK_NUMPAD3	: downright = true; break;
	    	case KeyEvent.VK_NUMPAD7	: upleft = true;	break;
	    	case KeyEvent.VK_NUMPAD9	: upright = true;	break;
	    	case KeyEvent.VK_NUMPAD5	: attack = true;	break;
	    		
	    	// Keys :
	    	case KeyEvent.VK_Z			: up = true;		break;
	    	case KeyEvent.VK_Q			: left = true; 		break;
	    	case KeyEvent.VK_S			: down = true;		break;
	    	case KeyEvent.VK_D			: right = true;		break;
	    	case KeyEvent.VK_W			: downleft = true;	break;
	    	case KeyEvent.VK_C			: downright = true; break;
	    	case KeyEvent.VK_A			: upleft = true;	break;
	    	case KeyEvent.VK_E			: upright = true;	break;
	    		
	    	// Standard attack button :
	    	case KeyEvent.VK_SPACE		: attack = true;	break;
	    		
	    	default : break;
		}
	}

	/**
     * Called when the keyboard is typing
     */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
     * Called when a key is released
     */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			// Basic arrows :
			case KeyEvent.VK_LEFT		: left = false;						break;
	    	case KeyEvent.VK_RIGHT		: right = false; 					break;
	    	case KeyEvent.VK_UP			: up = false;						break;
	    	case KeyEvent.VK_DOWN		: down = false;						break;
	    		
	    	// Numpad :
	    	case KeyEvent.VK_NUMPAD4	: left = false;						break;
	    	case KeyEvent.VK_NUMPAD6	: right = false; 					break;
	    	case KeyEvent.VK_NUMPAD8	: up = false;						break;
	    	case KeyEvent.VK_NUMPAD2	: down = false;						break;
	    	case KeyEvent.VK_NUMPAD1	: downleft = false;					break;
	    	case KeyEvent.VK_NUMPAD3	: downright = false;				break;
	    	case KeyEvent.VK_NUMPAD7	: upleft = false;					break;
	    	case KeyEvent.VK_NUMPAD9	: upright = false;					break;
	    	case KeyEvent.VK_NUMPAD5	: attack = false;					break;
	    		
	    	// Keys :
	    	case KeyEvent.VK_Z			: up = false;				break;
	    	case KeyEvent.VK_Q			: left = false; 			break;
	    	case KeyEvent.VK_S			: down = false;				break;
	    	case KeyEvent.VK_D			: right = false;			break;
	    	case KeyEvent.VK_W			: downleft = false;			break;
	    	case KeyEvent.VK_C			: downright = false;		break;
	    	case KeyEvent.VK_A			: upleft = false;			break;
	    	case KeyEvent.VK_E			: upright = false;			break;
	    		
	    	// Standard attack button :
	    	case KeyEvent.VK_SPACE		: attack = false; attacked = false;	break;
	    		
	    	default : break;
		}
	}
}
