public class Around{
    
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";
    
    public static String myDescription =  "";
    public static final String myDirection1 = "You can only go ";
    public static String myDirection2 = "";
    public static final String myDirection3 = ".";
    public static final String myPickUps1 = "\n\nThere is a...\n";
    public static String myPickUps2 = "";
    public static final String myPickUps3 = "nearby.";
    public static String newDescription;
    
    public static String description()
    {
        newDescription = myDescription;
        if(Location.go == true) {
            newDescription = myDescription + myDirection1 + COLOR_BLUE + myDirection2 + COLOR_RESET + myDirection3;
        }
        else {
            newDescription = myDescription + myDirection1 + COLOR_BLUE + myDirection2 + COLOR_RESET + myDirection3 + myPickUps1 + COLOR_RED + myPickUps2 + COLOR_RESET + myPickUps3;
        }
        return newDescription;
    }
    
    public static String look() {
        newDescription = myDescription;
        if(Location.go == true) {
            newDescription = myDescription + myDirection1 + COLOR_BLUE + myDirection2 + COLOR_RESET + myDirection3;
        }
        else {
            newDescription = myDescription + myDirection1 + COLOR_BLUE + myDirection2 + COLOR_RESET + myDirection3 + myPickUps1 + myPickUps2 + myPickUps3;
        }
        return newDescription;
    }
    
}
