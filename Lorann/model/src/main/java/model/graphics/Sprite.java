package model.graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The Class Sprite contains one or more images.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Sprite {

	/** The sprites of Lorann. */
	static public Sprite SPRITE_LORANN;
	
	/** The sprites of the spell. */
	static public Sprite SPRITE_SORTILEGE;
	
	/** The sprite of the energy bubble. */
	static public Sprite SPRITE_BULLE;
	
	/** The sprites of the door. */
	static public Sprite SPRITE_PORTE;
	
	/** The sprite of the wall. */
	static public Sprite SPRITE_MUR;
	
	/** The sprite of the horizontal floor. */
	static public Sprite SPRITE_SOLH;
	
	/** The sprite of the vertical floor. */
	static public Sprite SPRITE_SOLV;
	
	/** The sprite of the north daemon. */
	static public Sprite SPRITE_DEMONN;
	
	/** The sprite of the west daemon. */
	static public Sprite SPRITE_DEMONW;
	
	/** The sprite of the east daemon. */
	static public Sprite SPRITE_DEMONE;
	
	/** The sprite of the south daemon. */
	static public Sprite SPRITE_DEMONS;
	
	/** The sprite of the collectable purse. */
	static public Sprite SPRITE_BOURSE;
	
	
	/** The multiple images. */
	java.util.ArrayList<Image> image;
	
	/** The animation speed. Set it to 0 if no animation. */
	int animSpeed;
	
	/**
     * Instantiates a new Sprite.
     *
     * @param animSpeed
     *            the animation speed
     */
	public Sprite(int animSpeed) {
		this.animSpeed = animSpeed;
	}
	
	/**
     * Append a new image to the Sprite
     *
     * @param image
     *            the image
     */
	public void appendImage(Image image) {
		this.image.add(image);
	}
	
	/**
     * Load all the sprites
	 * @throws IOException
     *
     */
	static public void LoadSprite() throws IOException {
		SPRITE_LORANN = new Sprite(0);
		SPRITE_LORANN.appendImage(ImageIO.read(new File("sprites/lorann_r.png")));
		SPRITE_LORANN.appendImage(ImageIO.read(new File("sprites/lorann_br.png")));
		SPRITE_LORANN.appendImage(ImageIO.read(new File("sprites/lorann_b.png")));
		SPRITE_LORANN.appendImage(ImageIO.read(new File("sprites/lorann_bl.png")));
		SPRITE_LORANN.appendImage(ImageIO.read(new File("sprites/lorann_l.png")));
		SPRITE_LORANN.appendImage(ImageIO.read(new File("sprites/lorann_ul.png")));
		SPRITE_LORANN.appendImage(ImageIO.read(new File("sprites/lorann_u.png")));
		SPRITE_LORANN.appendImage(ImageIO.read(new File("sprites/lorann_ur.png")));
		
		SPRITE_SORTILEGE = new Sprite(4);
		SPRITE_SORTILEGE.appendImage(ImageIO.read(new File("sprites/fireball_1.png")));
		SPRITE_SORTILEGE.appendImage(ImageIO.read(new File("sprites/fireball_2.png")));
		SPRITE_SORTILEGE.appendImage(ImageIO.read(new File("sprites/fireball_3.png")));
		SPRITE_SORTILEGE.appendImage(ImageIO.read(new File("sprites/fireball_4.png")));
		SPRITE_SORTILEGE.appendImage(ImageIO.read(new File("sprites/fireball_5.png")));
		
		SPRITE_BULLE = new Sprite(0);
		SPRITE_BULLE.appendImage(ImageIO.read(new File("sprites/crystal_ball.png")));
		
		SPRITE_PORTE = new Sprite(0);
		SPRITE_PORTE.appendImage(ImageIO.read(new File("sprites/gate_closed.png")));
		SPRITE_PORTE.appendImage(ImageIO.read(new File("sprites/gate_open.png")));
		
		SPRITE_MUR = new Sprite(0);
		SPRITE_MUR.appendImage(ImageIO.read(new File("sprites/bone.png")));
		
		SPRITE_SOLH = new Sprite(0);
		SPRITE_SOLH.appendImage(ImageIO.read(new File("sprites/horizontal_bone.png")));
		
		SPRITE_SOLV = new Sprite(0);
		SPRITE_SOLV.appendImage(ImageIO.read(new File("sprites/vertical_bone.png")));
		
		SPRITE_DEMONN = new Sprite(0);
		SPRITE_DEMONN.appendImage(ImageIO.read(new File("sprites/monster_1.png")));
		
		SPRITE_DEMONW = new Sprite(0);
		SPRITE_DEMONW.appendImage(ImageIO.read(new File("sprites/monster_2.png")));
		
		SPRITE_DEMONE = new Sprite(0);
		SPRITE_DEMONE.appendImage(ImageIO.read(new File("sprites/monster_3.png")));
		
		SPRITE_DEMONS = new Sprite(0);
		SPRITE_DEMONS.appendImage(ImageIO.read(new File("sprites/monster_4.png")));
		
		SPRITE_BOURSE = new Sprite(0);
		SPRITE_BOURSE.appendImage(ImageIO.read(new File("sprites/purse.png")));
	}
}
