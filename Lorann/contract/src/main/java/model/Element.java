package model;

/**
 * <h1>The Class Example.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class Element {

    /** The X position. */
	private final int x;
	
	/** The Y position. */
    private final int y;

    /** The type. */
    private char type;

    /**
     * Instantiates a new example.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     */
    public Element(final int x, final int y, final char type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
    /**
     * Sets the Type of the Element.
     *
     * @param type
     *            the type
     */
	public void setType(final char type) {
		this.type = type;
	}

    /**
     * Gets the Type of the Element.
     *
     * @return the character type
     */
	public char getType() {
		return type;
	}

	/**
     * Gets the X position of the Element.
     *
     * @return the X position
     */
	public int getX() {
		return x;
	}

	/**
     * Gets the Y position of the Element.
     *
     * @return the Y position
     */
	public int getY() {
		return y;
	}
	
	@Override
    public String toString() {
        return this.getX() + ", " + this.getY() + " : " + this.getType();
    }
}
