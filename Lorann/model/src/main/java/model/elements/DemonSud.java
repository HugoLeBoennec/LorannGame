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
	public DemonSud(int x, int y, final Scene scene) {
		super(x, y, true, Sprite.SPRITE_DEMONS, scene);
		
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
		
		// Vertical moves, bounce on walls :
		if (this.direction)
			this.moveDown();
		else
			this.moveUp();
		
		// Horizontal moves, follow player :
		if (character.getX() < this.getX())
			this.moveLeft();
		else if (character.getX() > this.getX())
			this.moveRight();
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}