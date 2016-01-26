package asteroids;

/**
A class that represents a point in 2D space
*/
public class Point {
	
    /** The x value of the point*/
	public float x;
	
    /** The y value of the point */
	public float y;
	
    /**
    Constructor that creates a new point instance at x, y
    @param x The x location of the point.
    @param y The y location of the point.
    */
	public Point(float x, float y)
	{
		this.x = x;
		
		this.y = y;
	}
	
    /**
    Update the location of the point
    @param x The new x location
    @param y The new y location
    */
	public void update(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

    /**
    Calculate the distance between points
    @param location The other point we are comparing againts
    @returns The Euclidean distance between this point and location
    */
	public float distanceTo(Point location) {
		float xDist = (this.x - location.x);
		float yDist = (this.y - location.y);
		
		float distance = (float) Math.sqrt(xDist * xDist + yDist * yDist);
		
		return distance;
	}

}
