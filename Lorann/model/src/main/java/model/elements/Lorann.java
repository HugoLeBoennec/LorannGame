package model.elements;

import java.awt.Point;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Lorann represents the controllable character.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Lorann extends Object implements ICharacter {
	
	/** The life state. */
	private boolean alive;
	
	/** The current direction. */
	private int direction;
	
	/** The spell. */
	private Sortilege sortilege;
	
	/**
     * Instantiates a new Lorann.
     */
	public Lorann(int x, int y, final Scene scene) {
		super(x, y, true, Sprite.SPRITE_LORANN, scene);
		this.direction = 0;
		this.alive = true;
	}
	
	@Override
	public void moveRight() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX()+1,this.getY()).getSolidity() == true) {
			this.setX(getX()+1);
		}
		this.direction = 0;
	}

	@Override
	public void moveLeft() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX()-1,this.getY()).getSolidity() == true) {
			this.setX(getX()-1);
		}
		this.direction = 1;
	}

	@Override
	public void moveUp() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX(),this.getY()-1).getSolidity() == true) {
			this.setY(getY()+1);
		}
		this.direction = 2;
	}

	@Override
	public void moveDown() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX(),this.getY()+1).getSolidity() == true) {
			this.setY(getY()-1);
		}
		this.direction = 3;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void attaque() {
		this.sortilege = new Sortilege(this.getX(), this.getY(), this.direction, this.getScene());
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
