package model.elements;

import model.IScene;
import showboard.IPawn;

/**
 * <h1>The Interface IMobile implements movable methods.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public interface IMobile extends IPawn {
	
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
     * Moves the mobile down and left by handling collision
     */
	public void moveDownLeft();
	
	/**
     * Moves the mobile down and right by handling collision
     */
	public void moveDownRight();
	
	/**
     * Moves the mobile up and left by handling collision
     */
	public void moveUpLeft();
	
	/**
     * Moves the mobile up and right by handling collision
     */
	public void moveUpRight();
	
	/**
     * Called when the main loop updates
     */
	public void tick();
	
	/**
     * Process the collision tests
     * 
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param scene
     *            the current scene
     */
	public void testCollision(final int x, final int y, final IScene scene);
}
