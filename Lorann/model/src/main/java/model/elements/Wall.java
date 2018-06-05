package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a solid wall.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Wall extends Object {

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
	public Wall(final int x, final int y, final Scene scene) {
		super(Type.TYPE_STATIC, x, y, true, new Sprite(Sprite.SPRITE_WALL, 0, 1), scene);
	}
}
