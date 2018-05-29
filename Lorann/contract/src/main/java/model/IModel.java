package model;

import java.sql.SQLException;
import java.util.List;

import model.elements.ICharacter;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    /**
     * Gets the main character.
     *
     * @return the main character
     */
	ICharacter getCharacter();
	
	/**
     * Gets the Element by position.
     *
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @return the Element by position
     * @throws SQLException
     *             the SQL exception
     */
    Element getElementByPos(final int level, final int x, final int y) throws SQLException;

    /**
     * Gets the all Elements.
     *
     * @return the all Elements
     * @throws SQLException
     *             the SQL exception
     */
    List<Element> getAllElements(final int level) throws SQLException;
}
