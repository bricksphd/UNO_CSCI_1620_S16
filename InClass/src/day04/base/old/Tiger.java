/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */

package day04.base.old;

/**
/* The class Tiger
*/
class Tiger
{
    private String name = "tiger";
    
    private String nickName;
    
    private String movement = "runs on all fours";
    
    private String habitat = "sout each asia";
    
    /**
    /* Default constructor
    */
    public Tiger(String inNickName)
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
