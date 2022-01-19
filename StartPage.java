import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title page of the game.
 * 
 * @author Valerie Sum 
 * @version Dec. 28/21
 */
public class StartPage extends World
{
    GreenfootSound titleSFX = new GreenfootSound("title.wav");
    Button start = new Button(" Press to start ", 50, 70, 70, 70); 
    
    /**
     * Constructor for objects of class StartPage.
     * 
     */
    public StartPage()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(start, 180, 540);
    }
    
    public void act()
    {
        titleSFX.play();
        if(Greenfoot.mouseClicked(start))
        {
            titleSFX.stop();
            Greenfoot.setWorld(new Introduction());
        }
    }
}
