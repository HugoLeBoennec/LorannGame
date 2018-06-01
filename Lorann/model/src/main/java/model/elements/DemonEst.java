package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class DemonEst represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonEst extends Object implements IMobile {
	
	/** If the daemon is alive */
	private boolean alive;
	
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
		super(Type.TYPE_DAEMON, x, y, false, new Sprite(Sprite.SPRITE_DEMONE, 0), scene);
		this.alive = true;
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()))
			this.setX(getX()+1);
		
		this.testCollision(this.getX(), this.getY(), this.getScene());
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()))
			this.setX(getX()-1);
		
		this.testCollision(this.getX(), this.getY(), this.getScene());
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1))
			this.setY(getY()-1);
		
		this.testCollision(this.getX(), this.getY(), this.getScene());
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1))
			this.setY(getY()+1);
		
		this.testCollision(this.getX(), this.getY(), this.getScene());
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
		
		// Follow player :
		if  (character.getX() == getX()) {
			if (character.getY() > getY())		this.moveDown();
			else								this.moveUp();
		} else if (character.getX() > getX()) {
			if (character.getY() == getY())		this.moveRight();
			else if (character.getY() > getY())	this.moveDownRight();
			else								this.moveUpRight();
		} else {
			if (character.getY() == getY())		this.moveLeft();
			else if (character.getY() > getY())	this.moveDownLeft();
			else								this.moveUpLeft();
		}
	}
	
	@Override
	public void testCollision(final int x, final int y, final IScene scene) {
		Object object = (Object)scene.getObjectXY(x, y);
		ICharacter character = scene.getCharacter();
		
		if (character.getX() == x && character.getY() == y)
			scene.reloadLevel(true);
		
		if (object != null) {
			if (object.getType() == Type.TYPE_SORTIE) {
				if (object.getSprite().getAnimFrame() == 0) {
					this.alive = false;
					this.setX(-1);
					this.setY(-1);
				}
			}
		}
	}

	@Override
	public Point getPosition() {
		if (this.alive)
			return new Point(this.getX(), this.getY());
		else
			return new Point(-1, -1);
	}
}
