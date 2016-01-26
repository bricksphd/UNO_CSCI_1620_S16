/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */
package day04.base.old;

import day04.section5.Lion;
import day04.base.old.Bird;

public class Zoo {
    
    public static void main(String[] args)
    {
        System.out.println("Welcome to the zoo program.");
        
        Lion lyle = new Lion("Lyel");
        Lion leo = new Lion("Leo");
        
        Tiger tammy = new Tiger("Tammy");
        
        Bird bobby = new Bird("Bobby");
        
        System.out.println("There sure are a lot of animals here. Let's take a look at what we have...");
        
        System.out.println(lyle.getName());
        System.out.println(leo.getName());
        System.out.println(tammy.getName());
        System.out.println(bobby.getName());
        
        System.out.println();
        System.out.println("That was fun. Now let's talk about how these animals move about.");
        
        
        System.out.println(lyle.getMovement());
        System.out.println(leo.getMovement());
        System.out.println(tammy.getMovement());
        System.out.println(bobby.getMovement());
        
        
        System.out.println();
        System.out.println("You won't find all these animals in your backyard. Let me tell you where you can find them.");
        System.out.println(lyle.getHabitat());
        System.out.println(leo.getHabitat());
        System.out.println(tammy.getHabitat());
        System.out.println(bobby.getHabitat());
        
        System.out.println();
        
        System.out.println("You have left the zoo. Come again soon. We'd love to have you for dinner.");
    }
    
}
