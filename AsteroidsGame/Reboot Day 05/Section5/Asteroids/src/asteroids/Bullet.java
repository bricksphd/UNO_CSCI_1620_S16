
package asteroids;

/**
 *
 * @author bricks
 */
public class Bullet extends SpaceThing{
    
    public static float RADIUS = .2f;
    
    public Bullet(float x, float y)
    {
        setLocation(new Point(x,y));
    }
}
