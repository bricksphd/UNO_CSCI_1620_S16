/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day04.section2;

/**
 *
 * @author bricks
 */
public class Duck extends Animal
{
    public Duck(String inNickName)
    {
        super(inNickName);
        movement = "mostly swims and blocks traffic";
        name = "duck";
        habitat = "water";
    }
    
    public String toString()
    {
        return "This is a duck";
    }
}
