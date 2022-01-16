import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

/**
 * Displays all highscores.
 * 
 * @author Valerie 
 * @version Jan. 12/22
 */
public class Highscore extends World
{
    GreenfootSound musicSFX = new GreenfootSound("title.wav");
    Button cont = new Button(" Press to continue ", 40); 
    /**
     * Constructor for objects of class Highscore.
     * 
     */
    public Highscore()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(cont, 620, 550);
        //LinkedHashMap<Integer, String> allScores = score3.getSortedScores();
        //System.out.println(allScores);
    }
    
    public void act()
    {
        musicSFX.play();
        if(Greenfoot.mouseClicked(cont))
        {
            musicSFX.stop();
            Greenfoot.setWorld(new StartPage());
        }
    }
}
