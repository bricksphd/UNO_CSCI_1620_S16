/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bricks
 */
public class Animal {
    
    public String name;
    
    public String nickName;
    
    public String movement;
    
    public String habitat;
    
    /**
    /* Default constructor
    */
    public Animal(String inNickName)
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

