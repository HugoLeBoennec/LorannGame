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
	
	boolean temporaire_mur = false;
	/**
     * Instantiates a new DemonEst.
     */
	public DemonEst(int x, int y, final Sprite sprite, Scene scene) {
		super(x, y, true, sprite,scene);
	}
	
	@Override
	public void moveRight() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX()+1,this.getY(), scene).getSolidity() == true) {
			this.setX(getX()+1);
		}
		else this.temporaire_mur = !this.temporaire_mur;
	}

	@Override
	public void moveLeft() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX()-1,this.getY(), scene).getSolidity() == true) {
			this.setX(getX()-1);
		}
		else this.temporaire_mur = !this.temporaire_mur;
	}

	@Override
	public void moveUp() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX(),this.getY()-1, scene).getSolidity() == true) {
			this.setY(getY()+1);
		}
		else this.temporaire_mur = !this.temporaire_mur;
	}

	@Override
	public void moveDown() {
		final Scene scene = this.getScene();
		if (scene.getObjectXY(this.getX(),this.getY()+1, scene).getSolidity() == true) {
			this.setY(getY()-1);
		}
		else this.temporaire_mur = !this.temporaire_mur;
	}
	
	@Override
	public void tick() {
		if (this.getScene().getCharacter.getY() == this.getY()) {
			if (this.temporaire_mur == false) {
				if (this.getScene().getCharacter.getX() < this.getX()) {
				this.moveLeft();
				}else this.moveRight();
			}
			else {
				if (this.getScene().getCharacter.getX() < this.getX()) {
					this.moveRight();
					}else this.moveLeft();
			}
		}
		else if (this.getScene().getCharacter.getY() <= this.getY()) {
			if (this.temporaire_mur == false) {
				if (this.getScene().getCharacter.getX() < this.getX()) {
					this.moveLeft();
					this.moveDown();
				}
				else {
					this.moveLeft();
					this.moveUp();
				}
			}
			else {
				if (this.getScene().getCharacter.getX() < this.getX()) {
					this.moveLeft();
					this.moveUp();
				}
				else {
					this.moveLeft();
					this.moveDown();
				}
			}
		}
		else {
			if (this.temporaire_mur == false) {
				if (this.getScene().getCharacter.getX() < this.getX()) {
					this.moveRight();
					this.moveDown();
				}
				else {
					this.moveRight();
					this.moveUp();
				}
			}
			else {
				if (this.getScene().getCharacter.getX() < this.getX()) {
					this.moveRight();
					this.moveUp();
				}
				else {
					this.moveRight();
					this.moveDown();
				}
			}
		}
	}
}
