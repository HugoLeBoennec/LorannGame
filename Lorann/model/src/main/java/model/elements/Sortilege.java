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
	
	/** The current direction. */
	private int direction;
	
	/**
     * Instantiates a new Sortilege.
     */
	public Sortilege(int x, int y, int direction, final Scene scene) {
		super(x, y, true, Sprite.SPRITE_SORTILEGE, scene);
		this.direction = direction;
	}

	@Override
	public void moveRight() {
		if (!this.getScene().getObjectXY(this.getX()+1, this.getY()).getSolidity())
			this.setX(getX()+1);
		else
			this.direction = 1;
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().getObjectXY(this.getX()-1, this.getY()).getSolidity())
			this.setX(getX()-1);
		else
			this.direction = 0;
	}

	@Override
	public void moveUp() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()-1).getSolidity())
			this.setY(getY()-1);
		else
			this.direction = 3;
	}

	@Override
	public void moveDown() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity())
			this.setY(getY()+1);
		else
			this.direction = 2;
	}
	
	@Override
	public void moveDownLeft() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity()) {
			this.setY(getY()-1);
			this.setX(getX()-1);
		}
		else
			this.direction = 7;
	}
	
	@Override
	public void moveDownRight() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity()) {
			this.setY(getY()-1);
			this.setX(getX()+1);
		}
		else
			this.direction = 6;
	}
	
	@Override
	public void moveUpLeft() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity()) {
			this.setY(getY()+1);
			this.setX(getX()-1);
		}
		else
			this.direction = 5;
	}
	
	@Override
	public void moveUpRight() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity()) {
			this.setY(getY()+1);
			this.setX(getX()+1);
		}
		else
			this.direction = 4;
	}

	@Override
	public void tick() {
		
		this.getSprite().animate();
		
		if (this.direction == 0)
			this.moveRight();
		else if (this.direction == 1)
			this.moveLeft();
		else if (this.direction == 2)
			this.moveUp();
		else
			this.moveDown();
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
