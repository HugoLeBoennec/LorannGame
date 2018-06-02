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
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public Bulle(final int x, final int y, final Scene scene) {
		super(Type.TYPE_BULLE, x, y, false, new Sprite(Sprite.SPRITE_BULLE, 0, 2), scene);
	}
}
