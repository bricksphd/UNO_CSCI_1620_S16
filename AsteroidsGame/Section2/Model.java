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
	private final float ASTEROID_SPEED = 10;
	
	/** The asteroids. */
	private List<Asteroid> asteroids = new ArrayList<Asteroid>();

	/** The mvc model. */
	private MVCModel mvcModel = new MVCModel();
	
	/** The score. */
	private int score;
	
	/** The ship. */
	private Ship ship = new Ship();
    
    /** This is the value GAME_STATE takes when "you dead". */
    public static final int YOU_DEAD_GAME_STATE = 3;
    
    /** This is the game state when you aren't dead. */
    public static final int YOU_AINT_DEAD_GAME_STATE = 1;
    
    /** It's the variable for the game state, so it can be either 1 or 3. */
    public static int GAME_STATE;

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
        
        GAME_STATE = YOU_AINT_DEAD_GAME_STATE;
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
				GAME_STATE = YOU_DEAD_GAME_STATE;
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
			ship.move(-time * 10, 0);
		if(rightKeyDown)
			ship.move(time * 10, 0);
		
		///Update the position of each asteroid.
		for(Asteroid asteroid : asteroids)
		{
			asteroid.move(0, -time * ASTEROID_SPEED);
            
            
            boolean isInCollision;
            Point shipLocation = ship.getLocation();
            Point asteroidLocation = asteroid.getLocation();
            float distX = shipLocation.x - asteroidLocation.x;
            float distY = shipLocation.y - asteroidLocation.y;
            float distance = (float)Math.sqrt(distX*distX + distY * distY);
            
            float sumRadiusesss = Asteroid.RADIUS + Ship.RADIUS;
            if(sumRadiusesss > distance)
            {
                endGame();
            }
            
            if(asteroid.getLocation().y < Asteroid.RADIUS)
            {
                score += 5;
            }
		}
		
        
        
		///Remove asteroids if they've hit the bottom
		asteroids.removeIf(a->a.getLocation().y < Asteroid.RADIUS);
		
		///Spawn we asteroids
		if(Math.random() < .01)
		{
			asteroids.add(new Asteroid());
		}
		
		///Indicate to our views that we've changed
		updated();
		if(GAME_STATE == YOU_AINT_DEAD_GAME_STATE)
        {
            ///Call this same method again after a little bit of time
            new Timer().schedule(new TimerTask(){public void run(){tick(.02f);}}, 1000/50);
        }
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
