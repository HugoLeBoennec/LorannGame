package model;

import java.io.IOException;
import java.sql.SQLException;

import model.dao.ElementDAO;
import model.elements.Object;
import model.graphics.Sprite;
import model.elements.*;
import showboard.BoardFrame;

/**
 * <h1>The Class Scene represents the game scene with its elements.</h1>
 *
 * @author Julien LIGUORI julien.liguori@viacesi.fr
 * @version 1.0
 */
public class Scene implements IScene {
	
	 /** The width. */
    static private int	WIDTH = 20;

    /** The height. */
    static private int	HEIGHT = 12;

    /** The array of objects */
    private Object[][]	object;
    
    /** The main character */
    private Lorann character;
    
    /**
     * Instantiates a new Scene.
     * 
     * @throws SQLException
     */
    public Scene() {
        super();
        
        this.object = new Object[20][12];
        this.character = new Lorann(0, 0, Sprite.SPRITE_LORANN, this);
    }
	
	public IObject getObjectXY(int x, int y) {
        return (IObject) this.object[x][y];
    }

    /**
     * Sets an object at position.
     *
     * @param object
     *            the object
     * @param x
     *            the X position
     * @param y
     *            the Y position
     */
    public void setObjectXY(final Object object, int x, int y) {
        this.object[x][y] = object;
    }

    /**
     * Test if an object is solid.
     *
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @return the solidity at the position
     */
    public boolean isPenetrable(int x, int y) {
    	return this.object[x][y].getSolidity();
    }
    
    /**
     * Gets the main character.
     *
     * @return the main character
     */
	@Override
    public ICharacter getCharacter() {
        return (ICharacter)this.character;
    }
	
	@Override
	public void loadLevel(final int level, final BoardFrame frame) throws SQLException {
		Object obj = null;
		Element el;
		
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				
				el = ElementDAO.getElementByPos(level, x, y);
				
				// On ins�re l'objet en fonction du type :
				switch (el.getType())
				{
					case 'b' : obj = new Bulle(x, y, Sprite.SPRITE_BULLE, this);		frame.addSquare(obj, x, y); break;
					case 'p' : obj = new Sortie(x, y, Sprite.SPRITE_PORTE, this);		frame.addSquare(obj, x, y); break;
					case 'd' : /*obj = new Lorann(x, y, Sprite.SPRITE_PORTE, level);*/	frame.addSquare(new Mur(x, y, Sprite.SPRITE_MUR, this), x, y); break;
					case 'r' : obj = new Mur(x, y, Sprite.SPRITE_MUR, this);			frame.addSquare(obj, x, y); break;
					case 'h' : obj = new SolHorizontal(x, y, Sprite.SPRITE_SOLH, this);	frame.addSquare(obj, x, y); break;
					case 'v' : obj = new SolVertical(x, y, Sprite.SPRITE_SOLV, this);	frame.addSquare(obj, x, y); break;
					case 'n' : obj = new DemonNord(x, y, Sprite.SPRITE_DEMONN, this);	frame.addSquare(new Mur(x, y, Sprite.SPRITE_MUR, this), x, y); break;
					case 'w' : obj = new DemonOuest(x, y, Sprite.SPRITE_DEMONW, this);	frame.addSquare(new Mur(x, y, Sprite.SPRITE_MUR, this), x, y); break;
					case 'e' : obj = new DemonEst(x, y, Sprite.SPRITE_DEMONE, this);	frame.addSquare(new Mur(x, y, Sprite.SPRITE_MUR, this), x, y); break;
					case 's' : obj = new DemonSud(x, y, Sprite.SPRITE_DEMONS, this);	frame.addSquare(new Mur(x, y, Sprite.SPRITE_MUR, this), x, y); break;
					case 'o' : obj = new Bourse(x, y, Sprite.SPRITE_BOURSE, this);		frame.addSquare(obj, x, y); break;
					default : frame.addSquare(new Vide(x, y, Sprite.SPRITE_VIDE, this), x, y); break;
				}
				
				setObjectXY(obj, x, y);
			}
		}
	}
	
	@Override
	public void setupSprites() {
		try {
			Sprite.LoadSprite();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
