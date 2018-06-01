package model;

import java.sql.SQLException;

import model.elements.*;
import showboard.BoardFrame;

/**
 * <h1>The Interface Scene implements the game scene.</h1>
 *
 * @author Julien LIGUORI julien.liguori@viacesi.fr
 * @version 1.0
 */
public interface IScene {
	
	/**
     * Gets an object at position.
     *
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @return the object at the position
     */
    public IObject getObjectXY(final int x, final int y);
    
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
    public void setObjectXY(final IObject object, final int x, final int y);
    
    /**
     * Gets the current level.
     * 
     * @return the current level
     */
    public int getCurrentLevel();
    
    /**
     * Sets the current level.
     *
     * @param level
     *            the level
     */
    public void setCurrentLevel(final int level);
    
    /**
     * Gets the reload level flag.
     *
     * @return the state
     */
    public boolean hasToReloadLevel();
    
    /**
     * Sets the reload level flag.
     *
     * @param reload
     * 				the reload state
     */
    public void reloadLevel(final boolean reload);
    
    /**
     * Test if an object is solid.
     *
     * @param x
     *            the X position
     * @param y
     *            the Y position
     * @return the solidity at the position
     */
    public boolean isPenetrable(final int x, final int y);
	
	/**
     * Gets the main character.
     *
     * @return the main character
     */
    public ICharacter getCharacter();
    
    /**
     * Load a level from database
     * 
     * @throws SQLException
     */
	public void loadLevel(final int level, final BoardFrame frame) throws SQLException;
	
	/**
     * Unload the current level
     */
	public void unloadLevel();
}
