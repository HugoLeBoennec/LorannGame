package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.audio.Sfx;
import model.graphics.Sprite;
import showboard.BoardPanel;

/**
 * <h1>The Class DemonNord represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DaemonNorth extends Object implements IMobile {
	
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
	public DaemonNorth(int x, int y, final Scene scene) {
		super(Type.TYPE_DAEMON, x, y, false, new Sprite(Sprite.SPRITE_DAEMONN, 0, 1), scene);
		
		this.alive = true;
		
		// Choose a random direction :
		this.direction = Direction.randomDirection();
	}

	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()))
			this.setX(this.getX()+1);
		else
			this.direction = Direction.DIR_LEFT;
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()))
			this.setX(this.getX()-1);
		else
			this.direction = Direction.DIR_RIGHT;
	}

	@Override
	public void moveUp() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()-1))
			this.setY(this.getY()-1);
		else
			this.direction = Direction.DIR_DOWN;
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1))
			this.setY(this.getY()+1);
		else
			this.direction = Direction.DIR_UP;
	}
	
	@Override
	public void moveDownLeft() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()-1, this.getY()))
			this.setX(this.getX()-1);
		else
			this.direction = Direction.DIR_DOWNRIGHT;
		
		this.testCollision(this.getX(), this.getY(), scene);
		
		if (this.alive) {
			if (!scene.isPenetrable(this.getX(), this.getY()+1))
				this.setY(this.getY()+1);
			else
				this.direction = Direction.DIR_UPLEFT;
		}
	}
	
	@Override
	public void moveDownRight() {
		final Scene scene = this.getScene();
				
		if (!scene.isPenetrable(this.getX()+1, this.getY()))
			this.setX(this.getX()+1);
		else
			this.direction = Direction.DIR_DOWNLEFT;
		
		this.testCollision(this.getX(), this.getY(), scene);
		
		if (this.alive) {
			if (!scene.isPenetrable(this.getX(), this.getY()+1))
				this.setY(this.getY()+1);
			else
				this.direction = Direction.DIR_UPRIGHT;
		}
	}
	
	@Override
	public void moveUpLeft() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()-1, this.getY()))
			this.setX(this.getX()-1);
		else
			this.direction = Direction.DIR_UPRIGHT;
		
		this.testCollision(this.getX(), this.getY(), scene);
		
		if (this.alive) {
			if (!scene.isPenetrable(this.getX(), this.getY()-1))
				this.setY(this.getY()-1);
			else
				this.direction = Direction.DIR_DOWNLEFT;
		}
	}
	
	@Override
	public void moveUpRight() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()+1, this.getY()))
			this.setX(this.getX()+1);
		else
			this.direction = Direction.DIR_UPLEFT;
		
		this.testCollision(this.getX(), this.getY(), scene);
		
		if (this.alive) {
			if (!scene.isPenetrable(this.getX(), this.getY()-1))
				this.setY(this.getY()-1);
			else
				this.direction = Direction.DIR_DOWNRIGHT;
		}
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
		
		this.direction = Direction.randomDirection();
		
		if (character.getY() == this.getY()) {
			if (character.getX() < this.getX()) this.moveLeft();
			else this.moveRight();
		}
		else if (character.getX() == this.getX()){
			if (character.getY() < this.getY()) this.moveUp();
			else this.moveDown();
		}else {
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
		
		if (!this.alive)
			return;
		
		this.testCollision(this.getX(), this.getY(), scene);
	}
	
	@Override
	public void testCollision(final int x, final int y, final IScene scene) {
		final ICharacter character = scene.getCharacter();
		
		final Object object = (Object)scene.getObjectXY(x, y);
		final Spell spell = (Spell)character.getSpell();
		
		// Character collision :
		if (character.getX() == x && character.getY() == y) {
			((Object)character).getSprite().setAnimFrame(8);
			
			Sfx.SFX_DEATH.setFramePosition(0);
			Sfx.SFX_DEATH.start();
			
			scene.reloadLevel(true);
		}
		
		// Sortilege collision :
		if (spell.getX() == x && spell.getY() == y) {
			this.alive = false;
			this.setX(-1);
			this.setY(-1);
			
			spell.reset();
			
			BoardPanel.score += 10;
		}
		
		// Exit collision
		if (object != null) {
			if (object.getType() == Type.TYPE_EXIT) {
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