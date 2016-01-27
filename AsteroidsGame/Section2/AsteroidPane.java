package asteroids;

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
    
    private final Font DeadFont = new Font("Comic Sans", Font.PLAIN, 36);
	
	
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
		
		
		///Convert to graphics 2d
		Graphics2D g = (Graphics2D) g1;
		
		///Turn on anti-aliasing
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
        if(Model.GAME_STATE == Model.YOU_DEAD_GAME_STATE)
        {
            ///Set the paint color to black
            g.setColor(Color.BLACK);
            
            ///Fill the background
            g.fillRect(0, 0, width, height);
            
            ///Set it to a creepy color.
            g.setColor(Color.RED);
            
            ///Set the font of the dead text
            g.setFont(DeadFont);
            
            ///Draw the dead string
            g.drawString("You Dead", 300, 300);
		        
        }
        else
        {
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
		
		///Get the model we're going to use to render
		Model model = AsteroidsMain.model;
		
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
        }
	}

}
