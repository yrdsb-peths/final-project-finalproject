import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextChoice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextChoice 
{
    private String mary1;
    private String playerResponse;
    private String maryResponse;
    private boolean choice;
    public TextChoice(String mary1pos, String mary1neg, String res1, String res2, String res3, String mRes1pos, String mRes1neg, String mRes2pos, String mRes2neg, String mRes3pos, String mRes3neg, boolean positive){
        String[] posOption = new String[2];
        posOption[0] = res1 
        String[] nulOption = new String[2];
        String[] negOption = new String[2];
        if (positive){
            mary1 = mary1pos;
        } else {
            mary1 = mary1neg;
        }     
    }

    public String getText(){
        return mary1;
    }

    public String getResponse1(){
        return playerResponse;
    }
}
