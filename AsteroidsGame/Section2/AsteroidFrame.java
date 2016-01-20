package asteroids;

import javax.swing.JFrame;

/**
 * The main frame for the program.
 */
@SuppressWarnings("serial")
public class AsteroidFrame extends JFrame {
	
	/**
	 * Instantiates a new asteroid frame.
	 */
	public AsteroidFrame()
	{
		///Create the frame
		super("Asteroid Game 01");
		
		///End the program when the frame closes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		///Make the frame visible
		setVisible(true);
		
		///Respond to key events
		this.addKeyListener(AsteroidsMain.model);
	}

}
