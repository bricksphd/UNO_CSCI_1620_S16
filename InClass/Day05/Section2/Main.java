/**
 * This is a program...I don't know..it's about you slipping on the ice
 */

public class Main{
    
    /** This is the strting that is says that you got hurt. */
    public static String hurtMessage = "Ouch, that hurt!";
    
    public static void main(String[] args)
    {
        slipOnTheIce(17);
    }
    
    /**
     * It prints out stuff.
    * @param times It the number of times you slip on the ice
    * @return Always false
    */
    public static boolean slipOnTheIce(int times)
    {
        System.out.println("You slip on the ice " + times + " times");
        System.out.println(hurtMessage);
        System.out.println("Don't do that again");
        return false;
    }
}