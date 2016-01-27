public class Box{
    
    private String myDescriptionClosed = "You find a small box and you pull a string to open the box.  The box looks suspiciously like a school bus ran over a gold fish. Strange. I need to wake up soon.";
    
    private String myDescriptionOpen = "It looks the exact same and nothing in it but a noxious odor that smells like meatloaf.";
    
    private String myDescriptionBurned = "It looks like a pile of purple ashes and it floats now, too, in the air that isn't on the moon because it's science fiction.";
    
    
    private final int CLOSED_STATE = 1;
    
    private final int OPEN_STATE = 2;
    
    private final int BURNED_STATE = 3;
    
    private int state = CLOSED_STATE;
    
    public String description()
    {
        if(state == OPEN_STATE)
            return myDescriptionOpen;
        else if(state == CLOSED_STATE)
            return myDescriptionClosed;
        else 
            return myDescriptionBurned;
    }
    
    public String open()
    {
        state = OPEN_STATE;
        
        return "Frustration overwhelms you as it doesn't open. You pass out from a strange smell when the box suddenly swings open for no apparent reason.";
    }
    
    public String burn()
    {
        state = BURNED_STATE;
        
        return "AS you use your firepowers to burn the box you wonder if this is the right thing to do. Too bad. Fireworks.";
    }
}