package asteroids;

/**
 * The Class Ship.
 */
public class Ship extends SpaceItems{
	
   
    /** The radius of the ship. */
    public static final float RADIUS = 1;

    /**
     * Instantiates a new ship.
     */
    public Ship()
    {

    }
    
    public void moves(float x, float y) 
    {
        super.move(x,y);
                
                
        if(location.x > 5)
            location.x = 5;
        if(location.x < -5)
            location.x = -5;

    }

    
}
