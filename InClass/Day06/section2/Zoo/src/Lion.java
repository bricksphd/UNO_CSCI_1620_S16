/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */


/**
/* The class Lion
*/
public class Lion
{
    private String name = "lion";
    
    private String nickName;
    
    private String movement = "runs on all fours";
    
    private String habitat = "africa and south west asia";
    
    /**
    /* Default constructor
    */
    public Lion(String inNickName)
    {
        nickName = inNickName;

    }
    
    public String getName()
    {
        return "There is a " + name + " named " + nickName;
    }
    
    public String getMovement()
    {
        return nickName + " the " + name + " " + movement;
    }
    
    public String getNickName()
    {
        return "We call this " + name + " " + nickName;
    }
    
    public String getHabitat()
    {
        return nickName + " the " + name + " lives in " + habitat;
    }
}
