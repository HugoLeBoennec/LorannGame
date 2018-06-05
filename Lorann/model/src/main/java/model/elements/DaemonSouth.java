package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.audio.Sfx;
import model.graphics.Sprite;
import showboard.BoardPanel;

/**
 * <h1>The Class DemonSud represents a collectable item</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DaemonSouth extends Object implements IMobile {
	
	/** If the daemon is alive */
	private boolean alive;

	/** If the daemon moves down. */
	private boolean isDown;
	
	/**
     * Instantiates a new DemonSud.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public DaemonSouth(final int x, final int y, final Scene scene) {
		super(Type.TYPE_DAEMON, x, y, false, new Sprite(Sprite.SPRITE_DAEMONS, 0, 1), scene);
		
		this.alive = true;
		this.isDown = true;
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
		else
			this.isDown = true;
	}

	@Override
	public void moveDown() {
		if (!this.getScene().isPenetrable(this.getX(), this.getY()+1))
			this.setY(this.getY()+1);
		else
			this.isDown = false;
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
		
		// Vertical moves, bounce on walls :
		if (this.isDown)
			this.moveDown();
		else
			this.moveUp();
		
		this.testCollision(this.getX(), this.getY(), scene);
		
		if (!this.alive)
			return;
		
		// Horizontal moves, follow player :
		if (character.getX() < this.getX())
			this.moveLeft();
		else if (character.getX() > this.getX())
			this.moveRight();
		
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