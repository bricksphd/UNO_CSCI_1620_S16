
/**
 * Runs a program that hsays messages based on slipping on ice.
 */
public class Main{
    
    /** describes the state of the pain */
    public static String hurtMessage = "Ouch, that hurt!";
    
    /**
     * Entry point for our application
     */
    public static void main(String[] args)
    {
        slipOnTheIce(3);
        
        
    }
    
    /**
     * Just prints out all the bad things that happen when you slip on ice.
      * @param timesYouSlip How many times you slip
      * @return Whether or not you died. Always false.
     */
    public static boolean slipOnTheIce(int timesYouSlip)
    {
        System.out.println("You slip on the ice " + timesYouSlip + " times.");
        System.out.println(hurtMessage);
        System.out.println("Don't do that again");
        
        return false;
    }
}