/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */
package day04.section5;

public class Zoo {
    
    public static void main(String[] args)
    {
        ///Instantiate the animals we have at our zoo
        Lion leo = new Lion("Leo");
        Butterfly butterfly = new Butterfly("Bobby");
        Capybara capybara = new Capybara("Jim");
        
        System.out.println(leo.getClass().getName());
        
        System.out.println(leo.toString());
        
        ///Print a welcome message
        System.out.println("Welcome to the zoo program.");
        
        
        ///Print the animals at the zoo        
        System.out.println("There sure are a lot of animals here. Let's take a look at what we have...");
        
        System.out.println(leo.getName());
        System.out.println(butterfly.getName());
        System.out.println(capybara.getName());
        
        
        ///Tell about how the animals move about
        System.out.println();
        System.out.println("That was fun. Now let's talk about how these animals move about.");
        
        System.out.println(leo.getMovement());
        System.out.println(butterfly.getMovement());
        System.out.println(capybara.getMovement());
        
        
        ///Tell about where the animals live
        System.out.println();
        System.out.println("You won't find all these animals in your backyard. Let me tell you where you can find them.");
        
        System.out.println(leo.getHabitat());
        System.out.println(butterfly.getHabitat());
        System.out.println(capybara.getHabitat());
        
        System.out.println();
        System.out.println("Now I know you're all curious about these animals will eat. Well, I'll tell you...");
         
        
        ///Print an exit message
        System.out.println();
        System.out.println("You have left the zoo. Come again soon. We'd love to have you for dinner.");
    }
    
}
