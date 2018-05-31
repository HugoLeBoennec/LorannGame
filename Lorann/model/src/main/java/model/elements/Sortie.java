package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents the level's end.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Sortie extends Object {

	/**
     * Instantiates a new Sortie.
     */
	public Sortie(int x, int y, final Sprite sprite, final Scene scene) {
		super(x, y, true, sprite, scene);
	}
}
