public class Ship{
    private String myDescription = "A giant red flying saucer is before your eyes. It glows a faint yellow color, which is funny because it's red. The bumper sticker says If you can read this you are flying too close.";
    
    public String description()
    {
        return myDescription;
    }
    
    public String fly()
    {
        myDescription = "Well it's yellow and it has a new bumper stick that says 'Nixon '72' and has three mysterious headlights. How strange you think. We impeached him.";
        
        return "Going faster than the speed of light would be fun, but this saucer goes about 10 miles an hour. It feels like a school bus, strangely.  You get out of the saucer and hear a funny coughing noise.";
    }
}