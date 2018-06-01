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
	static public ArrayList<Image> SPRITE_SORTILEGE;
	
	/** The images of the energy bubble. */
	static public ArrayList<Image> SPRITE_BULLE;
	
	/** The images of the door. */
	static public ArrayList<Image> SPRITE_PORTE;
	
	/** The images of the wall. */
	static public ArrayList<Image> SPRITE_MUR;
	
	/** The images of the horizontal floor. */
	static public ArrayList<Image> SPRITE_SOLH;
	
	/** The images of the vertical floor. */
	static public ArrayList<Image> SPRITE_SOLV;
	
	/** The images of the north daemon. */
	static public ArrayList<Image> SPRITE_DEMONN;
	
	/** The images of the west daemon. */
	static public ArrayList<Image> SPRITE_DEMONW;
	
	/** The images of the east daemon. */
	static public ArrayList<Image> SPRITE_DEMONE;
	
	/** The images of the south daemon. */
	static public ArrayList<Image> SPRITE_DEMONS;
	
	/** The images of the collectable purse. */
	static public ArrayList<Image> SPRITE_BOURSE;
	
	/** The images of the empty tile. */
	static public ArrayList<Image> SPRITE_VIDE;
	
	
	/** The multiple images. */
	private ArrayList<Image> image;
	
	/** The animation speed. Set it to 0 if no animation. */
	private int animVitesse;
	
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
	public Sprite(final ArrayList<Image> imageList, final int animVitesse) {
		this.image = imageList;
		this.animVitesse = animVitesse;
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
			if (this.animFrame < this.image.size()-1)
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
		
		SPRITE_VIDE = new ArrayList<Image>();
		SPRITE_VIDE.add(ImageIO.read(new File("sprites/empty.png")));
		
		SPRITE_SORTILEGE = new ArrayList<Image>();
		SPRITE_SORTILEGE.add(ImageIO.read(new File("sprites/fireball_1.png")));
		SPRITE_SORTILEGE.add(ImageIO.read(new File("sprites/fireball_2.png")));
		SPRITE_SORTILEGE.add(ImageIO.read(new File("sprites/fireball_3.png")));
		SPRITE_SORTILEGE.add(ImageIO.read(new File("sprites/fireball_4.png")));
		SPRITE_SORTILEGE.add(ImageIO.read(new File("sprites/fireball_5.png")));
		
		SPRITE_BULLE = new ArrayList<Image>();
		SPRITE_BULLE.add(ImageIO.read(new File("sprites/crystal_ball.png")));
		SPRITE_BULLE.add(SPRITE_VIDE.get(0));
		
		SPRITE_PORTE = new ArrayList<Image>();
		SPRITE_PORTE.add(ImageIO.read(new File("sprites/gate_closed.png")));
		SPRITE_PORTE.add(ImageIO.read(new File("sprites/gate_open.png")));
		
		SPRITE_MUR = new ArrayList<Image>();
		SPRITE_MUR.add(ImageIO.read(new File("sprites/bone.png")));
		
		SPRITE_SOLH = new ArrayList<Image>();
		SPRITE_SOLH.add(ImageIO.read(new File("sprites/horizontal_bone.png")));
		
		SPRITE_SOLV = new ArrayList<Image>();
		SPRITE_SOLV.add(ImageIO.read(new File("sprites/vertical_bone.png")));
		
		SPRITE_DEMONN = new ArrayList<Image>();
		SPRITE_DEMONN.add(ImageIO.read(new File("sprites/monster_1.png")));
		
		SPRITE_DEMONW = new ArrayList<Image>();
		SPRITE_DEMONW.add(ImageIO.read(new File("sprites/monster_2.png")));
		
		SPRITE_DEMONE = new ArrayList<Image>();
		SPRITE_DEMONE.add(ImageIO.read(new File("sprites/monster_3.png")));
		
		SPRITE_DEMONS = new ArrayList<Image>();
		SPRITE_DEMONS.add(ImageIO.read(new File("sprites/monster_4.png")));
		
		SPRITE_BOURSE = new ArrayList<Image>();
		SPRITE_BOURSE.add(ImageIO.read(new File("sprites/purse.png")));
		SPRITE_BOURSE.add(SPRITE_VIDE.get(0));
	}
}
