import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextChoice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextChoice 
{
    private String theText;
    private boolean choice;
    public TextChoice(String text, boolean positive, response){
        theText = text;
        choice = positive;
    }
    public String getText(){
        return theText;
    }
    public boolean getChoice(){
        return choice;
    }
}
