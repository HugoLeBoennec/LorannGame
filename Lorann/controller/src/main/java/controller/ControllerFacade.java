package controller;

import java.sql.SQLException;
import java.util.List;
import model.Element;
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
    private final IView  view;

    /** The model. */
    private final IModel model;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
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
        this.getView().displayMessage(this.getModel().getElementByPos(1, 1, 1).toString());

        final List<Element> Elements = this.getModel().getAllElements(1);
        final StringBuilder message = new StringBuilder();
        for (final Element Element : Elements) {
            message.append(Element);
            message.append('\n');
        }
        
        ICharacter character = this.model.getCharacter();
        
        // La boucle principale, continuant tant que le personnage est en vie :
        while (character.isAlive()) {
        	
        	this.getView().displayMessage(message.toString());
        	
        	// Gestion des entrées utilisateur :
        	KeyCode.key=0;
        	if (KeyCode.key != 0) {
        		switch (KeyCode.key) {
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
