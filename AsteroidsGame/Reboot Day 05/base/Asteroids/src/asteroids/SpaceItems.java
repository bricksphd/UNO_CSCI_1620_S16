/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

/**
 *
 * @author bricks
 */
public class SpaceItems {
    
    /** The radius of a space item */
    public static float RADIUS = 1;
    
    /** The location of the asteroid. */
	protected Point location;
	
        
        public SpaceItems()
        {
            location = new Point(0, 0);
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
	 * @param y the amount by which the asteroid will move in y
	 */
	public void move(float x, float y) {
		location.update(location.x + x, location.y + y);
		
	}
    
}
