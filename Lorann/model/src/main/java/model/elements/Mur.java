package model.elements;

import model.Scene;
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
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public Mur(final int x, final int y, final Scene scene) {
		super(x, y, true, Sprite.SPRITE_MUR, scene);
	}
}
