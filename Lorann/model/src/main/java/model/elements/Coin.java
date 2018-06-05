package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Bourse represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Coin extends Object {

	/**
     * Instantiates a new Bourse.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public Coin(final int x, final int y, final Scene scene) {
		super(Type.TYPE_COIN, x, y, false, new Sprite(Sprite.SPRITE_COIN, 0, 2), scene);
	}
}
