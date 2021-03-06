package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a solid horizontal floor.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class BoneHorizontal extends Object {

	/**
     * Instantiates a new SolHorizontal.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public BoneHorizontal(final int x, final int y, final Scene scene) {
		super(Type.TYPE_STATIC, x, y, true, new Sprite(Sprite.SPRITE_BONEH, 0, 1), scene);
	}
}
