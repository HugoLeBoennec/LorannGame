package model.elements;

/**
 * <h1>The Interface ICharacters implements life states.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public interface ICharacter extends IMobile {
	
	/**
     * Test if the character is alive
     */
	public boolean isAlive();
	
	/**
     * Casts a spell
     */
	public void attaque();
}
