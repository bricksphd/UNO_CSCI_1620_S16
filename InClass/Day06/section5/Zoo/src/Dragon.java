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
    
    public Dragon(String inNickName)
    {
        super(inNickName);
        name = "Dragon";
        habitat = "Deep dark caves near the chulu-man.";
        movement = "move by flapping their wings.";
    }
    
    public String breatheFire()
    {
        return "All animals (and skeletons) are instantly charred. Every Chulu the Great dies.";
        
    }
}
