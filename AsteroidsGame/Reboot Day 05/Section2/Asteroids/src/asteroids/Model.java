package asteroids;

import asteroids.mvc.IMVCView;
import asteroids.mvc.MVCModel;
import asteroids.mvc.IMVCModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    /** The states that means we're dead */
    public final static int GAME_STATE_DEAD = -1;

    /** The state that means we're alive. */
    public final static int GAME_STATE_PLAYING = 1;

    /** The state where you see the welcome screen **/
    public final static int GAME_STATE_STARTING = 2;

    /** We're fading into playing the game **/
    public final static int GAME_STATE_FADE_TO_PLAYING = 3;

    /** Fade the restart the game **/
    public final static int GAME_STATE_FADE_TO_RESTART = 4;

    /** The current game state */
    public static int currentState;

    /** How many frames have we spent in the current state? **/
    private int framesInState = 0;

    /** How many frames does it take to fade? **/
    public static final int FADING_FRAMES = 100;

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

            currentState = GAME_STATE_STARTING;
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
            currentState = GAME_STATE_DEAD;		
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
        /** Update the number of frames we have spent in this state */
        setFramesInState(getFramesInState() + 1);
        
        if(currentState == Model.GAME_STATE_PLAYING)
            tickPlaying(time);
        else if(currentState == Model.GAME_STATE_FADE_TO_PLAYING)
        {
            if(getFramesInState() >= FADING_FRAMES)
                changeState(Model.GAME_STATE_PLAYING);

        }

        Lock.locked = true;
        
         ///Indicate to our views that we've changed
        updated();
        
       /*while(Lock.locked)
       {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
       }*/

        ///Call this same method again after a little bit of time
        new Timer().schedule(new TimerTask(){public void run(){tick(.02f);}}, 1000/50);
    }

    private void tickPlaying(float time) {
        ///Check to see if the left key is down
        boolean leftKeyDown = isLeftKeyDown();
        
        ///Check to see if the right key is down
        boolean rightKeyDown = isRightKeyDown();
        
        ///Move the ship based on which key is down
        if(leftKeyDown)
            ship.move(-time*10, 0);
        if(rightKeyDown)
            ship.move(time*10, 0);
        
        ///Don't start throwing things unless we're done fading...
        if(this.getFramesInState() > Model.FADING_FRAMES)
        {
        
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
            asteroids.removeIf(a->a.getLocation().y < -Asteroid.RADIUS);

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
        }
        
        if(currentState == GAME_STATE_DEAD)
        {
            Point p = new Point(100,100);
            ship.setLocation(p);
        }
        
       
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
    public void keyTyped(KeyEvent arg0) {
    
        if(currentState == Model.GAME_STATE_STARTING)
        {
            changeState(Model.GAME_STATE_FADE_TO_PLAYING);
        }
        
    }

    private void changeState(int newGameState) {
        currentState = newGameState;
        framesInState = 0;
        
    }

    /**
     * @return the framesInState
     */
    public int getFramesInState() {
        return framesInState;
    }

    /**
     * @param framesInState the framesInState to set
     */
    public void setFramesInState(int framesInState) {
        this.framesInState = framesInState;
    }
	

}
