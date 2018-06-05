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
    
    /** The current level */
    private int currentLevel;
    
    /** If the next level must be loaded */
    private boolean nextLevel;
    
    /** If the level is fully loaded */
    private boolean isLoaded;
    
    /**
     * Instantiates a new Scene.
     * 
     */
    public Scene() {
        this.object = new Object[20][12];
        this.character = new Lorann(0, 0, this);
        
        this.currentLevel = 1;
        this.nextLevel = false;
        this.isLoaded = false;
    }
    
    /**
     * Gets an object of type.
     *
     * @param type
     *            the type
     * @return the first object of type
     */
	public Object getObjectOfType(final Type type) {
		Object obj = null;
		
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				obj = this.object[x][y];
				
				if (obj != null) {
					if (obj.getType() == type)
						return obj;
				}
			}
		}
		
		return obj;
    }
	
    @Override
	public IObject getObjectXY(final int x, final int y) {
        return (IObject) this.object[x][y];
    }

    @Override
    public void setObjectXY(final IObject object, final int x, final int y) {
        this.object[x][y] = (Object) object;
    }
    
    @Override
    public int getCurrentLevel() {
    	return this.currentLevel;
    }
    
    @Override
    public void setCurrentLevel(final int level) {
    	this.currentLevel = level;
    }
    
    @Override
    public boolean hasToReloadLevel() {
    	return this.nextLevel;
    }
    
    @Override
    public void reloadLevel(final boolean reload) {
    	this.nextLevel = reload;
    }

    @Override
    public boolean isPenetrable(final int x, final int y) {
    	final Object obj = this.object[x][y];
    	
    	// If the tile is empty, return false :
    	if (obj == null)
    		return false;
    	else
    		return obj.getSolidity();
    }
    
	@Override
    public ICharacter getCharacter() {
        return (ICharacter)this.character;
    }
	
	@Override
	public void tick() {
		// If the level isn't loaded, don't process :
		if (!this.isLoaded)
			return;
		
		Object object;
		
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				object = this.object[x][y];
				
				if (object != null) {
					if (object.getType() == Type.TYPE_DAEMON)
						((IMobile)object).tick();
				}
			}
		}
		
		// Update the character last :
		this.character.tick();
	}
	
	@Override
	public void loadLevel(final int level, final BoardFrame frame) throws SQLException {
		IObject obj;
		Element el;
		
		// Initiate the character :
		this.character.initiate(frame);
		
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				
				obj = null;
				el = ElementDAO.getElementByPos(level, x, y);
				
				// Object insertion :
				switch (el.getType())
				{
					case 'b' : obj = new Key(x, y, this);						frame.addSquare(obj, x, y); break;
					case 'p' : obj = new Exit(x, y, this);					frame.addSquare(obj, x, y); break;
					case 'r' : obj = new Wall(x, y, this);						frame.addSquare(obj, x, y); break;
					case 'h' : obj = new BoneHorizontal(x, y, this);				frame.addSquare(obj, x, y); break;
					case 'v' : obj = new BoneVertical(x, y, this);				frame.addSquare(obj, x, y); break;
					case 'n' : obj = new DaemonNorth(x, y, this);					frame.addSquare(new Empty(x, y, this), x, y); frame.addPawn((IMobile)obj); break;
					case 'w' : obj = new DaemonWest(x, y, this);				frame.addSquare(new Empty(x, y, this), x, y); frame.addPawn((IMobile)obj); break;
					case 'e' : obj = new DaemonEast(x, y, this);					frame.addSquare(new Empty(x, y, this), x, y); frame.addPawn((IMobile)obj); break;
					case 's' : obj = new DaemonSouth(x, y, this);					frame.addSquare(new Empty(x, y, this), x, y); frame.addPawn((IMobile)obj); break;
					case 'o' : obj = new Coin(x, y, this);					frame.addSquare(obj, x, y); break;
					case 'd' : this.character.setX(x); this.character.setY(y);	frame.addSquare(new Empty(x, y, this), x, y); break;
					default : frame.addSquare(new Empty(x, y, this), x, y); break;
				}
				
				setObjectXY(obj, x, y);
			}
		}
		
		// Main character creation :
		frame.addPawn(this.character);
		
		this.isLoaded = true;
	}
	
	@Override
	public void unloadLevel() {
		// Deletion of all objects :
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++)
				setObjectXY(null, x, y);
		}
		
		this.character.reset();
		
		this.isLoaded = false;
	}
}
