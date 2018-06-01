package model.elements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * <h1>The enumeration for each direction.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public enum Direction {
	DIR_LEFT,
	DIR_UPLEFT,
	DIR_UP,
	DIR_UPRIGHT,
	DIR_RIGHT,
	DIR_DOWNRIGHT,
	DIR_DOWN,
	DIR_DOWNLEFT;

	/**
	 * Pick a direction randomly.
	 * @return the direction
	 */
  	public static Direction randomDirection() {
  		final List<Direction> values = Collections.unmodifiableList(Arrays.asList(values()));
  		final Random random = new Random();
  		
  		return values.get(random.nextInt(values.size()));
  	}
}
