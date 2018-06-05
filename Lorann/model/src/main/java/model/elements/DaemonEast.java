package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.audio.Sfx;
import model.graphics.Sprite;
import showboard.BoardPanel;

/**
 * <h1>The Class DemonEst represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DaemonEast extends Object implements IMobile {
	
	/** If the daemon is alive */
	private boolean alive;
	
	/** The wait timer */
	private int speed;
	
	/** The duration of the timer */
	private final int speedD = 2;
	
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
	public DaemonEast(final int x, final int y, final Scene scene) {
		super(Type.TYPE_DAEMON, x, y, false, new Sprite(Sprite.SPRITE_DAEMONE, 0, 1), scene);
		this.alive = true;
		this.speed = 0;
	}
	
	@Override
	public void moveRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()))
			this.setX(this.getX()+1);
	}

	@Override
	public void moveLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()))
			this.setX(this.getX()-1);
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
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()+1)) {
			this.setY(this.getY()+1);
			this.setX(this.getX()-1);
		}else {
			moveLeft();
			moveDown();
		}
	}
	
	@Override
	public void moveDownRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()+1)) {
			this.setY(this.getY()+1);
			this.setX(this.getX()+1);
		} else {
			moveRight();
			moveDown();
		}
	}
	
	@Override
	public void moveUpLeft() {
		if (!this.getScene().isPenetrable(this.getX()-1, this.getY()-1)) {
			this.setY(this.getY()-1);
			this.setX(this.getX()-1);
		}else {
			moveUp();
			moveLeft();
		}
	}
	
	@Override
	public void moveUpRight() {
		if (!this.getScene().isPenetrable(this.getX()+1, this.getY()-1)) {
			this.setY(this.getY()-1);
			this.setX(this.getX()+1);
		}else {
			moveUp();
			moveRight();
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
		
		if (speed == 0) {
			// Follow player :
			if  (character.getX() == this.getX()) {
				if (character.getY() > this.getY())			this.moveDown();
				else										this.moveUp();
			} else if (character.getX() > this.getX()) {
				if (character.getY() == this.getY())		this.moveRight();
				else if (character.getY() > this.getY())	this.moveDownRight();
				else										this.moveUpRight();
			} else {
				if (character.getY() == this.getY())		this.moveLeft();
				else if (character.getY() > this.getY())	this.moveDownLeft();
				else										this.moveUpLeft();
			}
		}
		
		if (!this.alive)
			return;
		
		// Make the daemon waits :
		speed++;
		if (speed > speedD-1)
			speed = 0;
		
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
