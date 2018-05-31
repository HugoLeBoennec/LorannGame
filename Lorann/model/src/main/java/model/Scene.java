package model;

import java.sql.SQLException;

import model.dao.ElementDAO;
import model.elements.Object;
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
        this.character = new Lorann(0, 0, this);
    }
	
    @Override
	public IObject getObjectXY(int x, int y) {
        return (IObject) this.object[x][y];
    }

    @Override
    public void setObjectXY(final IObject object, int x, int y) {
        this.object[x][y] = (Object) object;
    }

    @Override
    public boolean isPenetrable(int x, int y) {
    	final Object obj = this.object[x][y];
    	    	
    	if (obj == null) {
    		System.out.println("Exctre");
    		return false;
    	}
    	else
    		return obj.getSolidity();
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
				
				// Object insertion :
				switch (el.getType())
				{
					case 'b' : obj = new Bulle(x, y, this);						frame.addSquare(obj, x, y); break;
					case 'p' : obj = new Sortie(x, y, this);					frame.addSquare(obj, x, y); break;
					case 'r' : obj = new Mur(x, y, this);						frame.addSquare(obj, x, y); break;
					case 'h' : obj = new SolHorizontal(x, y, this);				frame.addSquare(obj, x, y); break;
					case 'v' : obj = new SolVertical(x, y, this);				frame.addSquare(obj, x, y); break;
					case 'n' : obj = new DemonNord(x, y, this);					frame.addSquare(new Vide(x, y, this), x, y); break;
					case 'w' : obj = new DemonOuest(x, y, this);				frame.addSquare(new Vide(x, y, this), x, y); break;
					case 'e' : obj = new DemonEst(x, y, this);					frame.addSquare(new Vide(x, y, this), x, y); break;
					case 's' : obj = new DemonSud(x, y, this);					frame.addSquare(new Vide(x, y, this), x, y); break;
					case 'o' : obj = new Bourse(x, y, this);					frame.addSquare(obj, x, y); break;
					case 'd' : this.character.setX(x); this.character.setY(y);	frame.addSquare(new Vide(x, y, this), x, y); break;
					default : frame.addSquare(new Vide(x, y, this), x, y); break;
				}
				
				setObjectXY(obj, x, y);
			}
		}
		
		// Main character creation :
		frame.addPawn(this.character);
	}
}
