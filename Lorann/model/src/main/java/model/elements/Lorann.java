package model.elements;

import model.graphics.Sprite;

/**
 * <h1>The Class Lorann represents the controllable character.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public abstract class Lorann extends Object implements ICharacter {
	
	/** The life state. */
	private boolean alive;
	
	/**
     * Instantiates a new Lorann.
     */
	public Lorann(int x, int y, final Sprite sprite) {
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
	
	@Override
	public void attaque() {
		
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}
}
