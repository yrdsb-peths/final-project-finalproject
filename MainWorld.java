import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main portion of the game.
 * 
 * @author David, Catherine, Valerie 
 * @version Dec. 29/21
 */
public class MainWorld extends World
{
    int romanceScore = 0;
    // Should questions be in a list? (Text[])
    Text ritual = new Text(" I have been lonely for a while. ", 38, 255, 255, 255, 0, 0, 0);
    Text ritualAns1 = new Text(" Summon Bloody Mary ", 33);   
    
    /**
     * Constructor for objects of class MainWorld.
     * 
     */
    public MainWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act()
    {
        beginRitual();
    }
    
    public void beginRitual()
    {
        setBackground("mirror.png");
        addObject(ritual, 400, 450);
        addObject(ritualAns1, 400, 500);
    }
}
