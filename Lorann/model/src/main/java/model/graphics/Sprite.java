package model.graphics;

import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * <h1>The Class Sprite contains one or more images.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Sprite {

	/** The images of Lorann. */
	static public ArrayList<Image> SPRITE_LORANN;
	
	/** The images of the spell. */
	static public ArrayList<Image> SPRITE_SPELL;
	
	/** The images of the key. */
	static public ArrayList<Image> SPRITE_KEY;
	
	/** The images of the door. */
	static public ArrayList<Image> SPRITE_DOOR;
	
	/** The images of the wall. */
	static public ArrayList<Image> SPRITE_WALL;
	
	/** The images of the horizontal floor. */
	static public ArrayList<Image> SPRITE_BONEH;
	
	/** The images of the vertical floor. */
	static public ArrayList<Image> SPRITE_BONEV;
	
	/** The images of the north daemon. */
	static public ArrayList<Image> SPRITE_DAEMONN;
	
	/** The images of the west daemon. */
	static public ArrayList<Image> SPRITE_DAEMONW;
	
	/** The images of the east daemon. */
	static public ArrayList<Image> SPRITE_DAEMONE;
	
	/** The images of the south daemon. */
	static public ArrayList<Image> SPRITE_DAEMONS;
	
	/** The images of the collectable purse. */
	static public ArrayList<Image> SPRITE_COIN;
	
	/** The images of the empty tile. */
	static public ArrayList<Image> SPRITE_EMPTY;
	
	
	/** The multiple images. */
	private ArrayList<Image> image;
	
	/** The animation speed. Set it to 0 if no animation. */
	private int animVitesse;
	
	/** The animation number of images. */
	private int animNumber;
	
	/** The animation current frame. */
	private int animFrame;
	
	/** The animation timer. */
	private int animTimer;
	
	/**
     * Instantiates a new Sprite.
     *
     * @param animSpeed
     *            the animation speed
     */
	public Sprite(final ArrayList<Image> imageList, final int animVitesse, final int animNumber) {
		this.image = imageList;
		this.animVitesse = animVitesse;
		this.animNumber = animNumber-1;
		this.animFrame = 0;
		this.animTimer = 0;
	}
	
	/**
     * Append a new image to the Sprite
     *
     * @param image
     *            the image
     */
	public void appendImage(final Image image) {
		this.image.add(image);
	}
	
	/**
	 * Gets an image from the list
	 * 
	 * @param number
     *            the image number
	 * @return the image
	 */
	public Image getImage(final int number) {
		return this.image.get(number);
	}
	
	/**
	 * Sets an image of the list
	 * 
	 * @param number
     *            the image number
     * @param image
     *            the image
	 */
	public Image setImage(final int number, final Image image) {
		return this.image.set(number, image);
	}

	/**
	 * Gets the animation speed
	 * 
	 * @return the animation speed
	 */
	public int getAnimVitesse() {
		return this.animVitesse;
	}

	/**
	 * Sets the animation speed
	 * 
	 * @param animVitesse the animation speed to set
	 */
	public void setAnimVitesse(final int animVitesse) {
		this.animVitesse = animVitesse;
	}
	
	/**
	 * Gets the number of images
	 * 
	 * @return the number of images
	 */
	public int getAnimNumber() {
		return this.animNumber;
	}

	/**
	 * Sets the number of images
	 * 
	 * @param animNumber number of images
	 */
	public void setAnimNumber(final int animNumber) {
		this.animNumber = animNumber-1;
	}
	
	/**
	 * Gets the animation frame
	 * 
	 * @return the animation frame
	 */
	public int getAnimFrame() {
		return this.animFrame;
	}

	/**
	 * Sets the animation frame
	 * 
	 * @param animFrame the animation frame
	 */
	public void setAnimFrame(final int animFrame) {
		this.animFrame = animFrame;
	}
	
	/** Process the animation **/
	public void animate() {
		if (this.animTimer < this.animVitesse)
			this.animTimer++;
		else {
			if (this.animFrame < this.animNumber)
				this.animFrame++;
			else
				this.animFrame = 0;
			
			this.animTimer = 0;
		}
	}

	/**
     * Load all the sprites
	 * @throws IOException
     *
     */
	static public void LoadSprite() throws IOException {
		SPRITE_LORANN = new ArrayList<Image>();
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_r.png")));
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_br.png")));
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_b.png")));
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_bl.png")));
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_l.png")));
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_ul.png")));
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_u.png")));
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_ur.png")));
		SPRITE_LORANN.add(ImageIO.read(new File("sprites/lorann_d.png")));
		
		SPRITE_EMPTY = new ArrayList<Image>();
		SPRITE_EMPTY.add(ImageIO.read(new File("sprites/empty.png")));
		
		SPRITE_SPELL = new ArrayList<Image>();
		SPRITE_SPELL.add(ImageIO.read(new File("sprites/fireball_1.png")));
		SPRITE_SPELL.add(ImageIO.read(new File("sprites/fireball_2.png")));
		SPRITE_SPELL.add(ImageIO.read(new File("sprites/fireball_3.png")));
		SPRITE_SPELL.add(ImageIO.read(new File("sprites/fireball_4.png")));
		
		SPRITE_KEY = new ArrayList<Image>();
		SPRITE_KEY.add(ImageIO.read(new File("sprites/crystal_ball.png")));
		SPRITE_KEY.add(SPRITE_EMPTY.get(0));
		
		SPRITE_DOOR = new ArrayList<Image>();
		SPRITE_DOOR.add(ImageIO.read(new File("sprites/gate_closed.png")));
		SPRITE_DOOR.add(ImageIO.read(new File("sprites/gate_open.png")));
		
		SPRITE_WALL = new ArrayList<Image>();
		SPRITE_WALL.add(ImageIO.read(new File("sprites/bone.png")));
		
		SPRITE_BONEH = new ArrayList<Image>();
		SPRITE_BONEH.add(ImageIO.read(new File("sprites/horizontal_bone.png")));
		
		SPRITE_BONEV = new ArrayList<Image>();
		SPRITE_BONEV.add(ImageIO.read(new File("sprites/vertical_bone.png")));
		
		SPRITE_DAEMONN = new ArrayList<Image>();
		SPRITE_DAEMONN.add(ImageIO.read(new File("sprites/monster_1.png")));
		
		SPRITE_DAEMONW = new ArrayList<Image>();
		SPRITE_DAEMONW.add(ImageIO.read(new File("sprites/monster_2.png")));
		
		SPRITE_DAEMONE = new ArrayList<Image>();
		SPRITE_DAEMONE.add(ImageIO.read(new File("sprites/monster_3.png")));
		
		SPRITE_DAEMONS = new ArrayList<Image>();
		SPRITE_DAEMONS.add(ImageIO.read(new File("sprites/monster_4.png")));
		
		SPRITE_COIN = new ArrayList<Image>();
		SPRITE_COIN.add(ImageIO.read(new File("sprites/purse.png")));
		SPRITE_COIN.add(SPRITE_EMPTY.get(0));
	}
}
