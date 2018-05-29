package model;

import java.sql.SQLException;
import java.util.List;

import model.dao.ElementDAO;
import model.elements.ICharacter;

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
     */
    public ModelFacade() {
        super();
        //this.character = new Lorann();
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
    @Override
    public Element getElementByPos(final int x, final int y) throws SQLException {
        return ElementDAO.getElementByPos(x, y);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllElements()
     */
    @Override
    public List<Element> getAllElements() throws SQLException {
        return ElementDAO.getAllElements();
    }
}
