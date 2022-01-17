import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A jumpscare if a user fails to impress Mary.
 * 
 * @author Valerie Sum
 * @version Dec. 29/21
 */
public class Jumpscare extends World
{
    GreenfootSound scareSFX = new GreenfootSound("jumpscare.wav");
    
    /**
     * Constructor for objects of class Jumpscare.
     * 
     */
    public Jumpscare()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act() 
    {
        setBackground("angry mary.png");
        Greenfoot.delay(100);
        setBackground("jumpscare.jpg");
        scareSFX.setVolume(40);
        scareSFX.play();
        Greenfoot.delay(200);
        Greenfoot.setWorld(new StartPage());
    }
}
