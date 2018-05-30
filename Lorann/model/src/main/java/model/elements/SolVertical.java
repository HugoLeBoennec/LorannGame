package model.elements;

import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a solid vertical floor.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class SolVertical extends Object {

	/**
     * Instantiates a new SolVertical.
     */
	public SolVertical(int x, int y, final Sprite sprite, int level) {
		super(x, y, true, sprite,level);
	}
}
