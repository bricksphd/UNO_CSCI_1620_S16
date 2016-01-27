/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */
package day04.section2;

public class Zoo {
    
    public static void main(String[] args)
    {
        ///Instantiate the animals we have at our zoo
        PinkFairyArmadillo pink = new PinkFairyArmadillo("Tony the Terrible");
        Hedgehog sonic = new Hedgehog("Tails");
        Duck duck = new Duck("Goose");
        
        ///Print a welcome message
        System.out.println("Welcome to the zoo program.");
        System.out.println(duck.getClass().getName());
        
        ///Print the animals at the zoo        
        System.out.println("There sure are a lot of animals here. Let's take a look at what we have...");
        System.out.println(pink.getName()); 
        System.out.println(sonic.getName()); 
        System.out.println(duck.getName()); 
        
        
        ///Tell about how the animals move about
        System.out.println();
        System.out.println("That was fun. Now let's talk about how these animals move about.");
       System.out.println(pink.getMovement()); 
       System.out.println(sonic.getMovement()); 
       System.out.println(duck.getMovement()); 
         
        
        ///Tell about where the animals live
        System.out.println();
        System.out.println("You won't find all these animals in your backyard. Let me tell you where you can find them.");
        System.out.println(pink.getHabitat()); 
        System.out.println(sonic.getHabitat()); 
        System.out.println(duck.getHabitat()); 
        
        
        System.out.println();
        System.out.println("Now I know you're all curious about these animals will eat. Well, I'll tell you...");
         
        
        ///Print an exit message
        System.out.println();
        System.out.println("You have left the zoo. Come again soon. We'd love to have you for dinner.");
    }
    
}
