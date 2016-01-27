import java.lang.reflect.*;
import java.util.*;


public class Main {
    
    public static boolean cont = true;

    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";
    
    public static int directionValue = 51;
    public static String directionName;
	public static Me me;
	
	public static List<Object> everythingInTheRoom = new ArrayList<Object>();

	public static void main(String[] args) {
            
            for(int x = 0; x < 100; x++) {
                GrabOrDrop.itemGrabbed[x] = false;
                Location.numItemsInArea[x] = 0;
                Location.nameItemsInArea[x] = "";
            }
            
            Around.myDescription = "You find yourself at the end of a dirt road. ";
            Around.myDirection2 = "east";
            Around.myPickUps2 = COLOR_RED + "-shovel\n" + COLOR_RESET;
            GrabOrDrop.itemLocation[1] = 51;
            //GrabOrDrop.itemName[1] = COLOR_RED + "-shovel\n" + COLOR_RESET;
            Location.nameItemsInArea[51] = COLOR_RED + "-shovel\n" + COLOR_RESET;
            Location.numItemsInArea[51] = 1;
            
            GrabOrDrop.itemNumber = 1;
            GrabOrDrop.itemName[1] = COLOR_RED + "-shovel\n" + COLOR_RESET;

		me = new Me();
		
        everythingInTheRoom.add(new Around());
        everythingInTheRoom.add(new Shovel());
        everythingInTheRoom.add(new Compass());

        //everythingInTheRoom.add(me);
		
        //everythingInTheRoom.add(new Hammer());
        
        //everythingInTheRoom.add(new Alien());
        
        //everythingInTheRoom.add(new Ship());
        
        //everythingInTheRoom.add(new Box());
		
		boolean done = false;
		
		System.out.println("Welcome to the explorer game.");
		
        System.out.println();
        System.out.println(COLOR_WHITE + "------------------" + COLOR_RESET);
        System.out.println();
        
        describeScene();
        
        
		do
		{
            if(cont == true) {
                System.out.println(COLOR_WHITE + "------------------" + COLOR_RESET);
						
                promptInput();
			
                String input = getLine();
            
                System.out.println();
			
                done = respondToInput(input);
            }
            else {
                confused();
            }
			
		}while(!done);

	}


	private static void describeScene() {
		for(Object o : everythingInTheRoom)
		{
			Method method;
			try {
				method = o.getClass().getMethod("description", (Class<?>[]) null);
				
				if(method != null)
				{
					String s = (String)method.invoke(o, new Object[]{});
					System.out.print(s);
				}
				
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
                System.out.println("\n");
		
	}


	private static boolean respondToInput(String input) {
		boolean done = false;
		
		switch (input){
		case "exit":
			done = true;
			System.out.println("OK, if you'd rather do something else....");
			break;
                case "n":
                case "go n":
                case "go north":
                    goDirection('n');
                    break;
                case "e":
                case "go e":
                case "go east":
                    goDirection('e');
                    break;
                case "s":
                case "go s":
                case "go south":
                    goDirection('s');
                    break;
                case "w":
                case "go w":
                case "go west":
                    goDirection('w');
                    break;
                      
		default:
                    parse(input);
                    if(cont == false) {
                        confused();
                        cont = true;
                    }
                    break;			
		}
		return done;
	}


	private static String getLine() {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		return input;
	}


	private static void promptInput() {
		System.out.println("What do you want to do now?");
	}
	
	
	private static void confused()
	{
		System.out.println("I don't understand what you want to do. Please Try again.");
	}
	
	private static void parse(String input)
	{
		String[] splits = input.split(" ");
		if(splits.length == 1)
		{
			localParse(splits[0]);
		}
		else if(splits.length == 2)
		{
			String verbString = splits[0];
			String directObjectString = splits[1];
			
			Object directObject = null;
			
			for(Object o : everythingInTheRoom)
			{
				if(o.getClass().getName().equalsIgnoreCase(directObjectString))
				{
					directObject = o;
				}
			}
			
			if(directObject == null)
			{
				confused();
				return;
			}
			
			Method[] methods = directObject.getClass().getMethods();
			
			for(Method method : methods)
			{
				if(method.getName().equalsIgnoreCase(verbString))
				{
					try {
                        String s = (String)method.invoke(directObject, new Object[]{});
						System.out.println(s);
                        cont = true;
                        
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    cont = true;
                    break;
				}
                else {
                    cont = false;
                }
			}
			
			
		}
		else
			confused();
	}


	private static void localParse(String string) {
            switch (string){
                case "shout":
                    shout();
                    break;
                case "look":
                    System.out.println(Around.look());
                    break;
                case "inv":
                    System.out.print(Inventory.fullInv);
                    break;
                case "inventory":
                    System.out.print(Inventory.fullInv);
                    break;
                case "dig":
                    System.out.print(Shovel.dig());
                    break;
                default:
                    confused();
                    break;
            }
		
	}
    
    private static void shout() {
            System.out.println("Echo...echo...echo...");

            // TODO Auto-generated method stub

    }
    
    private static void goDirection(char direction) {
        switch (direction) {
            case 'n':
                directionValue = -10;
                directionName = "north";
                break;
            case 'e':
                directionValue = 1;
                directionName = "east";
                break;
            case 's':
                directionValue = 10;
                directionName = "south";
                break;
            case 'w':
                directionValue = -1;
                directionName = "west";
                break;
            default:
                break;
        }
        
        Location.going();
    }
	

}
