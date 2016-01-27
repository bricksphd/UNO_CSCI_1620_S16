package asteroids;

/**
The main class for the asteroids game
**/
public class AsteroidsMain {
	
	/** The static model that everyone can reach. */
	public static final Model model = new Model();
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments to the program (ingnored)
	 */
	public static void main(String[] args) {

		///Set the look and feel		
		Helper.setLookAndFeel();

		///Create the window
		AsteroidFrame frame = new AsteroidFrame();
		
		///Create the pane that will render the game
		AsteroidPane pane = new AsteroidPane();
	
		///Have the pane listen to the model
		model.addView(pane);
		
		///Add the pane to the frame
		frame.setContentPane(pane);

		///Pack the frame
		frame.pack();
		
		///Update the first time
		model.tick(.02f);

	}

}
