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
    Button response1;
    Button response2;
    Button response3;
    Text reaction1;
    Text reaction2;
    Text reaction3;
    
    // All music and SFX
    GreenfootSound gainPoints = new GreenfootSound("gain points.wav");
    GreenfootSound losePoints = new GreenfootSound("lose points.wav");
    GreenfootSound happy = new GreenfootSound("happy.wav");
    GreenfootSound neutral = new GreenfootSound("neutral.wav");
    GreenfootSound upset = new GreenfootSound("upset.wav");
    
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
        // Game beginning
        beginRitual();
        changeMary(); // Mary appears in mirror and has different reactions.
        //Greenfoot.setSpeed(10);
        // 10 prompts
        //prompt1();
        //prompt2();
    }
    
    /**
     * Setting up the question/prompt, reactions, and responses
     * to be displayed in the game.
     * 
     * @param Indexes of associated text.
     */
    public void setUp(int q, int r1, int r2, int r3)
    {
        prompt = new Text(" " + questions.get(q).toString() + " ", 30);
        response1 = new Button(" " + responses.get(r1).toString() + " ", 30);
        response2 = new Button(" " + responses.get(r2).toString() + " ", 30);
        response3 = new Button(" " + responses.get(r3).toString() + " ", 30);
        reaction1 = new Text(" " + reactions.get(r1).toString() + " ", 30);
        reaction2 = new Text(" " + reactions.get(r2).toString() + " ", 30);
        reaction3 = new Text(" " + reactions.get(r3).toString() + " ", 30);
    }
    
    /**
     * Removes old prompt and response objects.
     */
    public void clear()
    {
        removeObject(prompt);
        removeObject(response1);
        removeObject(response2);
        removeObject(response3);
    }
    
    public void beginRitual()
    {
        setBackground("mirror.png");
        addObject(playerBox, 400, 500);
        addObject(ritual1, 400, 520);
        Greenfoot.delay(300);
        removeObject(ritual1);
        addObject(ritual2, 400, 520);
        setBackground("black background.png");
        Greenfoot.delay(200);
        removeObject(playerBox);
        removeObject(ritual2);
    }
    
    public void prompt1()
    {
        setUp(0, 0, 1, 2);
        addObject(maryBox, 400, 500);
        addObject(prompt, 400, 520);
        addObject(response1, 400, 350);
        addObject(response2, 400, 390);
        addObject(response3, 400, 430);
        //Greenfoot.delay(200);
        if(Greenfoot.mouseClicked(response1))
        {
            clear();
            System.out.println("hi");
            addObject(reaction1, 400, 520);
        }
        else if(Greenfoot.mouseClicked(response1))
        {
            clear();
            System.out.println("hi");
            romanceScore += 10;
            addObject(reaction2, 400, 520);
        }
        else
        {
            clear();
            System.out.println("hi");
            romanceScore -= 10;
            addObject(reaction3, 400, 520);
        }
    }
    
    public void prompt2() 
    {
        setUp(1, 3, 4, 5);
        addObject(maryBox, 400, 500);
        addObject(prompt, 400, 520);
        addObject(response1, 400, 350);
        addObject(response2, 400, 390);
        addObject(response3, 400, 430);
        //Greenfoot.delay(200);
        if(Greenfoot.mouseClicked(response1))
        {
            clear();
            addObject(reaction1, 400, 520);
        }
        else if(Greenfoot.mouseClicked(response1))
        {
            clear();
            addObject(reaction2, 400, 520);
        }
        else
        {
            clear();
            addObject(reaction3, 400, 520);
        }
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
        } catch (Exception e) {

        }
        try{
            readPath(reactions, reactionPath);
        } catch (Exception e) {

        }
        try{
            readPath(responses, responsePath);
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
