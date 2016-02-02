/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */

public class Zoo {
    
    public static void main(String[] args)
    {
        
        Animal[] animals = new Animal[]{
            new Lion("Leo"),
            new Butterfly("Bobby"),
            new Capybara("Jim"),
            new Skeleton("Calcium the nerdy skeleton"),
            new Dragon("The Magic Dragon, Puff"),
            new Dragon("Rosie the Red")
        };
        ///Instantiate the animals we have at our zoo
        
        
        ///Print a welcome message
        System.out.println("Welcome to the zoo program.");
        
        
        ///Print the animals at the zoo        
        System.out.println("There sure are a lot of animals here. Let's take a look at what we have...");
        
        for(int i = 0; i < animals.length; i++)
        {
            System.out.println(animals[i].getName());
        }
        
           
        ///Tell about how the animals move about
        System.out.println();
        System.out.println("That was fun. Now let's talk about how these animals move about.");
        
        for(int i = 0; i < animals.length; i++)
        {
            System.out.println(animals[i].getMovement());
        }
        
        
        ///Tell about where the animals live
        System.out.println();
        System.out.println("You won't find all these animals in your backyard. Let me tell you where you can find them.");
        
        for(int i = 0; i < animals.length; i++)
        {
            System.out.println(animals[i].getHabitat());
        }
        System.out.println();
        System.out.println("Now I know you're all curious about these animals will eat. Well, I'll tell you...");
         
        for(int i = 0; i < animals.length; i++)
        {
            if(animals[i] instanceof Dragon)
            {
                Object dragon = animals[i];
                System.out.println(dragon.getName());
            }
        }
        
       //System.out.println(animals[0].toString());
        
        System.out.println("Puff looks mad....");
        //System.out.println(animals[4].breatheFire());
        
        
        
        ///Print an exit message
        System.out.println();
        System.out.println("You have left the zoo. Come again soon. We'd love to have you for dinner.");
    }
    
}
