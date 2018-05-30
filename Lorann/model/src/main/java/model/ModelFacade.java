package model;

import java.io.IOException;
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

    /** The main scene. */
    private IScene scene;
    
    /**
     * Instantiates a new model facade.
     * 
     * @param scene
     *            the scene
     * @throws IOException 
     * @throws SQLException 
     */
    public ModelFacade(final IScene scene) throws IOException, SQLException {
        super();
    	
        this.scene = scene;
    }
    
    /**
     * Gets the main scene.
     *
     * @return the main scene
     */
	public IScene getScene() {
		return this.scene;
	}
	
	/**
     * Sets the main scene.
     *
     * @param scene
     *            the scene
     */
	public void setScene(final IScene scene) {
		this.scene = scene;
	}
	
	@Override
	public ICharacter getCharacter() {
		// Cast to convert "Lorann" into "ICharacter" :
		return (ICharacter)this.scene.getCharacter();
	}

    /*
     * (non-Javadoc)
     * @see model.IModel#getElementById(int)
     */
	@Override
    public Element getElementByPos(final int level, final int x, final int y) throws SQLException {
        return ElementDAO.getElementByPos(level, x, y);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllElements()
     */
	@Override
    public List<Element> getAllElements(int level) throws SQLException {
        return ElementDAO.getAllElements(level);
    }
}
