import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartPage extends World
{
    Text start = new Text(" Press to Start ", 50, 255, 255, 255, 70, 70, 70); 
    
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
        if(Greenfoot.mouseClicked(start))
        {
            System.out.println("hi");
        }
    }
}
