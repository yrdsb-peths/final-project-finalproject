import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextChoice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextChoice 
{
    private String maryQpos;
    private String maryQneg;
    private String res1;
    private String res2;
    private String res3;
    private String maryR1pos;
    private String maryR1neg;
    private String maryR2pos;
    private String maryR2neg;
    private String maryR3pos;
    private String maryR3neg;
    private boolean choice;
    public TextChoice(String text, String response, boolean positive){
        theText = text;
        choice = positive;
        
    }
    private void points (String type){
        
    }
    public String getText(){
        return theText;
    }
    public boolean getChoice(){
        return choice;
    }
    public String getResponse1(){
        return theResponse;
    }
}
