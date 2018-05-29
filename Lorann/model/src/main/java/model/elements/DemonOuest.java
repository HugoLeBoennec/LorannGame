package model.elements;

import model.graphics.Sprite;

/**
 * <h1>The Class DemonOuest represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonOuest extends Object implements IMobile {

	/**
     * Instantiates a new DemonOuest.
     */
	public DemonOuest(int x, int y, final Sprite sprite) {
		super(x, y, false, sprite);
	}
	@Override
	public void moveRight() {
		this.setX(getX()+1);
	}

	@Override
	public void moveLeft() {
		this.setX(getX()-1);
	}

	@Override
	public void moveUp() {
		this.setY(getY()+1);
	}

	@Override
	public void moveDown() {
		this.setY(getY()-1);
	}
}
