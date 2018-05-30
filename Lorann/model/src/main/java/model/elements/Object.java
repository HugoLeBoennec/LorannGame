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
	
	/** The Scene. */
	public int level;
	
	/**
     * Instantiates a new object.
     *
     * @param sprite
     *            the sprite
     */
    public Object(int x, int y, boolean solid, final Sprite sprite, int level) {
    	this.x = x;
    	this.x = y;
    	this.solid = solid;
        this.sprite = sprite;
        this.level = level;
    }
	
	/**
     * Gets the sprite.
     *
     * @return the sprite
     */
	public Sprite getSprite() {
		return this.sprite;
	}
	
	/**
     * Sets the sprite.
     *
     * @param sprite
     *            the sprite
     */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean getSolidity() {
		return this.solid;
	}
	
	public void setSolidity(boolean solid) {
		this.solid = solid;
	}
}
