package model.elements;

import java.awt.Point;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class DemonEst represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonEst extends Object implements IMobile {
	
	/** If the daemon moves right. */
	private boolean isRight;
	
	/**
     * Instantiates a new DemonEst.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public DemonEst(final int x, final int y, final Scene scene) {
		super(Type.TYPE_DAEMON, x, y, false, Sprite.SPRITE_DEMONE, scene);
		
		this.isRight = true;
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()))
			this.setX(getX()+1);
		else
			this.isRight = false;
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()))
			this.setX(getX()-1);
		else
			this.isRight = true;
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1))
			this.setY(getY()-1);
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1))
			this.setY(getY()+1);
	}
	
	@Override
	public void moveDownLeft() {
		this.moveLeft();
		this.moveDown();
	}
	
	@Override
	public void moveDownRight() {
		this.moveRight();
		this.moveDown();
	}
	
	@Override
	public void moveUpLeft() {
		this.moveLeft();
		this.moveUp();
	}
	
	@Override
	public void moveUpRight() {
		this.moveRight();
		this.moveUp();
	}
	
	@Override
	public void tick() {
		ICharacter character = this.getScene().getCharacter();
		
		// Vertical moves, follow player :
		if (character.getY() < this.getY())
			this.moveUp();
		else if (character.getY() > this.getY())
			this.moveDown();
		
		// Horizontal moves, bounce on walls :
		if (this.isRight)
			this.moveRight();
		else
			this.moveLeft();
	}

	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
