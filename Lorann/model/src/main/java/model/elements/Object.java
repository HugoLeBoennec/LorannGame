package model.elements;

import java.awt.Image;

import model.Scene;
import model.graphics.Sprite;

/**
 * <h1>The Interface Object implements placeable object.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public abstract class Object implements IObject {
	
	/** The X position. */
	private int x;
	
	/** The Y position. */
	private int y;
	
	/** The solidity. */
	private boolean solid;
	
	/** The sprite. */
	private Sprite sprite;
	
	/** The scene. */
	private final Scene scene;
	
	/**
     * Instantiates a new object.
     *
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @param solid
     *            the solidity
     * @param sprite
     *            the sprite
     * @param scene
     *            the current scene
     */
    public Object(int x, int y, boolean solid, final Sprite sprite, final Scene scene) {
    	this.x = x;
    	this.x = y;
    	this.solid = solid;
        this.sprite = sprite;
        this.scene = scene;
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
	
	/**
     * Gets the scene.
     *
     * @return the scene
     */
	public Scene getScene() {
		return this.scene;
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
	
	@Override
	public Image getImage() {
		return this.sprite.getImage(this.sprite.getAnimFrame());
	}
}
