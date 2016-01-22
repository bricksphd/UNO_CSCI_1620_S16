import java.lang.reflect.*;
import java.util.*;


public class Main {
    
    public static boolean cont = true;
    
	public static Me me;
	
	public static List<Object> everythingInTheRoom = new ArrayList<Object>();

	public static void main(String[] args) {
		
		me = new Me();
		
        everythingInTheRoom.add(new Around());
        everythingInTheRoom.add(new Shovel());
		//everythingInTheRoom.add(me);
		
		//everythingInTheRoom.add(new Hammer());
        
        //everythingInTheRoom.add(new Alien());
        
        //everythingInTheRoom.add(new Ship());
        
        //everythingInTheRoom.add(new Box());
		
		boolean done = false;
		
		System.out.println("Welcome to the explorer game.");
		
        System.out.println();
        System.out.println("------------------");
        System.out.println();
        
        describeScene();
        
        
		do
		{
            if(cont == true) {
                System.out.println("--------**----------");
						
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
				method = o.getClass().getMethod("description", null);
				
				if(method != null)
				{
					String s = (String)method.invoke(o, new Object[]{});
					System.out.println(s);
				}
				
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


	private static boolean respondToInput(String input) {
		boolean done = false;
		
		switch (input){
		case "exit":
			done = true;
			System.out.println("OK, if you'd rather do something else....");
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
						//e.printStackTrace();
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
		default:
			confused();
			break;
		}
		
	}


	private static void shout() {
		System.out.println("Echo...echo...echo...");
		
		// TODO Auto-generated method stub
		
	}
	

}
