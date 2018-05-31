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
	
	/** The daemon direction. */
	private boolean direction;
	
	/**
     * Instantiates a new DemonEst.
     */
	public DemonEst(int x, int y, final Scene scene) {
		super(x, y, true, Sprite.SPRITE_DEMONE, scene);
		
		this.direction = true;
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().getObjectXY(this.getX()+1, this.getY()).getSolidity())
			this.setX(getX()+1);
		else
			this.direction = !this.direction;
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().getObjectXY(this.getX()-1, this.getY()).getSolidity())
			this.setX(getX()-1);
		else
			this.direction = !this.direction;
	}

	@Override
	public void moveUp() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()-1).getSolidity())
			this.setY(getY()-1);
	}

	@Override
	public void moveDown() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity())
			this.setY(getY()+1);
	}
	
	@Override
	public void moveDownLeft() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity()) {
			this.setY(getY()-1);
			this.setX(getX()-1);
		}
		else
			this.direction = !this.direction;
	}
	
	@Override
	public void moveDownRight() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity()) {
			this.setY(getY()-1);
			this.setX(getX()+1);
		}
		else
			this.direction = !this.direction;
	}
	
	@Override
	public void moveUpLeft() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity()) {
			this.setY(getY()+1);
			this.setX(getX()-1);
		}
		else
			this.direction = !this.direction;
	}
	
	@Override
	public void moveUpRight() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity()) {
			this.setY(getY()+1);
			this.setX(getX()+1);
		}
		else
			this.direction = !this.direction;
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
		if (this.direction)
			this.moveRight();
		else
			this.moveLeft();
	}

	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
