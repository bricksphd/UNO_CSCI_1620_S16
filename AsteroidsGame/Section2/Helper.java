package asteroids;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
A helper class that provides functionality that I'll use in multiple projects
**/

public class Helper {
	
    /**
    Set the lok and feel to be the system default
    **/
	public static void setLookAndFeel()
	{
		try {
			//http://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            ///Set the look and feel to the system default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (UnsupportedLookAndFeelException e) {
		       // handle exception
		    }
		    catch (ClassNotFoundException e) {
		       // handle exception
		    }
		    catch (InstantiationException e) {
		       // handle exception
		    }
		    catch (IllegalAccessException e) {
		       // handle exception
		    }
	}
	
    /**
    Get a random float in (-1, 1)
    @returns A random float in (-1, 1)
    */
	public static float getRandomBetweenOneAndOne()
	{
		return (float) (Math.random() * 2 - 1);
	}

}
