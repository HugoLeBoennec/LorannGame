package model.elements;

import java.awt.Point;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a powerful spell.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Sortilege extends Object implements IMobile {
	
	/**
     * Instantiates a new Sortilege.
     */
	public Sortilege(int x, int y, final Scene scene) {
		super(x, y, true, Sprite.SPRITE_SORTILEGE, scene);
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
	public int getDirection() {
		return this.direction;
	}

	@Override
	public void tick() {
		
	
		
		
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
