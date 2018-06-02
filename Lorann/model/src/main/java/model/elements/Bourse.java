package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Bourse represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Bourse extends Object {

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
	public Bourse(final int x, final int y, final Scene scene) {
		super(Type.TYPE_BOURSE, x, y, false, new Sprite(Sprite.SPRITE_BOURSE, 0, 2), scene);
	}
}
