package model.elements;

import java.awt.Point;

import model.IScene;
import model.Scene;
import model.audio.Sfx;
import model.graphics.Sprite;
import showboard.BoardFrame;
import showboard.BoardPanel;

/**
 * <h1>The Class Lorann represents the controllable character.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Lorann extends Object implements ICharacter {
	
	/** The current direction. */
	private Direction direction;
	
	/** The cast spell. */
	private Sortilege sortilege;
	
	/**
     * Instantiates a new Lorann.
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public Lorann(final int x, final int y, final Scene scene) {
		super(Type.TYPE_STATIC, x, y, false, new Sprite(Sprite.SPRITE_LORANN, 2, 8), scene);
		
		this.direction = Direction.DIR_RIGHT;
		this.sortilege = new Sortilege(-1, -1, scene);
	}
	
	/**
     * Initiate the spell.
     * 
     * @param frame
     *            the drawing frame
     */
	public void initiate(final BoardFrame frame) {
		frame.addPawn(this.sortilege);
	}
	
	/**
     * Reset the character.
     * 
     */
	public void reset() {
		this.direction = Direction.DIR_RIGHT;
		this.sortilege.reset();
	}
	
	@Override
	public void moveRight() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()+1, this.getY())) {
			this.setX(this.getX()+1);
			this.testCollision(this.getX(), this.getY(), scene);
		}
		
		this.direction = Direction.DIR_RIGHT;
	}

	@Override
	public void moveLeft() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()-1, this.getY())) {
			this.setX(this.getX()-1);
			this.testCollision(this.getX(), this.getY(), scene);
		}
		
		this.direction = Direction.DIR_LEFT;
	}

	@Override
	public void moveUp() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX(), this.getY()-1)) {
			this.setY(this.getY()-1);
			this.testCollision(this.getX(), this.getY(), scene);
		}
		
		this.direction = Direction.DIR_UP;
	}

	@Override
	public void moveDown() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX(), this.getY()+1)) {
			this.setY(this.getY()+1);
			this.testCollision(this.getX(), this.getY(), scene);
		}
		
		this.direction = Direction.DIR_DOWN;
	}
	
	@Override
	public void moveDownLeft() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()-1, this.getY()+1)) {
			this.setX(this.getX()-1);
			this.setY(this.getY()+1);
			this.testCollision(this.getX(), this.getY(), scene);
		}
		
		this.direction = Direction.DIR_DOWNLEFT;
	}
	
	@Override
	public void moveDownRight() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()+1, this.getY()+1)) {
			this.setX(this.getX()+1);
			this.setY(this.getY()+1);
			this.testCollision(this.getX(), this.getY(), scene);
		}
		
		this.direction = Direction.DIR_DOWNRIGHT;
	}
	
	@Override
	public void moveUpLeft() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()-1, this.getY()-1)) {
			this.setX(this.getX()-1);
			this.setY(this.getY()-1);
			this.testCollision(this.getX(), this.getY(), scene);
		}
		
		this.direction = Direction.DIR_UPLEFT;
	}
	
	@Override
	public void moveUpRight() {
		final Scene scene = this.getScene();
		
		if (!scene.isPenetrable(this.getX()+1, this.getY()-1)) {
			this.setX(this.getX()+1);
			this.setY(this.getY()-1);
			this.testCollision(this.getX(), this.getY(), scene);
		}
		
		this.direction = Direction.DIR_UPRIGHT;
	}
	
	@Override
	public void tick() {
		this.getSprite().animate();
		
		// Update the spell only if cast :
		if (this.sortilege.isCast())
			this.sortilege.tick();
	}
	
	@Override
	public void attaque() {
		this.sortilege.cast(this.getX(), this.getY(), this.direction);
	}
	
	@Override
	public IObject getSortilege() {
		return this.sortilege;
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
	
	@Override
	public void testCollision(final int x, final int y, final IScene scene) {
		final Object object = (Object)scene.getObjectXY(x, y);
		
		// Test if the object is null :
		if (object == null)
			return;
		
		final Sprite spr = object.getSprite();
		
		switch (object.getType()) {
			// Collision with the purse :
			case TYPE_BOURSE	:
				if (spr.getAnimFrame() == 0) {
					spr.setAnimFrame(1);
					
					Sfx.SFX_PURSE.setFramePosition(0);
					Sfx.SFX_PURSE.start();
					
					BoardPanel.score++;
				}
				
				break;
			// Collision with the bubble :
			case TYPE_BULLE		:
				if (spr.getAnimFrame() == 0) {
					spr.setAnimFrame(1);
					((Scene)scene).getObjectOfType(Type.TYPE_SORTIE).getSprite().setAnimFrame(1);
					
					Sfx.SFX_BUBBLE.setFramePosition(0);
					Sfx.SFX_BUBBLE.start();
					
					BoardPanel.score += 5;
				}
				
				break;
			// Collision with the purse :
			case TYPE_SORTIE	:
				if (spr.getAnimFrame() == 0) {
					this.getSprite().setAnimFrame(8);
					
					Sfx.SFX_DEATH.setFramePosition(0);
					Sfx.SFX_DEATH.start();
					
					scene.reloadLevel(true);
				}
				else {
					scene.setCurrentLevel(scene.getCurrentLevel()+1);
					scene.reloadLevel(true);
				}
					
				break;
			default : break;
		}
	}
}
