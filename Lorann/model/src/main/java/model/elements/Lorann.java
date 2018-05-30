package model.elements;

import model.Scene;
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
	public Lorann(int x, int y, final Sprite sprite, int level) {
		super(x, y, true, sprite,level);
	}
	
	@Override
	public void moveRight() {
		if (Scene.getObjectXY(this.getX()+1,this.getY(),level).getSolidity() == false) {
			this.setX(getX()+1);
		}
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
