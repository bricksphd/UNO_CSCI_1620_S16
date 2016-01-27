package asteroids;

import asteroids.mvc.IMVCView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;


/**
 * The pane that draws the game
 */
public class AsteroidPane extends JComponent implements IMVCView {
	
    /** The location to draw the score in x. */
    private final int SCORE_X = 20;

    /** The location to draw the score in y. */
    private final int SCORE_Y = 20;	

    /**
     * Instantiates a new asteroid pane.
     */
    public AsteroidPane() {
            super();

            ///Set the size of the pane
            setPreferredSize(new Dimension(600, 600));
    }

    /* (non-Javadoc)
     * @see mvc.IMVCView#modelUpdated()
     */
    @Override
    public void modelUpdated() {

            ///If the model is updated, we should redraw
            repaint();
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics g1) {

        ///Paint the game

        ///Grab the pane dimensions
        int width = this.getWidth();
        int height = this.getHeight();
        
         ///Get the model we're going to use to render
        Model model = AsteroidsMain.model;


        ///Convert to graphics 2d
        Graphics2D g = (Graphics2D) g1;

        ///Turn on anti-aliasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(model.currentState == Model.GAME_STATE_STARTING || model.currentState == Model.GAME_STATE_FADE_TO_PLAYING)
        {
            ///Set the paint color to white
            g.setColor(Color.WHITE);

            ///Fill the background
            g.fillRect(0, 0, width, height);
            
            /** Set the text color **/
            g.setColor(Color.RED);
            
            /** Draw the title **/
            g.drawString("The best asteroid game ever!", 300, 300);
            
           g.drawString("Click anywhere or push any key to start", 300, 400);
           
           if(model.currentState == Model.GAME_STATE_FADE_TO_PLAYING)
           {
               int alpha =  (int)(model.getFramesInState() / (float)Model.FADING_FRAMES * 255);
               
               /** Set the fade color */
               g.setColor(new Color(0, 0, 0, alpha));
               
              /** fill with the fade color */
               g.fillRect(0, 0, width, height);
           }
        }
        else
        {

            PaintPlayingOrDead(g, width, height, model);
        }
        
        Lock.locked = false;
    }

    private void PaintPlayingOrDead(Graphics2D g, int width, int height, Model model) {
        
        
        ///Now we're going to clean the background
        
        ///Set the paint color to white
        g.setColor(Color.WHITE);
        
        ///Fill the background
        g.fillRect(0, 0, width, height);
        
        ///Get the original transform (since we're changing it)
        AffineTransform originalTransform = g.getTransform();
        
        ///Get the new transform
        AffineTransform cameraTransform = new AffineTransform(originalTransform);
        
        ///Scale it to be 10 wide and 10 tall
        cameraTransform.scale(60, -60);
        
        ///move the camera to center on the ship
        cameraTransform.translate(5, -10);
        
        ///Set our new transform to be the transform
        g.setTransform(cameraTransform);
        
        
        ///Now draw the asteroids
        
        ///Set the asteroid color
        g.setColor(Color.GRAY);
        
        ///Draw each asteroid
        for(Asteroid asteroid : model.getAsteroids())
        {
            ///Grab the asteroid's location
            float cx = asteroid.getLocation().x;
            float cy = asteroid.getLocation().y;
            
            ///Fill a circle at that location
            g.fill(new Ellipse2D.Float(cx - Asteroid.RADIUS, cy - Asteroid.RADIUS, Asteroid.RADIUS * 2, Asteroid.RADIUS * 2));
            
        }
        
        ///Now draw the fuel
        g.setColor(Color.RED);
        for(Fuel fuel : model.getFuels())
        {
            ///Grab the asteroid's location
            float cx = fuel.getLocation().x;
            float cy = fuel.getLocation().y;
            
            ///Fill a circle at that location
            g.fill(new Ellipse2D.Float(cx - Fuel.radius, cy - Fuel.radius, Fuel.radius * 2, Fuel.radius * 2));
        }
        
        g.setColor(Color.GRAY);
        for(Bullet bullet: model.getBullets())
        {
            ///Grab the asteroid's location
            float cx = bullet.getLocation().x;
            float cy = bullet.getLocation().y;
            
            ///Fill a circle at that location
            g.fill(new Ellipse2D.Float(cx - Bullet.RADIUS, cy- Bullet.RADIUS, Bullet.RADIUS, Bullet.RADIUS));
        }
        ///Now drow the ship
        
        ///Set the ship color
        g.setColor(Color.GREEN);
        
        ///Get the ship's location
        float cx = model.getShip().getLocation().x;
        float cy = model.getShip().getLocation().y;
        
        ///Draw a circle to represent the ship
        g.fill(new Ellipse2D.Float(cx - Ship.RADIUS, cy - Ship.RADIUS, Ship.RADIUS * 2, Ship.RADIUS * 2));
        
        ///Return the transform to the original one
        g.setTransform(originalTransform);
        
        ///Now draw the score
        
        ///Set the score font
        g.setFont(new Font("Helvetica", Font.PLAIN, 20));
        
        ///Set the font background color
        g.setColor(Color.LIGHT_GRAY);
        
        ///Draw the background
        g.drawString("" + model.getScore(), SCORE_X + 1, SCORE_Y + 1);
        
        ///Set the score foreground color
        g.setColor(Color.BLACK);
        
        ///Draw the score foreground
        g.drawString("" + model.getScore(), SCORE_X, SCORE_Y);
        
        if(Model.currentState == Model.GAME_STATE_DEAD)
        {
            g.setColor(Color.RED);
            
            g.drawString("You Died. Ouch!", 300, 300);
        }
        
        if(model.getFramesInState() < Model.FADING_FRAMES)
        {
            int alpha =  255 - (int)(model.getFramesInState() / (float)Model.FADING_FRAMES * 255);
               
            /** Set the fade color */
            g.setColor(new Color(0, 0, 0, alpha));

            /** fill with the fade color */
            g.fillRect(0, 0, width, height);
        }
    }

}
