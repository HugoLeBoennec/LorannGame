package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class DemonEst represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonEst extends Object implements IMobile {
	
	/**
     * Instantiates a new DemonEst.
     */
	public DemonEst(int x, int y, final Sprite sprite, Scene scene) {
		super(x, y, true, sprite,scene);
	}
	
	@Override
	public void moveRight() {
		if (this.scene.getObjectXY(this.getX()+1,this.getY(),scene).getSolidity() == true) {
			this.setX(getX()+1);
		}
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
	}
}
