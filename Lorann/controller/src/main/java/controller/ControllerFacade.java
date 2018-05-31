package controller;

import java.sql.SQLException;

import model.IModel;
import model.elements.ICharacter;
import view.IView;

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
        
        // The main loop, keep running until the character is dead :
        while (character.isAlive()) {
        	
        	// Gestion des entr�es utilisateur :
        	if (KeyManager.key != 0) {
        		switch (KeyManager.key) {
        		case 39:
        			character.moveRight();
        			break;
        		case 37:
        			character.moveLeft();
        			break;
        		case 38:
        			character.moveUp();
        			break;
        		case 40:
        			character.moveDown();
        			break;
        		case 87:
        			character.moveDownLeft();
        			break;
        		case 67:
        			character.moveDownRight();
        			break;
        		case 65:
        			character.moveUpLeft();
        			break;
        		case 69:
        			character.moveUpRight();
        			break;
        		case 32:
        			character.attaque();
        			break;
        		}
        	}
        	KeyManager.key=0;
        	
        	character.tick();
        	
        	this.view.windowUpdate();
        	
        	Thread.sleep(100);
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
