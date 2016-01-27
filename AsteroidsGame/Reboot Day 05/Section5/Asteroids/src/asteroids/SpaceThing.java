package asteroids;

/**
 *
 * @author bricks
 */
public class SpaceThing {

protected Point location;

public SpaceThing()
{
    location = new Point(0,0);
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
