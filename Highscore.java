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
    ScoreBoard board;
    ArrayList<Integer> highscores;
    int y = 180;
    
    /**
     * Constructor for objects of class Highscore.
     * 
     */
    public Highscore(Integer score)
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(cont, 620, 550);
        
        // Getting arraylist of sorted scores.
        board = new ScoreBoard(score);
        highscores = board.getHighscores();
        
        // Displaying highscores and names.
        for(int i = highscores.size() - 1; i >= 0; i--)
        {
            Text theScore = new Text(highscores.get(i).toString(), 50, 0);
            addObject(theScore, 400, y);
            y += 50;
        }
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
