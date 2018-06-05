package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Key represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Key extends Object {

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
	public Key(final int x, final int y, final Scene scene) {
		super(Type.TYPE_KEY, x, y, false, new Sprite(Sprite.SPRITE_KEY, 0, 2), scene);
	}
}
