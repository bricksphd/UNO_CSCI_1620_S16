package asteroids;

/**
 * The Class Ship.
 */
public class Ship {
	
	/** The location of the ship. */
	private Point location = new Point(0, 0);
	
	/** The radius of the ship. */
	public static final float RADIUS = 1;
	
	/**
	 * Instantiates a new ship.
	 */
	public Ship()
	{
		
	}

	/**
	 * Gets the location of the ship.
	 *
	 * @return the location of the ship
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * Sets the location of the ship.
	 *
	 * @param location the new location of the ship
	 */
	public void setLocation(Point location) {
		this.location = location;
	}
	
	/**
	 * Move the ship.
	 *
	 * @param x the amount to move the ship in x
	 * @param y the amount to move the ship in y
	 */
	public void move(float x, float y) {
		location.update(location.x + x, location.y + y);
		
	}
	
	

}
