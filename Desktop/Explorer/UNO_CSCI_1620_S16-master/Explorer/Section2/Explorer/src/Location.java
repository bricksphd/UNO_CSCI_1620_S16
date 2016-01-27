/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author darthaustin96
 */
public class Location {
    
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";
    
    public static int currentLocation = 51;
    public static int wantedLocation;
    public static String d;
    public static boolean go = false;
    public static int[] numItemsInArea = new int[100];
    public static String[] nameItemsInArea = new String[100];
    public static boolean[] digable = new boolean[100];    
    public static String[] digableItem = new String[100];
    
    
    
    public static void going() {
        wantedLocation = currentLocation + Main.directionValue;
        locationInfo(wantedLocation);
    }
    
    public static void locationInfo(int Loc) {
        
        d = Main.directionName;
        
        switch(Loc) {
            
            case 51:
                if(d == "west") { //<-- CHANGE
                    System.out.println("You go " + COLOR_BLUE + d + COLOR_RESET);
                    currentLocation = wantedLocation;
                    digable[currentLocation] = false; //<-- CHANGE TO FALSE IF NOT DIGABLE || CHANGE TO TRUE IF DIGABLE
                    digableItem[currentLocation] = ""; //<-- CHANGE
                    if (numItemsInArea[currentLocation] == 0) {
                        go = true;
                    }
                    else {
                        go = false;
                        Around.myPickUps2 = nameItemsInArea[currentLocation];
                    }
                    Around.myDescription = "You find yourself at the end of a dirt road. "; //<-- CHANGE
                    Around.myDirection2 = "east"; //<-- CHANGE
                }
                else {
                    System.out.println("You can't go that direction.");
                }
                break;
            case 52:
                if((d == "east") || (d == "south")) { //<-- CHANGE
                    System.out.println("You go " + COLOR_BLUE + d + COLOR_RESET);
                    currentLocation = wantedLocation;
                    digable[currentLocation] = true; //<-- CHANGE TO FALSE IF NOT DIGABLE || CHANGE TO TRUE IF DIGABLE
                    digableItem[currentLocation] = COLOR_YELLOW + "-coin\n" + COLOR_RESET; //<-- CHANGE
                    if (numItemsInArea[currentLocation] == 0) {
                        go = true;
                    }
                    else {
                        go = false;
                        Around.myPickUps2 = nameItemsInArea[currentLocation];
                    }
                    Around.myDescription = "You are on a dirt path. "; //<-- CHANGE
                    Around.myDirection2 = "west" + COLOR_RESET + " or " + COLOR_BLUE + "north"; //<-- CHANGE
                }
                else {
                    System.out.println("You can't go that direction.");
                }
                break;
            case 42:
                if(d == "north") { //<-- CHANGE
                    System.out.println("You go " + COLOR_BLUE + d + COLOR_RESET);
                    currentLocation = wantedLocation;
                    digable[currentLocation] = false; //<-- CHANGE TO FALSE IF NOT DIGABLE || CHANGE TO TRUE IF DIGABLE
                    digableItem[currentLocation] = COLOR_PURPLE + "" + COLOR_RESET; //<-- CHANGE
                    if (numItemsInArea[currentLocation] == 0) {
                        go = true;
                    }
                    else {
                        go = false;
                        Around.myPickUps2 = nameItemsInArea[currentLocation];
                    }
                    Around.myDescription = "You are at a dead end. "; //<-- CHANGE
                    Around.myDirection2 = "south"; //<-- CHANGE
                }
                else {
                    System.out.println("You can't go that direction.");
                }
                break;
            default:
                System.out.println("You can't go that direction.");
            
        }
        
    }
}
