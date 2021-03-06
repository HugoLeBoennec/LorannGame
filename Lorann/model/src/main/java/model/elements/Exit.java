package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents the level's end.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Exit extends Object {

	/**
     * Instantiates a new Sortie.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public Exit(final int x, final int y, final Scene scene) {
		super(Type.TYPE_EXIT, x, y, false, new Sprite(Sprite.SPRITE_DOOR, 0, 2), scene);
	}
}
