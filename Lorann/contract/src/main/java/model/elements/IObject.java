package model.elements;

/**
 * <h1>The Interface IObject implements placeable object.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public interface IObject {
	
	/**
     * Gets the X position.
     *
     * @return the X position
     */
	public int getX();
	
	/**
     * Sets the X position.
     *
     * @param x
     *            the X position
     */
	public void setX(int x);
	
	/**
     * Gets the Y position.
     *
     * @return the Y position
     */
	public int getY();
	
	/**
     * Sets the Y position.
     *
     * @param y
     *            the Y position
     */
	public void setY(int y);
	
	/**
     * Gets the solidity.
     *
     * @return the solidity
     */
	public boolean getSolidity();
	
	/**
     * Sets the solidity.
     *
     * @param solid
     *            the solidity
     */
	public void setSolidity(boolean solid);
}
