
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;

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

    // Highscore to be displayed.
    Text score;

    // All music and SFX
    GreenfootSound gainPoints = new GreenfootSound("gain points.wav");
    GreenfootSound losePoints = new GreenfootSound("lose points.wav");
    GreenfootSound happy = new GreenfootSound("happy.wav");
    GreenfootSound neutral = new GreenfootSound("neutral.wav");
    GreenfootSound upset = new GreenfootSound("upset.wav");

    // Text for when player summons Mary in the beginning of the game.
    Text ritual1 = new Text("Well this is getting depressing. Who thought summoning \n" +
            "a spirit was the last resort to curing loneliness. Whatever. \n" +
            "Let me go turn off the light.",25);

    Text ritual2 = new Text("Ok, here I go. Bloody Mary, bloody Mary, \n" +
            "bloody Mary...", 30);
    int counter = 0;

    // Ending text.
    Text badEnd = new Text("Unfortunately, I have to do my job now. Sorry about this, \n" +
            " you weren’t a good enough date for me to let you go.       ", 28);

    Text neutralEnd = new Text("I’ll get going now. I better not see you again, or else I \n" +
            "won't be so kind.", 28);

    Text goodEnd = new Text("Um, actually wait! Do you think we could...", 28);
    Button date = new Button(" Date Mary <3 ", 25);
    Button befriend = new Button(" Befriend Mary :) ", 25);

    // Y coordinates for responses.
    ArrayList<Integer> yValues = new ArrayList<Integer>();

    /**
     * Constructor for objects of class MainWorld.
     */
    public MainWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        textChoices(); 
        addObject(maryBox, 400, 500);
        setUp(counter, counter*3, counter*3+1, counter*3+2);
    }

    public void act()
    {
        // Mary appears in mirror and has different reactions.
        changeMary();

        // Background music.
        backgroundMusic();

        // Displaying score.
        score = new Text(" Highscore: " + romanceScore + " ", 30, 80, 80, 80);
        addObject(score, 115, 40);
        

        // 10 prompts
        if(Greenfoot.mouseClicked(response1))
        {
            clear();
            addObject(reaction1, 400, 520);
            counter++; 
            Greenfoot.delay(150);
            changeMary();
            clear();
            setUp(counter, counter*3, counter*3+1, counter*3+2);
        }
        else if(Greenfoot.mouseClicked(response2))
        {
            gainPoints.play();
            setBackground("happy mary.png");
            clear();
            addObject(reaction2, 400, 520);
            romanceScore += 10;
            counter++;
            Greenfoot.delay(150);
            changeMary();
            clear();
            setUp(counter, counter*3, counter*3+1, counter*3+2);
        }
        else if (Greenfoot.mouseClicked(response3))
        {
            losePoints.play();
            setBackground("upset mary.png");
            clear();
            addObject(reaction3, 400, 520);
            romanceScore -= 10;

            counter++;

            Greenfoot.delay(150);
            changeMary();
            clear();
            setUp(counter, counter*3, counter*3+1, counter*3+2);
        }
        if(counter >= 9)
        {
            ending();
        }
    }

    /**
     * Endings to the game.
     */
    public void ending()
    {
        clear();

        // Jumpscare for bad end.
        if(romanceScore < 70)
        {
            addObject(badEnd, 400, 520);
            Greenfoot.delay(300);
            upset.stop();
            Greenfoot.setWorld(new Jumpscare(romanceScore));
        }
        // Good ending, option to befriend or date Mary.
        else if(romanceScore > 130)
        {
            addObject(goodEnd, 400, 520);
            Greenfoot.delay(150);
            addObject(date, 400, 350);
            addObject(befriend, 400, 390);

            if(Greenfoot.mouseClicked(date)) // Date Mary.
            {
                removeObject(date);
                removeObject(befriend);
                happy.stop();
                Greenfoot.setWorld(new GoodYesEnd(romanceScore));
            }
            else if(Greenfoot.mouseClicked(befriend)) // Befriend Mary.
            {
                removeObject(date);
                removeObject(befriend);
                happy.stop();
                Greenfoot.setWorld(new GoodNoEnd(romanceScore));
            }
        }
        //Neutral ending.
        else if (romanceScore >= 70 && romanceScore <= 130)
        {
            addObject(neutralEnd, 400, 520);
            Greenfoot.delay(300);
            neutral.stop();
            Greenfoot.setWorld(new Highscore(romanceScore));
        }
    }

    /**
     * Removes question/prompt and responses from screen.
     */
    public void clear()
    {
        removeObject(prompt);
        removeObject(response1);
        removeObject(response2);
        removeObject(response3);
        removeObject(reaction1);
        removeObject(reaction2);
        removeObject(reaction3);
        removeObject(score);
    }

    /**
     * Setting up the question/prompt, reactions, and responses
     * to be displayed in the game.
     * 
     * @param Indexes of associated text.
     */
    public void setUp(int q, int r1, int r2, int r3)
    {
        prompt = new Text(questions.get(q), 25);
        response1 = new Button(" " + responses.get(r1) + " ", 25);
        response2 = new Button(" " + responses.get(r2) + " ", 25);
        response3 = new Button(" " + responses.get(r3) + " ", 25);
        reaction1 = new Text(reactions.get(r1), 24);
        reaction2 = new Text(reactions.get(r2), 24);
        reaction3 = new Text(reactions.get(r3), 24);

        addObject(prompt, 400, 520);

        // Adding y-coordinates.
        yValues.add(310);
        yValues.add(350);
        yValues.add(390);

        addObject(response1, 400, randomY());
        addObject(response2, 400, randomY());
        addObject(response3, 400, randomY());
    }

    /**
     * Randomizes y-coordinates of the 3 responses to change their order
     * displayed on the screen.
     * 
     * @return Either 310, 350, or 390 as the y-coordinate.
     */
    public int randomY()
    {
        Random rand = new Random();
        int elem = rand.nextInt(yValues.size());
        int y = yValues.get(elem);
        yValues.remove(elem);
        return y;
    }

    /**
     * Changes background music depending on Mary's mood.
     */
    public void backgroundMusic()
    {
        if(romanceScore < 70) 
        {
            neutral.stop();
            upset.play();
        }
        else if(romanceScore >130) 
        {
            neutral.stop();
            happy.play();
        }
        else 
        {
            if(happy.isPlaying())
            {
                happy.stop();
            }
            if(upset.isPlaying())
            {
                upset.stop();
            }
            neutral.play();
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
    /**
     * Helper method that contains file path to read and store to ArrayList
     */
    private void textChoices()
    {
        //File paths
        String questionPath = "Questions.txt";
        String responsePath = "Responses.txt";
        String reactionPath = "Reactions.txt";
        //Using the reader method to fill ArrayLists
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
    /**
     * Reader method that read the files
     * 
     * @param Arraylist to be filled
     * @param Path of file to be read
     */
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
