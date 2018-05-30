package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class DemonSud represents a collectable item.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class DemonSud extends Object implements IMobile {

	/**
     * Instantiates a new DemonSud.
     */
	public DemonSud(int x, int y, final Sprite sprite, Scene scene) {
		super(x, y, true, sprite,scene);
	}
	/**
     * Define moveRight().
     */
	@Override
	public void moveRight() {
		if (this.scene.getObjectXY(this.getX()+1,this.getY(),scene).getSolidity() == true) {
			this.setX(getX()+1);
		}
	}

	/**
     * Define moveLeft().
     */
	@Override
	public void moveLeft() {
		if (this.scene.getObjectXY(this.getX()-1,this.getY(),scene).getSolidity() == true) {
			this.setX(getX()-1);
		}
	}

	/**
     * Define moveUp().
     */
	@Override
	public void moveUp() {
		if (this.scene.getObjectXY(this.getX(),this.getY()+1,scene).getSolidity() == true) {
			this.setY(getY()+1);
		}
	}

	/**
     * Define moveDown().
     */
	@Override
	public void moveDown() {
		if (this.scene.getObjectXY(this.getX(),this.getY()-1,scene).getSolidity() == true) {
			this.setY(getY()-1);
		}
	}
	
	@Override
	public void tick() {
	}
}
