/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */

package day04.section5;

/**
/* The class Lion
*/
public class Lion extends Quadraped
{
    public Lion(String inNickName)
    {
        super(inNickName);
        habitat = "Africa and Southwest Asia";
        name = "lion";
    }
    
    public String toString()
    {
        return "This is a lion";
    }
}