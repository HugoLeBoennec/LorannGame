package model.elements;

import showboard.BoardFrame;

/**
 * <h1>The Interface ICharacters implements life states.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public interface ICharacter extends IMobile {

	/**
     * Casts a spell
     */
	public void attaque(final BoardFrame frame);
	
	/**
     * Gets the cast spell
     * @return the spell if cast
     */
	public IObject getSortilege();
}
