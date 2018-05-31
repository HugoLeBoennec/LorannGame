package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a solid horizontal floor.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class SolHorizontal extends Object {

	/**
     * Instantiates a new SolHorizontal.
     */
	public SolHorizontal(int x, int y, final Sprite sprite, final Scene scene) {
		super(x, y, true, sprite, scene);
	}
}
