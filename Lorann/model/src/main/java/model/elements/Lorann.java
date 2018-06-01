package model.elements;

import java.awt.Point;

import model.Scene;
import model.graphics.Sprite;
import showboard.BoardFrame;

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
	private Direction direction;
	
	/** The cast spell. */
	private Sortilege sortilege;
	
	/**
     * Instantiates a new Lorann.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public Lorann(final int x, final int y, final Scene scene) {
		super(x, y, false, Sprite.SPRITE_LORANN, scene);
		
		this.alive = true;
		this.direction = Direction.DIR_RIGHT;
		this.sortilege = new Sortilege(-1, -1, scene);
	}
	
	/**
     * Initiate the spell.
     * 
     * @param frame
     *            the drawing frame
     */
	public void initiate(final BoardFrame frame) {
		frame.addPawn(this.sortilege);
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(getX()+1, getY())) {
			this.setX(getX()+1);
		}
		this.direction = Direction.DIR_RIGHT;
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY())) {
			this.setX(getX()-1);
		}
		this.direction = Direction.DIR_LEFT;
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1)) {
			this.setY(getY()-1);
		}
		this.direction = Direction.DIR_UP;
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1)) {
			this.setY(getY()+1);
		}
		this.direction = Direction.DIR_DOWN;
	}
	
	@Override
	public void moveDownLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()+1)) {
			this.setX(getX()-1);
			this.setY(getY()+1);
		}
			this.direction = Direction.DIR_DOWNLEFT;
	}
	
	@Override
	public void moveDownRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()+1)) {
			this.setX(getX()+1);
			this.setY(getY()+1);
		}
			this.direction = Direction.DIR_DOWNRIGHT;
	}
	
	@Override
	public void moveUpLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()-1)) {
			this.setX(getX()-1);
			this.setY(getY()-1);
		}
			this.direction = Direction.DIR_UPLEFT;
	}
	
	@Override
	public void moveUpRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()-1)) {
			this.setX(getX()+1);
			this.setY(getY()-1);
		}
			this.direction = Direction.DIR_UPRIGHT;
	}
	
	@Override
	public void tick() {
		this.getSprite().animate();
		
		if (this.sortilege.isCast())
			this.sortilege.tick();
	}
	
	@Override
	public boolean isAlive() {
		return this.alive;
	}
	
	@Override
	public void attaque(final BoardFrame frame) {
		this.sortilege.cast(this.getX(), this.getY(), this.direction);
	}
	
	@Override
	public IObject getSortilege() {
		return this.sortilege;
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
