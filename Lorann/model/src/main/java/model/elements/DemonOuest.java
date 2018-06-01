package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class DemonOuest represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonOuest extends Object implements IMobile {

	/** If the daemon moves right. */
	private boolean isRight;
	
	/**
     * Instantiates a new DemonOuest.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public DemonOuest(final int x, final int y, final Scene scene) {
		super(Type.TYPE_DAEMON, x, y, false, new Sprite(Sprite.SPRITE_DEMONW, 0), scene);
		
		this.isRight = true;
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()))
			this.setX(getX()+1);
		else
			this.isRight = false;
		
		this.testCollision(getX(), getY(), this.getScene());
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()))
			this.setX(getX()-1);
		else
			this.isRight = true;
		
		this.testCollision(getX(), getY(), this.getScene());
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1))
			this.setY(getY()-1);
		
		this.testCollision(getX(), getY(), this.getScene());
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1))
			this.setY(getY()+1);
		
		this.testCollision(getX(), getY(), this.getScene());
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
	public void testCollision(final int x, final int y, final IScene scene) {
		Object object = (Object)scene.getObjectXY(x, y);
		ICharacter character = scene.getCharacter();
		
		// Test if the object is null :
		if (object == null)
			return;
		
		if (character.getX() == this.getX() && character.getY() == this.getY())
			scene.reloadLevel(true);
		
		if (object.getType() == Type.TYPE_SORTIE) {
			if (object.getSprite().getAnimFrame() == 0) {
				
			}
		}
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}