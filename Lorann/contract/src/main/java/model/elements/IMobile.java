package model.elements;

/**
 * <h1>The Interface IMobile implements movable methods.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public interface IMobile {
	
	/**
     * Moves the mobile right by handling collision
     */
	public void moveRight();
	
	/**
     * Moves the mobile left by handling collision
     */
	public void moveLeft();
	
	/**
     * Moves the mobile up by handling collision
     */
	public void moveUp();
	
	/**
     * Moves the mobile down by handling collision
     */
	public void moveDown();
	
	/**
     * Called when the main loop updates
     */
	public void tick();
}
