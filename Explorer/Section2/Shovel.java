
public class Shovel {
	
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";
    public static boolean shovelGrabbed = false;
    
    public static String GrabShovel =  "";
    
	public String description()
	{
		return "";
	}
	
	public String grab()
	{
        if(shovelGrabbed == false) {
            Around.myDescription = "You find yourself at the end of a dirt road.  The only direction you are able to go is " + COLOR_BLUE + "east." + COLOR_RESET;
            Inventory.fullInv += (String.valueOf(Inventory.invShovel));
            shovelGrabbed = true;
            GrabShovel = "You grab the " + COLOR_RED + "shovel." + COLOR_RESET;
            return GrabShovel;
        }
        else {
            GrabShovel = "You already have the " + COLOR_RED + "shovel." + COLOR_RESET;
            return GrabShovel;
        }
        
	}
    
    public String drop() {
        
        if(shovelGrabbed == true) {
            Around.myDescription = "You find yourself at the end of a dirt road.  The only direction you are able to go is " + COLOR_BLUE + "east" + COLOR_RESET + ".  There is a " + COLOR_RED + "shovel " + COLOR_RESET + "near by.";
            Inventory.fullInv = Inventory.fullInv.replaceAll(Inventory.invShovel, "");
            shovelGrabbed = false;

            GrabShovel = "You drop the " + COLOR_RED + "shovel." + COLOR_RESET;
            return GrabShovel;
        }
        
        else {
            GrabShovel = "You don't have a " + COLOR_RED + "shovel." + COLOR_RESET;
            return GrabShovel;
        }
        
    }

}
