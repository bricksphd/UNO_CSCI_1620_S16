package asteroids;


/**
 * A class representing a asteroid.
 */
public class Asteroid {
	
	/** The radius of all asteroids. */
	public static final float RADIUS = 1;
	
	/** The y value at which the bottom of the asteroid starts. */
	public static final float STARTING_Y = 10;
	
	/** The range [-STARTING_RANGE, STARTING_RANGE] in which an asteroid stars. */
	public static final float STARTING_RANGE = 5;
	
	/** The location of the asteroid. */
	private Point location;
	
	/**
	 * Instantiates a new asteroid.
	 */
	public Asteroid()
	{
		///Set the location to be a random number with the bounds of range
		setLocation(new Point(Helper.getRandomBetweenOneAndOne() * STARTING_RANGE, STARTING_Y + RADIUS));
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Point location) {
		this.location = location;
	}

	/**
	 * Move.
	 *
	 * @param x the amount by which the asteroid will move in x
	 * @param y the amount by which the astetroid will move in y
	 */
	public void move(float x, float y) {
		location.update(location.x + x, location.y + y);
		
	}

}
