import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ending for if the player decides to befriend Mary.
 * 
 * @author Valerie 
 * @version Jan. 9/22
 */
public class GoodNoEnd extends World
{
    String dialogue = "Within a span of a year, Mary and I have become \n" +
                      "close friends. Knowing a spirit has its perks. \n\n" +
                      "We talk every few days and have a blast. I give \n" +
                      "her ideas on how to scare people and she supports \n" +
                      "me through my dating struggles. I may not \n" +
                      "have met the one, but I'm glad I've. \n" +
                      "found someone who'll always be there for me. \n";
    
    Text endText = new Text(dialogue, 30, 255, 255, 255, 0, 0, 0);
    
    /**
     * Constructor for objects of class GoodNoEnd.
     * 
     */
    public GoodNoEnd()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(endText, 400, 300); 
    }
}
