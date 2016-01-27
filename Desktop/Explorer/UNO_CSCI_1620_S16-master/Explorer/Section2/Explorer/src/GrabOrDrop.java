/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author darthaustin96
 */


public class GrabOrDrop {
    
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";
    public static int itemNumber;
    public static String[] itemName = new String[100];
    public static int[] itemLocation = new int[100];
    public static boolean[] itemGrabbed = new boolean[100];
    //public static boolean shovelGrabbed = false;
    
    //public static int shovelLocation = 51;
    public static String grabItem =  "";
    
    public String grab()
	{
            if((itemGrabbed[itemNumber] == false) && (Location.currentLocation == itemLocation[itemNumber])) {
                Inventory.fullInv += (String.valueOf(itemName[itemNumber]));
                itemGrabbed[itemNumber] = true;
                itemLocation[itemNumber] = -1;
                Location.numItemsInArea[Location.currentLocation] -= 1;
                Location.nameItemsInArea[Location.currentLocation] = Location.nameItemsInArea[Location.currentLocation].replaceAll(itemName[itemNumber], "");
                Around.myPickUps2 = Location.nameItemsInArea[Location.currentLocation];
                if(Location.numItemsInArea[Location.currentLocation] == 0) {
                    Location.go = true;
                }
                grabItem = "You grab the " + itemName[itemNumber] + ".";
                return grabItem;
            }
            else if ((itemGrabbed[itemNumber] == true)){
                grabItem = "You already have the " + itemName[itemNumber] + ".";
                return grabItem;
            }
            else {
                grabItem = "There is no " + itemName[itemNumber] + " nearby.";
                return grabItem;
            }
        
	}
    
    public String drop() {
        
        if(itemGrabbed[itemNumber] == true) {
            Inventory.fullInv = Inventory.fullInv.replaceAll(itemName[itemNumber], "");
            itemGrabbed[itemNumber] = false;
            itemLocation[itemNumber] = Location.currentLocation;
            Location.nameItemsInArea[Location.currentLocation] += itemName[itemNumber];
            Location.numItemsInArea[Location.currentLocation] += 1;
            Around.myPickUps2 = Location.nameItemsInArea[Location.currentLocation];
            Location.go = false;
            grabItem = "You drop the " + itemName[itemNumber];
            return grabItem;
        }
        
        else {
            grabItem = "You don't have a " + itemName[itemNumber];
            return grabItem;
        }
        
    }
    
}
