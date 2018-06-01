package controller;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import view.IView;
import model.IModel;
import model.elements.ICharacter;


/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private IView  view;

    /** The model. */
    private IModel model;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     * @throws InterruptedException 
     */
    public void start() throws InterruptedException {
    	
    	// Get the main character :
        ICharacter character = this.model.getCharacter();
        
        // The main loop, keep running until the window is closed :
        while (true) {
        	
        	// Management of user inputs :
        	if (KeyManager.key != 0) {
        		switch (KeyManager.key) {
        			// Basic arrows :
        			case KeyEvent.VK_LEFT		: character.moveLeft(); break;
	        		case KeyEvent.VK_RIGHT		: character.moveRight(); break;
	        		case KeyEvent.VK_UP			: character.moveUp(); break;
	        		case KeyEvent.VK_DOWN		: character.moveDown(); break;
	        		
	        		// Numpad :
	        		case KeyEvent.VK_NUMPAD4	: character.moveLeft(); break;
	        		case KeyEvent.VK_NUMPAD6	: character.moveRight(); break;
	        		case KeyEvent.VK_NUMPAD8	: character.moveUp(); break;
	        		case KeyEvent.VK_NUMPAD2	: character.moveDown(); break;
	        		case KeyEvent.VK_NUMPAD1	: character.moveDownLeft(); break;
	        		case KeyEvent.VK_NUMPAD3	: character.moveDownRight(); break;
	        		case KeyEvent.VK_NUMPAD7	: character.moveUpLeft(); break;
	        		case KeyEvent.VK_NUMPAD9	: character.moveUpRight(); break;
	        		
	        		// Diagonal standard moves :
	        		case KeyEvent.VK_Z			: character.moveUp(); break;
	        		case KeyEvent.VK_Q			: character.moveLeft(); break;
	        		case KeyEvent.VK_S			: character.moveDown(); break;
	        		case KeyEvent.VK_D			: character.moveRight(); break;
	        		case KeyEvent.VK_W			: character.moveDownLeft(); break;
	        		case KeyEvent.VK_C			: character.moveDownRight(); break;
	        		case KeyEvent.VK_A			: character.moveUpLeft(); break;
	        		case KeyEvent.VK_E			: character.moveUpRight(); break;
	        		
	        		// Attack button :
	        		case KeyEvent.VK_SPACE		: character.attaque(this.view.getWindow()); KeyManager.key = 0; break;
	        		
	        		default : break;
        		}
        	}
        	
        	this.model.getScene().tick();
        	character.tick();
        	
        	this.view.windowUpdate();
        	
        	Thread.sleep(60);
        }
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
}
