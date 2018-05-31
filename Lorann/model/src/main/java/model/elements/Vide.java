package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a solid wall.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Vide extends Object {

	/**
     * Instantiates a new Vide.
     */
	public Vide(int x, int y, final Sprite sprite, final Scene scene) {
		super(x, y, false, sprite, scene);
	}
}
