package model.elements;

import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a solid wall.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Mur extends Object {

	/**
     * Instantiates a new Mur.
     */
	public Mur(int x, int y, final Sprite sprite, int level) {
		super(x, y, true, sprite,level);
	}
}
