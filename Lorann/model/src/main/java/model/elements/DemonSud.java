package model.elements;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Class DemonSud represents a collectable item</h1>
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
	
	@Override
	public void moveRight() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX()+1,this.getY()).getSolidity() == true) {
			this.setX(getX()+1);
		}
	}

	@Override
	public void moveLeft() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX()-1,this.getY()).getSolidity() == true) {
			this.setX(getX()-1);
		}
	}

	@Override
	public void moveUp() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX(),this.getY()-1).getSolidity() == true) {
			this.setY(getY()+1);
		}
		else this.setY(getY()-1);
	}

	@Override
	public void moveDown() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX(),this.getY()+1).getSolidity() == true) {
			this.setY(getY()-1);
		}
		else this.setY(getY()+1);
	}
	
	@Override
	public void tick() {
		if (this.getScene().getCharacter().getX() == this.getX()) {
			if (this.getScene().getCharacter().getY() < this.getY()) {
				this.moveDown();
			}
			else {
				if (this.getScene().getCharacter().getY() < this.getY()) {
					this.moveUp();
					}
				else {
					this.moveDown();
				}
			}
		}
		else if (this.getScene().getCharacter().getX() < this.getX()) {
			if (this.getScene().getCharacter().getY() < this.getY()) {
				this.moveDown();
				this.moveLeft();
			}
			else {
				this.moveDown();
				this.moveRight();
			}
		}
		else {
			if (this.getScene().getCharacter().getY() < this.getY()) {
				this.moveUp();
				this.moveLeft();
			}
			else {
				this.moveUp();
				this.moveRight();
			}
		}
	}
}