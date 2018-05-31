package model.elements;

import java.awt.Point;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class Mobile represents a powerful spell.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Sortilege extends Object implements IMobile {
	
	private int direction; 
	/**
     * Instantiates a new Sortilege.
     */
	public Sortilege(int x, int y, final Sprite sprite, final Scene scene) {
		super(x, y, true, sprite, scene);
		this.direction = this.getScene().getCharacter().getDirection();
	}
	
	

	@Override
	public void moveRight() {
		this.setX(getX()+1);
	}

	@Override
	public void moveLeft() {
		this.setX(getX()-1);
	}

	@Override
	public void moveUp() {
		this.setY(getY()+1);
	}

	@Override
	public void moveDown() {
		this.setY(getY()-1);
	}

	@Override
	public void tick() {
		if (direction == 0) {
			if (this.getScene().getObjectXY(this.getX()+1,this.getY()).getSolidity() == true) {
				direction = 1;
				this.setX(getX()+1);
			}
			else this.setX(getX()-1);
		}else if (direction == 1) {
			if (this.getScene().getObjectXY(this.getX()-1,this.getY()).getSolidity() == true) {
				direction = 0;
				this.setX(getX()-1);
			}
			else this.setX(getX()+1);
		}else if (direction == 2) {
			if (this.getScene().getObjectXY(this.getX(),this.getY()+1).getSolidity() == true) {
				direction = 3;
				this.setY(getY()+1);
			}
			else this.setY(getY()-1);
		}else if (direction == 3) {
			if (this.getScene().getObjectXY(this.getX()+1,this.getY()).getSolidity() == true) {
				direction = 2;
				this.setY(getY()-1);
			}
			else this.setY(getY()+1);
		}
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
