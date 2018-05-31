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
	
	Sortilege sortilege;
	
	int direction = 0;
	
	/**
     * Instantiates a new Lorann.
     */
	public Lorann(int x, int y, final Sprite sprite, final Scene scene) {
		super(x, y, true, sprite, scene);
		this.alive = true;
	}
	
	@Override
	public void moveRight() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX()+1,this.getY()).getSolidity() == true) {
			this.setX(getX()+1);
		}
		direction = 0;
	}

	@Override
	public void moveLeft() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX()-1,this.getY()).getSolidity() == true) {
			this.setX(getX()-1);
		}
		direction = 1;
	}

	@Override
	public void moveUp() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX(),this.getY()-1).getSolidity() == true) {
			this.setY(getY()+1);
		}
		direction = 2;
	}

	@Override
	public void moveDown() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX(),this.getY()+1).getSolidity() == true) {
			this.setY(getY()-1);
		}
		direction = 3;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void attaqueUp() {
		sortilege = new Sortilege(this.getX(),this.getY(),Sprite.SPRITE_SORTILEGE,this.getScene());
	}
	@Override
	public void attaqueDown() {
		sortilege = new Sortilege(this.getX(),this.getY(),Sprite.SPRITE_SORTILEGE,this.getScene());
	}
	@Override
	public void attaqueLeft() {
		sortilege = new Sortilege(this.getX(),this.getY(),Sprite.SPRITE_SORTILEGE,this.getScene());
	}
	@Override
	public void attaqueRight() {
		sortilege = new Sortilege(this.getX(),this.getY(),Sprite.SPRITE_SORTILEGE,this.getScene());
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
