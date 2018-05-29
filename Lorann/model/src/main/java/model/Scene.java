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
public class Scene {
	
	 /** The width. */
    private int         width;

    /** The height. */
    private int         height;

    /** The array of objects */
    private Object[][]	object;
    
    /**
     * Instantiates a new Scene.
     * 
     * @throws SQLException
     */
    public Scene() throws SQLException {
        super();
        
        this.object = new Object[20][12];
        
        this.loadLevel(1);
    }

    /**
     * Load a level from database
     * 
     * @throws SQLException
     */
	private void loadLevel(final int level) throws SQLException {
		Object obj = null;
		Element el;
		
		for (int y = 0; y < 12; y++) {
			for (int x = 0; x < 20; x++) {
				
				el = ElementDAO.getElementByPos(level, x, y);
				
				// On insère l'objet en fonction du type :
				switch (el.getType())
				{
					case 'b' : obj = new Bulle(x, y, Sprite.SPRITE_BULLE); break;
					case 'p' : obj = new Sortie(x, y, Sprite.SPRITE_PORTE); break;
					case 'r' : obj = new Mur(x, y, Sprite.SPRITE_MUR); break;
					case 'h' : obj = new SolHorizontal(x, y, Sprite.SPRITE_SOLH); break;
					case 'v' : obj = new SolVertical(x, y, Sprite.SPRITE_SOLV); break;
					case 'n' : obj = new DemonNord(x, y, Sprite.SPRITE_DEMONN); break;
					case 'w' : obj = new DemonOuest(x, y, Sprite.SPRITE_DEMONW); break;
					case 'e' : obj = new DemonEst(x, y, Sprite.SPRITE_DEMONE); break;
					case 's' : obj = new DemonSud(x, y, Sprite.SPRITE_DEMONS); break;
					case 'O' : obj = new Bourse(x, y, Sprite.SPRITE_BOURSE); break;
				}
				
				setObjectXY(obj, x, y);
			}
		}
	}
    
    /**
     * Gets the width.
     *
     * @return the width
     */
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(int height) {
        this.height = height;
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
    public boolean isPenetrable (int x, int y) {
    	return this.object[x][y].getSolidity();
    }
}
