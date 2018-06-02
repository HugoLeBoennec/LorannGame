package controller;

import java.sql.SQLException;

import view.IView;
import model.IModel;
import model.IScene;
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
        final ICharacter character = this.model.getCharacter();
        final IScene scene = this.model.getScene();
        
        // The main loop, keep running until the window is closed :
        while (true) {
        	
        	// Horizontal movements :
        	if (KeyManager.left && !KeyManager.right)
        		character.moveLeft();
        	else if (KeyManager.right && !KeyManager.left)
        		character.moveRight();
        	
        	// Vertical movements :
        	if (KeyManager.up && !KeyManager.down)
        		character.moveUp();
        	else if (KeyManager.down && !KeyManager.up)
        		character.moveDown();
        	
        	// Diagonal up-left movements :
        	if (KeyManager.upleft && !KeyManager.downright)
        		character.moveUpLeft();
        	else if (KeyManager.downright && !KeyManager.upleft)
        		character.moveDownRight();
        	
        	// Diagonal up-right movements :
        	if (KeyManager.upright && !KeyManager.downleft)
        		character.moveUpRight();
        	else if (KeyManager.downleft && !KeyManager.upright)
        		character.moveDownLeft();
        	
        	// Attack movement :
        	if (KeyManager.attack && !KeyManager.attacked) {
        		character.attaque();
        		KeyManager.attacked = true;
        	}
        	
        	if (!scene.hasToReloadLevel()) {
	        	scene.tick();				// Update the whole scene
	        	this.view.windowUpdate();	// Update the window
        	}
        	
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
