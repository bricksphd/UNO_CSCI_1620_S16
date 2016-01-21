/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */

package day04.base.old;

/**
/* The class Bird
*/
class Bird
{
    private String name = "bird";
    
    private String nickName;
    
    private String movement = "flaps its wings";
    
    private String habitat = "lives just about everywhere";
    
    /**
    /* Default constructor
    */
    public Bird(String inNickName)
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
