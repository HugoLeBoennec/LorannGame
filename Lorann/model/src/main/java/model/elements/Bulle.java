package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Bulle represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Bulle extends Object {

	/**
     * Instantiates a new Bulle.
     */
	public Bulle(int x, int y, final Sprite sprite, final Scene scene) {
		super(x, y, true, sprite, scene);
	}
}
