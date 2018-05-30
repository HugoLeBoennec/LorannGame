package model;

import model.elements.*;

/**
 * <h1>The Interface Scene implements the game scene.</h1>
 *
 * @author Julien LIGUORI julien.liguori@viacesi.fr
 * @version 1.0
 */
public interface IScene {
	
	/**
     * Gets an object at position.
     *
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @return the element at the position
     */
    public IObject getObjectXY(int x, int y);
	
	/**
     * Gets the main character.
     *
     * @return the main character
     */
    public ICharacter getCharacter();
}
