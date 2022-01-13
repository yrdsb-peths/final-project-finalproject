import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ending for if the user decides to date Mary.
 * 
 * @author Valerie
 * @version Jan. 9/22
 */
public class GoodYesEnd extends World
{
    String dialogue = "2 years later, Mary and I are still going strong. \n" +
                      "I talk to her through the mirror everyday and \n" +
                      "spend time with her. \n\n" +
                      "We can't predict the future of our relationship, \n" + 
                      "but I enjoy every moment I spend with her. \n" +
                      "As long as we're both here for each other, I \n" + 
                      "think we'll be just fine.";
    
    Text endText = new Text(dialogue, 30, 255, 255, 255, 0, 0, 0);
    /**
     * Constructor for objects of class GoodYesEnd.
     * 
     */
    public GoodYesEnd()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(endText, 400, 300);
    }
}
