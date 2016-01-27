package asteroids;

public class Fuel{
    private int gallonsOfFuel;
    
    public static float radius;
    
    private Point location;
    
    /** The y value at which the bottom of the asteroid starts. */
	public static final float STARTING_Y = 10;
	
	/** The range [-STARTING_RANGE, STARTING_RANGE] in which an asteroid stars. */
	public static final float STARTING_RANGE = 5;
	
    
    public Fuel()
    {
        gallonsOfFuel = 50;
        
        radius = .5f;
        
        setLocation(new Point(Helper.getRandomBetweenOneAndOne() * STARTING_RANGE, STARTING_Y + radius));
	
    }
    
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