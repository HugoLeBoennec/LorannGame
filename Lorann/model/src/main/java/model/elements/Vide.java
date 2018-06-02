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
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public Vide(final int x, final int y, final Scene scene) {
		super(Type.TYPE_STATIC, x, y, false, new Sprite(Sprite.SPRITE_VIDE, 0, 1), scene);
	}
}
