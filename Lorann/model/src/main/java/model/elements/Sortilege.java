package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a powerful spell.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Sortilege extends Object implements IMobile {
	
	/** The current direction */
	private Direction direction;
	
	/** If the spell is cast */
	private boolean cast;
	
	/**
     * Instantiates a new Sortilege.
     */
	public Sortilege(final int x, final int y, final Scene scene) {
		super(Type.TYPE_STATIC, x, y, false, new Sprite(Sprite.SPRITE_SORTILEGE, 0), scene);		
		this.cast = false;
	}
	
	/**
     * Gets if the spell is cast.
     *
     * @return the cast state
     */
	public boolean isCast() {
		return this.cast;
	}
	
	/**
     * Cast the spell.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public void cast(final int x, final int y, final Direction direction) {
		if (this.cast) {
			// Make the spell moves towards character :
			ICharacter character = this.getScene().getCharacter();
			
			if  (character.getX() == getX()) {
				if (character.getY() > getY())		this.direction = Direction.DIR_DOWN;
				else								this.direction = Direction.DIR_UP;
			} else if (character.getX() > getX()) {
				if (character.getY() == getY())		this.direction = Direction.DIR_RIGHT;
				else if (character.getY() > getY())	this.direction = Direction.DIR_DOWNRIGHT;
				else								this.direction = Direction.DIR_UPRIGHT;
			} else {
				if (character.getY() == getY())		this.direction = Direction.DIR_LEFT;
				else if (character.getY() > getY())	this.direction = Direction.DIR_DOWNLEFT;
				else								this.direction = Direction.DIR_UPLEFT;
			}
		} else {
			this.cast = true;
			this.direction = direction;
			
			this.setX(x);
			this.setY(y);
		}
	}
	
	/**
     * Reset the spell position.
     * 
     */
	public void reset() {
		this.cast = false;
		this.setX(-1);
		this.setY(-1);
	}

	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()))
			this.setX(getX()+1);
		else
			this.direction = Direction.DIR_LEFT;
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()))
			this.setX(getX()-1);
		else
			this.direction = Direction.DIR_RIGHT;
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1))
			this.setY(getY()-1);
		else
			this.direction = Direction.DIR_DOWN;
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1))
			this.setY(getY()+1);
		else
			this.direction = Direction.DIR_UP;
	}
	
	@Override
	public void moveDownLeft() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()-1, this.getY()))
			this.setX(getX()-1);
		else
			this.direction = Direction.DIR_DOWNRIGHT;
		
		if (!scene.isPenetrable(this.getX(), this.getY()+1))
			this.setY(getY()+1);
		else
			this.direction = Direction.DIR_UPLEFT;
	}
	
	@Override
	public void moveDownRight() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()+1, this.getY()))
			this.setX(getX()+1);
		else
			this.direction = Direction.DIR_DOWNLEFT;
		
		if (!scene.isPenetrable(this.getX(), this.getY()+1))
			this.setY(getY()+1);
		else
			this.direction = Direction.DIR_UPRIGHT;
	}
	
	@Override
	public void moveUpLeft() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()-1, this.getY()))
			this.setX(getX()-1);
		else
			this.direction = Direction.DIR_UPRIGHT;
		
		if (!scene.isPenetrable(this.getX(), this.getY()-1))
			this.setY(getY()-1);
		else
			this.direction = Direction.DIR_DOWNLEFT;
	}
	
	@Override
	public void moveUpRight() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()+1, this.getY()))
			this.setX(getX()+1);
		else
			this.direction = Direction.DIR_UPLEFT;
		
		if (!scene.isPenetrable(this.getX(), this.getY()-1))
			this.setY(getY()-1);
		else
			this.direction = Direction.DIR_DOWNRIGHT;
	}

	@Override
	public void tick() {
		this.getSprite().animate();
		
		ICharacter character = this.getScene().getCharacter();
		
		switch (this.direction) {
			case DIR_LEFT 		: this.moveLeft(); break;
			case DIR_UPLEFT		: this.moveUpLeft(); break;
			case DIR_UP			: this.moveUp(); break;
			case DIR_UPRIGHT	: this.moveUpRight(); break;
			case DIR_RIGHT		: this.moveRight(); break;
			case DIR_DOWNRIGHT	: this.moveDownRight(); break;
			case DIR_DOWN		: this.moveDown(); break;
			case DIR_DOWNLEFT	: this.moveDownLeft(); break;
		}
		
		if ((character.getX() == this.getX()) & (character.getY() == this.getY())) {
			this.cast = false;
			this.setX(-1);
			this.setY(-1);
		}
	}
	
	@Override
	public void testCollision(final int x, final int y, final IScene scene) {
	}
	
	@Override
	public Point getPosition() {
		// If the spell isn't cast, return the pos outside :
		if (this.cast)
			return new Point(this.getX(), this.getY());
		else
			return new Point(-1, -1);
	}
}
