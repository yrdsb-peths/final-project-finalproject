import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Phonecall introduction to give context to main character.
 * 
 * @author Valerie Sum 
 * @version Dec. 28/21
 */
public class Introduction extends World
{
    String dialogue = "Um, hey. How are you? It's been a while since \n" +
                      "I've seen you out... \n\n" +
                      "Yeah... Yeah I know... you got  \n" +
                      "dumped. Your sister has been asking me to check up \n" + 
                      "on you since you won't answer her at all. \n\n" +
                      "Look man, I'm saying this as your friend - there's \n" + 
                      "plenty of fish in the sea. I know one of my friends is \n" +
                      "up for a blind date, or like go on Tinder or something! \n\n" +
                      "I'll talk to you soon, bye.";
    Text phonecall = new Text(dialogue, 30, 255, 255, 255, 0, 0, 0);
    Text cont = new Text(" Press to continue ", 40, 255, 255, 255, 70, 70, 70);  
    /**
     * Constructor for objects of class Introduction.
     * 
     */
    public Introduction()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(phonecall, 400, 300);
        addObject(cont, 630, 555);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(cont))
        {
            Greenfoot.setWorld(new MainWorld());
        }
    }
}
