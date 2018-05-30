package model;

import java.sql.SQLException;

import model.dao.ElementDAO;
import model.elements.*;

/**
 * <h1>The Interface Scene implements the game scene.</h1>
 *
 * @author Julien LIGUORI julien.liguori@viacesi.fr
 * @version 1.0
 */
public interface IScene {
	
    /**
     * Load a level from database
     * 
     * @throws SQLException
     */
	public void loadLevel(final int level) throws SQLException;
	
	/**
     * Gets the main character.
     *
     * @return the main character
     */
    public ICharacter getCharacter();
}
