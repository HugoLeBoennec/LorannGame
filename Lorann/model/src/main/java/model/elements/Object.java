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
	
	/** The object type. */
	private final Type type;
	
	/** The X position. */
	private int x;
	
	/** The Y position. */
	private int y;
	
	/** The solidity. */
	private boolean solid;
	
	/** The sprite. */
	private Sprite sprite;
<<<<<<< HEAD
=======
	
	/** The scene. */
	private Scene scene;
>>>>>>> Save-Branch
	
	/**
     * Instantiates a new object.
     *
     * @param type
     *            the object type
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
    public Object(final Type type, final int x, final int y, final boolean solid, final Sprite sprite, final Scene scene) {
    	this.type = type;
    	this.x = x;
    	this.y = y;
    	this.solid = solid;
        this.sprite = sprite;
        this.scene = scene;
    }
    
    /**
     * Gets the object type.
     *
     * @return the type
     */
	public Type getType() {
		return this.type;
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
	public void setSprite(final Sprite sprite) {
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
	
	@Override
	public int getX() {
		return this.x;
	}
	
	@Override
	public void setX(final int x) {
		this.x = x;
	}
	
	@Override
	public int getY() {
		return this.y;
	}
	
	@Override
	public void setY(final int y) {
		this.y = y;
	}
	
	@Override
	public boolean getSolidity() {
		return this.solid;
	}
	
	@Override
	public void setSolidity(final boolean solid) {
		this.solid = solid;
	}
	
	@Override
	public Image getImage() {
		return this.sprite.getImage(this.sprite.getAnimFrame());
	}
}
