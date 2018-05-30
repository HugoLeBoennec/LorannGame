package model.elements;

import java.awt.Point;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class DemonSud represents a collectable item</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonSud extends Object implements IMobile {

	/** The daemon direction. */
	private boolean direction;
	
	/**
     * Instantiates a new DemonSud.
     */
	public DemonSud(int x, int y, final Sprite sprite, Scene scene) {
		super(x, y, true, sprite, scene);
		
		this.direction = true;
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().getObjectXY(this.getX()+1, this.getY()).getSolidity())
			this.setX(getX()+1);
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().getObjectXY(this.getX()-1, this.getY()).getSolidity())
			this.setX(getX()-1);
	}

	@Override
	public void moveUp() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()-1).getSolidity())
			this.setY(getY()-1);
		else
			this.direction = !this.direction;
	}

	@Override
	public void moveDown() {
		if (!this.getScene().getObjectXY(this.getX(), this.getY()+1).getSolidity())
			this.setY(getY()+1);
		else
			this.direction = !this.direction;
	}
	
	@Override
	public void tick() {
		if (this.getScene().getCharacter().getX() == this.getX()) {
			if (this.getScene().getCharacter().getY() < this.getY()) {
				this.moveDown();
			}
			else {
				if (this.getScene().getCharacter().getY() < this.getY()) {
					this.moveUp();
					}
				else {
					this.moveDown();
				}
			}
		}
		else if (this.getScene().getCharacter().getX() < this.getX()) {
			if (this.getScene().getCharacter().getY() < this.getY()) {
				this.moveDown();
				this.moveLeft();
			}
			else {
				this.moveDown();
				this.moveRight();
			}
		}
		else {
			if (this.getScene().getCharacter().getY() < this.getY()) {
				this.moveUp();
				this.moveLeft();
			}
			else {
				this.moveUp();
				this.moveRight();
			}
		}
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}