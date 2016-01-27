package asteroids;


/**
 * A class representing a asteroid.
 */
public class Asteroid extends SpaceThing{
	
	/** The radius of all asteroids. */
	public static final float RADIUS = 1;
	
	/** The y value at which the bottom of the asteroid starts. */
	public static final float STARTING_Y = 10;
	
	/** The range [-STARTING_RANGE, STARTING_RANGE] in which an asteroid stars. */
	public static final float STARTING_RANGE = 5;
	
	
	/**
	 * Instantiates a new asteroid.
	 */
	public Asteroid()
	{
		///Set the location to be a random number with the bounds of range
		setLocation(new Point(Helper.getRandomBetweenOneAndOne() * STARTING_RANGE, STARTING_Y + RADIUS));
	}

	

}
