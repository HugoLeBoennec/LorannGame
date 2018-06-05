package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a solid vertical floor.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class BoneVertical extends Object {

	/**
     * Instantiates a new SolVertical.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public BoneVertical(final int x, final int y, final Scene scene) {
		super(Type.TYPE_STATIC, x, y, true, new Sprite(Sprite.SPRITE_BONEV, 0, 1), scene);
	}
}
