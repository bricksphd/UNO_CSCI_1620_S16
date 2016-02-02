/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bricks
 */
public class Dragon extends Animal{
    
    public Dragon(String inName)
    {
        super(inName);
        name = "Dragon";
        habitat = "In caves in Detroit.";
        movement = "They waddle and sometimes fly to Michigan.";
    }
    
    public String burnSomething()
    {
        return "I burninatored you!";
    }
    
}
