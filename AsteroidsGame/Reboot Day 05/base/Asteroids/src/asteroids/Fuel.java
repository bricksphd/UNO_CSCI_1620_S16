package asteroids;

public class Fuel extends SpaceItems{
    private int gallonsOfFuel;
    
    public static float radius;
    
    
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
    
}