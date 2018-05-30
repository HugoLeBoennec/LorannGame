package model;

import java.sql.SQLException;

import model.dao.ElementDAO;
import model.elements.Object;
import model.graphics.Sprite;
import model.elements.*;

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
    public Scene() throws SQLException {
        super();
        
        this.object = new Object[20][12];
        this.character = new Lorann(0, 0, Sprite.SPRITE_LORANN, this);
        
        //this.loadLevel(1);
    }

	public void loadLevel(final int level) throws SQLException {
		Object obj = null;
		Element el;
		
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				
				el = ElementDAO.getElementByPos(level, x, y);
				
				// On insère l'objet en fonction du type :
				switch (el.getType())
				{
					case 'b' : obj = new Bulle(x, y, Sprite.SPRITE_BULLE, this); break;
					case 'p' : obj = new Sortie(x, y, Sprite.SPRITE_PORTE, this); break;
					//case 'd' : obj = new Lorann(x, y, Sprite.SPRITE_PORTE, level); break;
					case 'r' : obj = new Mur(x, y, Sprite.SPRITE_MUR, this); break;
					case 'h' : obj = new SolHorizontal(x, y, Sprite.SPRITE_SOLH, this); break;
					case 'v' : obj = new SolVertical(x, y, Sprite.SPRITE_SOLV, this); break;
					case 'n' : obj = new DemonNord(x, y, Sprite.SPRITE_DEMONN, this); break;
					case 'w' : obj = new DemonOuest(x, y, Sprite.SPRITE_DEMONW, this); break;
					case 'e' : obj = new DemonEst(x, y, Sprite.SPRITE_DEMONE, this); break;
					case 's' : obj = new DemonSud(x, y, Sprite.SPRITE_DEMONS, this); break;
					case 'O' : obj = new Bourse(x, y, Sprite.SPRITE_BOURSE, this); break;
				}
				
				setObjectXY(obj, x, y);
			}
		}
	}
	
	/**
     * Gets the main character.
     *
     * @return the main character
     */
    public Lorann getCharacter() {
        return this.character;
    }
    
    /**
     * Sets the main character.
     *
     * @param character
     *            the main character
     */
    public void setCharacter(Lorann character) {
    	this.character = character;
    }
    
    /**
     * Gets an object at position.
     *
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @return the element at the position
     */
    public Object getObjectXY(int x, int y) {
        return this.object[x][y];
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
}
