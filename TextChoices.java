import greenfoot.*;
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextChoices here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextChoices extends Actor
{
    public TextChoices() 
    throws FileNotFoundException
    {
        String questionPath = "C:\\Users\\david\\OneDrive\\Documents\\GitHub\\final-project-finalproject\\TextFiles\\Questions.txt";
        String responsePath = "C:\\Users\\david\\OneDrive\\Documents\\GitHub\\final-project-finalproject\\TextFiles\\Responses.txt";;
        String reactionPath = "C:\\Users\\david\\OneDrive\\Documents\\GitHub\\final-project-finalproject\\TextFiles\\Reactions.txt";;
        
        
        ArrayList<String> questions = new ArrayList<String>(); //question 0 associated with response 0
        ArrayList<String> responses = new ArrayList<String>();
        ArrayList<String> reactions = new ArrayList<String>();
        
        readPath(questions, questionPath);
        readPath(responses, responsePath);
        readPath(reactions, reactionPath);
        
        
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
