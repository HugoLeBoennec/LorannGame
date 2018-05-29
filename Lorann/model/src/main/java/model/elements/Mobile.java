package model.elements;

/**
 * <h1>The Class Mobile represents movable objects.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Mobile implements IMobile {
	
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
	public abstract void tick();
}
