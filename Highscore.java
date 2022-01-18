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
    LinkedHashMap<Integer, String> highscores;
    int y = 100;
    
    /**
     * Constructor for objects of class Highscore.
     * 
     */
    public Highscore(Integer score, String name)
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(cont, 620, 550);
        
        // Getting linked arraylist of sorted scores.
        board = new ScoreBoard(score, name);
        highscores = board.getSortedScores();
        
        // Displaying highscores and names.
        Text boardScores = new Text(highscores.keySet().toString(), 30, 0);
        Text boardNames = new Text(highscores.values().toString(), 30, 0);
        addObject(boardScores, 600, 200);
        addObject(boardNames, 160, 200);
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
