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
	
    /** The total score. */
    static int score = 0;
    
	/**
     * Gets the total score.
     *
     * @return the score
     */
	static public int getScore() {
		return score;
	}
	
	/**
     * Gets the main scene.
     *
     * @return the main scene
     */
	public IScene getScene();
	
	/**
     * Sets the main scene.
     *
     * @param scene
     *            the scene
     */
	public void setScene(final IScene scene);
	
	/**
     * Gets the main character.
     *
     * @return the main character
     */
	public ICharacter getCharacter();
	
	/**
     * Gets the Element by position.
     *
     * @param level
     *            the level number
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @return the Element by position
     * @throws SQLException
     *             the SQL exception
     */
    public Element getElementByPos(final int level, final int x, final int y) throws SQLException;

    /**
     * Gets the all Elements.
     * 
     * @param level
     *            the level number
     * @return the all Elements
     * @throws SQLException
     *             the SQL exception
     */
    public List<Element> getAllElements(final int level) throws SQLException;
}
