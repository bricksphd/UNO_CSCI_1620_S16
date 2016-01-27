package asteroids;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

/**
 * The Class Model.
 */
public class Model implements IMVCModel, KeyListener {
	
	/** The keys. */
	private boolean[] keys = new boolean[500]; 

	/** The asteroid speed. */
	private final float ASTEROID_SPEED = 5;
	
	/** The asteroids. */
	private List<Asteroid> asteroids = new ArrayList<Asteroid>();
    
    /** The fuel. **/
    private List<Fuel> fuels = new ArrayList<Fuel>();

	/** The mvc model. */
	private MVCModel mvcModel = new MVCModel();
	
	/** The score. */
	private int score;
	
	/** The ship. */
	private Ship ship = new Ship();

	///Let's add some game states so we can die.
	/** The states that means we're diead */
	public final static int DIE_GAME_STATE = -1;
	
	/** The state that means we're alive. */
	public final static int ALIVE_GAME_STATE = 1;
	
	/** The current game state */
	public static int currentState;
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		
		
		boot();
	}
	
	/**
	 * Boot.
	 */
	public void boot()
	{
		ship = new Ship();
		
		asteroids.clear();
		
		score = 0;
		
		currentState = ALIVE_GAME_STATE;
	}
	
	/* (non-Javadoc)
	 * @see mvc.IMVCModel#addView(mvc.IMVCView)
	 */
	@Override
	public void addView(IMVCView newView) {mvcModel.addView(newView);}

	/**
	 * End game.
	 */
	private void endGame() {
		currentState = DIE_GAME_STATE;		
	}

	/**
	 * Gets the asteroids.
	 *
	 * @return the asteroids
	 */
	public List<Asteroid> getAsteroids() {
		return asteroids;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Gets the ship.
	 *
	 * @return the shop
	 */
	public Ship getShip() {
		return ship;
	}

	/**
	 * Sets the asteroids.
	 *
	 * @param asteroids the asteroids to set
	 */
	public void setAsteroids(List<Asteroid> asteroids) {
		this.asteroids = asteroids;
	}
	
	/**
	 * Sets the score.
	 *
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Sets the ship.
	 *
	 * @param shop the shop to set
	 */
	public void setShip(Ship shop) {
		this.ship = shop;
	}
	
	/**
	 * Tick.
	 *
	 * @param time the time
	 */
	public void tick(float time)
	{
		///Check to see if the left key is down
		boolean leftKeyDown = isLeftKeyDown();
		
		///Check to see if the right key is down
		boolean rightKeyDown = isRightKeyDown();
		
		///Move the ship based on which key is down
		if(leftKeyDown)
			ship.move(-time*10, 0);
		if(rightKeyDown)
			ship.move(time*10, 0);
		
		///Update the position of each asteroid.
		for(Asteroid asteroid : asteroids)
		{
			asteroid.move(0, -time * ASTEROID_SPEED);
			
			///We are trying to see if the radii of the asteroid and the ship sum to a number greater than their distance..
			float asteroidRadius = Asteroid.RADIUS;
			float shipRadius = Ship.RADIUS;
			float radiusSum = asteroidRadius + shipRadius;
			
			float xDiff = asteroid.getLocation().x - ship.getLocation().x;
			float yDiff = asteroid.getLocation().y - ship.getLocation().y;
			float distance = (float)Math.sqrt(xDiff * xDiff + yDiff * yDiff);
			
			if(radiusSum >= distance)
				endGame();
		}
        
        for(Fuel fuel : fuels)
        {
            fuel.move(0, -time * ASTEROID_SPEED * 3);
            
            ///We are trying to see if the radii of the asteroid and the ship sum to a number greater than their distance..
			float fuelRadius = Fuel.radius;
			float shipRadius = Ship.RADIUS;
			float radiusSum = fuelRadius + shipRadius;
			
			float xDiff = fuel.getLocation().x - ship.getLocation().x;
			float yDiff = fuel.getLocation().y - ship.getLocation().y;
			float distance = (float)Math.sqrt(xDiff * xDiff + yDiff * yDiff);
			
			if(radiusSum >= distance)
				pickUpFuel();
        }
        
		
		///Remove asteroids if they've hit the bottom
		asteroids.removeIf(a->a.getLocation().y < Asteroid.RADIUS);
		
		///Spawn new asteroids
		if(Math.random() < .05)
		{
			asteroids.add(new Asteroid());
		}
        
        ///Spawn new fuel
		if(Math.random() < .02)
		{
			fuels.add(new Fuel());
		}
		
		if(currentState == DIE_GAME_STATE)
		{
			Point p = new Point(100,100);
			ship.setLocation(p);
		}
		
		///Indicate to our views that we've changed
		updated();
		
		///Call this same method again after a little bit of time
		new Timer().schedule(new TimerTask(){public void run(){tick(.02f);}}, 1000/50);
	}
    
    public void pickUpFuel()
    {
        score += 1;
    }
    
    public List<Fuel> getFuels()
    {
        return fuels;
    }

	/**
	 * Checks if is right key down.
	 *
	 * @return true, if is right key down
	 */
	private boolean isRightKeyDown() {
		return keys[KeyEvent.VK_RIGHT];
	}

	/**
	 * Checks if is left key down.
	 *
	 * @return true, if is left key down
	 */
	private boolean isLeftKeyDown() {
		return keys[KeyEvent.VK_LEFT];
	}

	/* (non-Javadoc)
	 * @see mvc.IMVCModel#updated()
	 */
	@Override
	public void updated() {mvcModel.updated();}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	//http://gamedev.stackexchange.com/questions/56017/java-best-implementation-keylistener-for-games
	@Override
	public void keyPressed(KeyEvent e) {keys[e.getKeyCode()] = true;}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {keys[e.getKeyCode()] = false;}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {}
		
	
	
	

}
