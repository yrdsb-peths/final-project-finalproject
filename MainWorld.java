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
    
    // For setup of each prompt/question.
    Text prompt;
    Text response1;
    Text response2;
    Text response3;
    Text reaction1;
    Text reaction2;
    Text reaction3;

    // Text for when player summons Mary in the beginning of the game.
    Text ritual1 = new Text(" Well this is getting depressing. Who thought summoning \n" +
                            "a spirit was the last resort to curing loneliness. Whatever. \n" +
                            "Let me go turn off the light. ",25);

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
        //debug();
        System.out.println(questions.toString());
    }
    
    public void debug()
    {
        String q = responses.get(0).toString();
        Text prompt = new Text(q, 22);
        addObject(prompt, 400, 400);
    }
    
    /**
     * Setting up the question/prompt, reactions, and responses
     * to be displayed in the game.
     * 
     * @param Indexes of associated text.
     */
    public void setUp(int q, int res1, int res2, int res3, int react1, int react2, int react3)
    {
        prompt = new Text(questions.get(q).toString(), 25);
        response1 = new Text(responses.get(res1).toString(), 25);
        response2 = new Text(responses.get(res2).toString(), 25);
        response3 = new Text(responses.get(res3).toString(), 25);
        reaction1 = new Text(reactions.get(react1).toString(), 25);
        reaction2 = new Text(reactions.get(react2).toString(), 25);
        reaction3 = new Text(reactions.get(react3).toString(), 25);
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
            Greenfoot.delay(200);
        }
    }

    public void prompt1()
    {
        setUp(0, 0, 1, 2, 0, 1, 2);
        addObject(prompt, 400, 520);
        addObject(response1, 400, 400);
        addObject(response2, 400, 420);
        addObject(response3, 400, 440);
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
