package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.dao.ElementDAO;
import model.elements.ICharacter;
import model.graphics.Sprite;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    /** The main character. */
    private final ICharacter character;
    
    /**
     * Instantiates a new model facade.
     * @throws IOException 
     */
    public ModelFacade() throws IOException {
        super();
        
        // Chargement des sprites :
    	Sprite.LoadSprite();
    	
        ///this.character = new Lorann();
        this.character = null;
    }
    
    @Override
	public ICharacter getCharacter() {
		return this.character;
	}

    /*
     * (non-Javadoc)
     * @see model.IModel#getElementById(int)
     */
    public Element getElementByPos(final int level, final int x, final int y) throws SQLException {
        return ElementDAO.getElementByPos(level, x, y);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllElements()
     */
    public List<Element> getAllElements(int level) throws SQLException {
        return ElementDAO.getAllElements(level);
    }
}
