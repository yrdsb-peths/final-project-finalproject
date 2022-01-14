import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Main portion of the game.
 * 
 * @author David, Catherine, Valerie 
 * @version Dec. 29/21
 */
public class MainWorld extends World
{
    Integer romanceScore = 100;
    String name;
    PlayerTextBox playerBox = new PlayerTextBox();
    MaryTextBox maryBox = new MaryTextBox();

    ArrayList<String> questions = new ArrayList<String>(); //question 0 associated with response 0
    ArrayList<String> responses = new ArrayList<String>();
    ArrayList<String> reactions = new ArrayList<String>();

    // Text for when player summons Mary in the beginning of the game.
    Text ritual1 = new Text(" Well this is getting depressing. Who thought \n" +
            "summoning a spirit was the last resort to curing \n" +
            "loneliness. Whatever. Let me go turn off the light. ",
            25);

    Text ritual2 = new Text(" Ok, here I go. Bloody Mary, bloody Mary, \n" +
            "bloody Mary ", 30);

    /**
     * Constructor for objects of class MainWorld.
     */
    public MainWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        textChoices(); 
    }

    public void act()
    {
        //beginRitual();
        //changeMary();
        //prompt1();
        //textChoices();
    }

    /**
     * Changes Mary's reaction depending on player's score.
     */
    public void changeMary()
    {
        if(romanceScore < 70) { // Super upset reaction.
            setBackground("super upset mary.png");
        }
        else if(romanceScore < 100 && romanceScore > 60) { // Upset reaction.
            setBackground("upset mary.png");
        }
        else if(romanceScore < 140 && romanceScore > 100) { // Happy reaction.
            setBackground("happy mary.png");
        }
        else if(romanceScore > 130) { // Super happy reaction.
            setBackground("super happy mary.png");
        }
        else { // Neutral reaction.
            setBackground("mary.png");
        }
    }

    public void beginRitual()
    {
        setBackground("mirror.png");
        addObject(playerBox, 400, 500);
        addObject(ritual1, 400, 520);
        if(Greenfoot.isKeyDown("right"))
        {
            removeObject(ritual1);
            addObject(ritual2, 400, 520);
            setBackground("black background.png");
            //Greenfoot.delay(300);
        }
    }

    public void prompt1()
    {
    }

    private void textChoices()
    {
        String questionPath = "Questions.txt";
        String responsePath = "Responses.txt";
        String reactionPath = "Reactions.txt";

        try{
            readPath(questions, questionPath);
            readPath(responses, responsePath);
            readPath(reactions, reactionPath);
        } catch (Exception e) {

        }
    }

    private void readPath(ArrayList<String> temp, String path) throws FileNotFoundException{
        InputStream is = new FileInputStream(path);

        // Try block to check for exceptions
        try (Scanner sc = new Scanner(
                is, StandardCharsets.UTF_8.name())) {

            // It holds true till there is single element
            // left in the object with usage of hasNext()
            // method
            while (sc.hasNextLine()) {

                // Printing the content of file
                temp.add(sc.nextLine());
            }
        }
    }
}
