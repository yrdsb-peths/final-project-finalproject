import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays text.
 * 
 * @author Valerie 
 * @version Dec. 28/21
 */
public class Text extends Actor
{
    /**
     * Creates text image.
     * Based off https://www.youtube.com/watch?v=NjP3MMJnvGc
     * 
     * @param content The sentences that are wanted to be displayed.
    */
    public Text(String content, int size, int r, int g, int b, int br, int bg, int bb) 
    {
        Color textColor = new Color(r, g, b);
        Color background = new Color(br, bg, bb);
        setImage(new GreenfootImage(content, size, textColor, background));
    }
    
    //Creates white text with grey background
    public Text(String content, int size) 
    {
        Color background = new Color(40, 40, 40);
        setImage(new GreenfootImage(content, size, Color.WHITE, background));
    }  
}