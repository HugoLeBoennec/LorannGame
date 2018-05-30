package controller;

import java.sql.SQLException;
import java.util.Observable;

import model.IModel;
import model.elements.ICharacter;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade extends Observable implements IController {

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
     */
    public void start() throws SQLException {
    	// Configuration of the view :
    	//this.view.setKeyListener(this.keyCode);
    	//addObserver(this.view.getWindow().getObserver());
    	
    	// Get the main character :
        ICharacter character = this.model.getCharacter();
        
        // The main loop, keep running until the character is dead :
        while (character.isAlive()) {
        	
        	// Gestion des entrées utilisateur :
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
        		case 32:
        			character.attaque();
        			break;
        		}
        	}
        	KeyManager.key=0;
        	
        	this.setChanged();
        	this.notifyObservers();
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
