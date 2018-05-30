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
	public DemonEst(int x, int y, final Sprite sprite, Scene scene) {
		super(x, y, true, sprite, scene);
		
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
	public void tick() {
		if (this.getScene().getCharacter().getY() == this.getY()) {
			if (this.getScene().getCharacter().getX() < this.getX()) {
				this.moveLeft();
			}
			else {
				if (this.getScene().getCharacter().getX() < this.getX()) {
					this.moveRight();
					}
				else {
					this.moveLeft();
				}
			}
		}
		else if (this.getScene().getCharacter().getY() < this.getY()) {
			if (this.getScene().getCharacter().getX() < this.getX()) {
				this.moveLeft();
				this.moveDown();
			}
			else {
				this.moveLeft();
				this.moveUp();
			}
		}
		else {
			if (this.getScene().getCharacter().getX() < this.getX()) {
				this.moveRight();
				this.moveDown();
			}
			else {
				this.moveRight();
				this.moveUp();
			}
		}
	}

	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
