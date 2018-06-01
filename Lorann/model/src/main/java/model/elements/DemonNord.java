package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class DemonNord represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonNord extends Object implements IMobile {
	
	/** If the daemon is alive */
	private boolean alive;

	/** The daemon's direction. */
	private Direction direction;
	
	/**
     * Instantiates a new DemonNord.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public DemonNord(int x, int y, final Scene scene) {
		super(Type.TYPE_DAEMON, x, y, false, new Sprite(Sprite.SPRITE_DEMONN, 0), scene);
		
		this.alive = true;
		
		// Choose a random direction :
		this.direction = Direction.randomDirection();
	}

	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()))
			this.setX(getX()+1);
		else
			this.direction = Direction.DIR_LEFT;
		
		this.testCollision(getX(), getY(), this.getScene());
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()))
			this.setX(getX()-1);
		else
			this.direction = Direction.DIR_RIGHT;
		
		this.testCollision(getX(), getY(), this.getScene());
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1))
			this.setY(getY()-1);
		else
			this.direction = Direction.DIR_DOWN;
		
		this.testCollision(getX(), getY(), this.getScene());
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1))
			this.setY(getY()+1);
		else
			this.direction = Direction.DIR_UP;
		
		this.testCollision(getX(), getY(), this.getScene());
	}
	
	@Override
	public void moveDownLeft() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()-1, this.getY()))
			this.setX(getX()-1);
		else
			this.direction = Direction.DIR_UPRIGHT;
		
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
		this.testCollision(getX(), getY(), this.getScene());
		
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