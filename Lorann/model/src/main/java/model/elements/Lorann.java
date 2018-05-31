package model.elements;

import java.awt.Point;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Lorann represents the controllable character.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Lorann extends Object implements ICharacter {
	
	/** The life state. */
	private boolean alive;
	
	/** The current direction. */
	private int direction;
	
	/** The spell. */
	private Sortilege sortilege;
	
	/**
     * Instantiates a new Lorann.
     */
	public Lorann(int x, int y, final Scene scene) {
		super(x, y, true, Sprite.SPRITE_LORANN, scene);
		this.direction = 0;
		this.alive = true;
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(getX()+1, getY())) {
			this.setX(getX()+1);
		}
		this.direction = 0;
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY())) {
			this.setX(getX()-1);
		}
		this.direction = 1;
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1)) {
			this.setY(getY()-1);
		}
		this.direction = 2;
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1)) {
			this.setY(getY()+1);
		}
		this.direction = 3;
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
	}
	
	@Override
	public void attaque() {
		this.sortilege = new Sortilege(this.getX(), this.getY(), this.direction, this.getScene());
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
