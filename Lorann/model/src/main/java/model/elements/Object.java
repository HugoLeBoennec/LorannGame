package model.elements;

import model.graphics.Sprite;

/**
 * <h1>The Interface Object implements placeable object.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public abstract class Object implements IObject {
	
	/** The X position. */
	public int x;
	
	/** The Y position. */
	public int y;
	
	/** The solidity. */
	public boolean solid;
	
	/** The sprite. */
	public Sprite sprite;
	
	/**
     * Instantiates a new object.
     *
     * @param sprite
     *            the sprite
     */
    public Object(int x, int y, boolean solid, final Sprite sprite) {
    	this.x = x;
    	this.x = y;
    	this.solid = solid;
        this.sprite = sprite;
    }
	
	/**
     * Gets the X position.
     *
     * @return the X position
     */
	public int getX() {
		return this.x;
	}
	
	/**
     * Sets the X position.
     *
     * @param x
     *            the X position
     */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
     * Gets the Y position.
     *
     * @return the Y position
     */
	public int getY() {
		return this.y;
	}
	
	/**
     * Sets the Y position.
     *
     * @param y
     *            the Y position
     */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
     * Gets the solidity.
     *
     * @return the solidity
     */
	public boolean getSolidity() {
		return this.solid;
	}
	
	/**
     * Sets the solidity.
     *
     * @param solid
     *            the solidity
     */
	public void setSolidity(boolean solid) {
		this.solid = solid;
	}
}
