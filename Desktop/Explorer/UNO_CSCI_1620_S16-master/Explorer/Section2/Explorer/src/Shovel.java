public class Shovel extends GrabOrDrop{
	
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
    
    public static int shovelLocation = 51;
    public static String grabShovel =  "";
    public static String shovelDescription = "It's blue!";
    
	public String description()
	{
		return "";
	}
	
	public String grab()
	{
            if((shovelGrabbed == false) && (Location.currentLocation == shovelLocation)) {
                Inventory.fullInv += (String.valueOf(Inventory.invShovel));
                shovelGrabbed = true;
                shovelLocation = -1;
                Location.numItemsInArea[Location.currentLocation] -= 1;
                Location.nameItemsInArea[Location.currentLocation] = Location.nameItemsInArea[Location.currentLocation].replaceAll("-shovel\n", "");
                Around.myPickUps2 = Location.nameItemsInArea[Location.currentLocation];
                if(Location.numItemsInArea[Location.currentLocation] == 0) {
                    Location.go = true;
                }
                grabShovel = "You grab the " + COLOR_RED + "shovel" + COLOR_RESET + ".";
                return grabShovel;
            }
            else if ((shovelGrabbed == true)){
                grabShovel = "You already have the " + COLOR_RED + "shovel" + COLOR_RESET + ".";
                return grabShovel;
            }
            else {
                grabShovel = "There is no " + COLOR_RED + "shovel" + COLOR_RESET + " nearby.";
                return grabShovel;
            }
        
	}
    
    public String drop() {
        
        if(shovelGrabbed == true) {
            Inventory.fullInv = Inventory.fullInv.replaceAll("-shovel\n", "");
            shovelGrabbed = false;
            shovelLocation = Location.currentLocation;
            Location.nameItemsInArea[Location.currentLocation] += COLOR_RED + "-shovel\n" + COLOR_RESET;
            Location.numItemsInArea[Location.currentLocation] += 1;
            Around.myPickUps2 = Location.nameItemsInArea[Location.currentLocation];
            Location.go = false;
            grabShovel = "You drop the " + COLOR_RED + "shovel." + COLOR_RESET;
            return grabShovel;
        }
        
        else {
            grabShovel = "You don't have a " + COLOR_RED + "shovel." + COLOR_RESET;
            return grabShovel;
        }
        
    }
    
    public String look() {
        if(shovelGrabbed == true) {
            return shovelDescription;
        }
        else
            return "You don't have a " + COLOR_RED + "shovel.";
    }
    
    public static String dig() {
        
        if(shovelGrabbed == true) {
            if(Location.digable[Location.currentLocation] == true) {

                Location.digable[Location.currentLocation] = false;
                Location.numItemsInArea[Location.currentLocation] += 1;
                Location.nameItemsInArea[Location.currentLocation] += Location.digableItem[Location.currentLocation];
                Around.myPickUps2 = Location.nameItemsInArea[Location.currentLocation];
                Location.go = false;
                
                return "You dug up a \n" + Location.digableItem[Location.currentLocation];
            }
            else {
                return "There is nothing to dig here\n";
            }
        }
        else {
            return "You have nothing to dig with.\n";
        }
    }
    
    

}

/*  STUFF I'M TRYING TO GET TO WORK



public class Shovel extends GrabOrDrop{
    
    public static String shovelDescription = "It's blue!";
    
    public void Shovel() {
        itemNumber = 1;
        itemName[1] = COLOR_RED + "-shovel\n" + COLOR_RESET;
    }
    
    public String description()
    {
            return "";
    }
	
    public String look() {
        if(itemGrabbed[itemNumber] == true) {
            return shovelDescription;
        }
        else
            return "You don't have a " + COLOR_RED + "shovel.";
    }
    
    public static String dig() {
        
        if(itemGrabbed[itemNumber] == true) {
            if(Location.digable[Location.currentLocation] == true) {

                Location.digable[Location.currentLocation] = false;
                Location.numItemsInArea[Location.currentLocation] += 1;
                Location.nameItemsInArea[Location.currentLocation] += Location.digableItem[Location.currentLocation];
                Around.myPickUps2 = Location.nameItemsInArea[Location.currentLocation];
                Location.go = false;
                
                return "You dug up a \n" + Location.digableItem[Location.currentLocation];
            }
            else {
                return "There is nothing to dig here\n";
            }
        }
        else {
            return "You have nothing to dig with.\n";
        }
    }
    
    

}


*/
