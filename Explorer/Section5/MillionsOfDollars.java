public class MillionsOfDollars{
    
    private String myDescriptionFirst = "You see piles and piles of dollar bills. You feel a strange, ectstatic feeling because you are going to be rich. And run for presdient.";
    
    private String myDescriptionAsh = "Instead of money you see a pile of gray ash and you howl with misery as you know you have lost your fortune.";
    
    
    
    private final int normalState = 1;
    
    private final int ashState = 2;
    
    private int moneyState = normalState;
    
    public String description()
    {
        if(moneyState == normalState)
        {
            return myDescriptionFirst;
        }
        else
            return myDescriptionAsh;
    }
    public String jumpIn()
    {
        moneyState = ashState;
        
        return "You jump int othe money and it feels amazing, but as you touch the money you can feel it turn into ash. That's weird, you think.";
    }
}