package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.graphics.Sprite;
import showboard.BoardPanel;

/**
 * <h1>The Class DemonOuest represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonOuest extends Object implements IMobile {
	
	/** If the daemon is alive */
	private boolean alive;

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
		super(Type.TYPE_DAEMON, x, y, false, new Sprite(Sprite.SPRITE_DEMONW, 0, 1), scene);
		
		this.alive = true;
		this.isRight = true;
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()))
			this.setX(this.getX()+1);
		else
			this.isRight = false;
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()))
			this.setX(this.getX()-1);
		else
			this.isRight = true;
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1))
			this.setY(this.getY()-1);
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1))
			this.setY(this.getY()+1);
	}
	
	@Override
	public void moveDownLeft() {
	}
	
	@Override
	public void moveDownRight() {
	}
	
	@Override
	public void moveUpLeft() {
	}
	
	@Override
	public void moveUpRight() {
	}
	
	@Override
	public void tick() {
		if (!this.alive)
			return;
		
		final Scene scene = this.getScene();
		final ICharacter character = scene.getCharacter();
		
		this.testCollision(this.getX(), this.getY(), scene);
		
		if (!this.alive)
			return;
		
		// Vertical moves, follow player :
		if (character.getY() < this.getY())
			this.moveUp();
		else if (character.getY() > this.getY())
			this.moveDown();
		
		this.testCollision(this.getX(), this.getY(), scene);
		
		if (!this.alive)
			return;
		
		// Horizontal moves, bounce on walls :
		if (this.isRight)
			this.moveRight();
		else
			this.moveLeft();
		
		this.testCollision(this.getX(), this.getY(), scene);
	}
	
	@Override
	public void testCollision(final int x, final int y, final IScene scene) {
		final ICharacter character = scene.getCharacter();
		
		final Object object = (Object)scene.getObjectXY(x, y);
		final Sortilege sortilege = (Sortilege)character.getSortilege();
		
		// Character collision :
		if (character.getX() == x && character.getY() == y) {
			((Object)character).getSprite().setAnimFrame(8);
			scene.reloadLevel(true);
		}
		
		// Sortilege collision :
		if (sortilege.getX() == x && sortilege.getY() == y) {
			this.alive = false;
			this.setX(-1);
			this.setY(-1);
			
			sortilege.reset();
			
			BoardPanel.score += 10;
		}
		
		// Exit collision
		if (object != null) {
			if (object.getType() == Type.TYPE_SORTIE) {
				this.alive = false;
				this.setX(-1);
				this.setY(-1);
				
				BoardPanel.score += 5;
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