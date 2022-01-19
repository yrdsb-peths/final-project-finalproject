import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Phonecall introduction to give context to main character and beginning
 * of game.
 * 
 * @author Valerie Sum 
 * @version Dec. 28/21
 */
public class Introduction extends World
{
    GreenfootSound voiceMemoSFX = new GreenfootSound("voice message.wav");
    String dialogue = "Um, hey. How are you? It's been a while since \n" +
                      "I've seen you out... \n\n" +
                      "Yeah... I know you got dumped. \n" +
                      "Your sister has been asking me to check up \n" + 
                      "on you since you won't answer her at all. \n\n" +
                      "Look, I'm saying this as your friend - there's \n" + 
                      "plenty of fish in the sea. I know one of my friends is \n" +
                      "up for a blind date, or like try something spontaneous! \n\n" +
                      "Call me back when you can, bye.";
                      
    Text phonecall = new Text(dialogue, 30, 0, 0, 0);
    Button cont = new Button(" Press to continue ", 40, 70, 70, 70); 
    
    // Text for when player summons Mary in the beginning of the game.
    Text ritual1 = new Text(" Well this is getting depressing. Who thought summoning \n" +
                            "a spirit was the last resort to curing loneliness. Whatever. \n" +
                            "Let me go turn off the light. ",25);

    Text ritual2 = new Text(" Ok, here I go. Bloody Mary, bloody Mary, \n" +
                            "bloody Mary... ", 30);
                            
    PlayerTextBox playerBox = new PlayerTextBox();

    /**
     * Constructor for objects of class Introduction.
     * 
     */
    public Introduction()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(phonecall, 400, 270);    
        voiceMemoSFX.play();
        
        addObject(cont, 630, 555);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(cont))
        {
            voiceMemoSFX.stop();
            removeObject(phonecall);
            removeObject(cont);
            beginRitual();
            Greenfoot.setWorld(new MainWorld());
        }
    }
    
    public void beginRitual()
    {
        setBackground("mirror.png");
        addObject(playerBox, 400, 500);
        addObject(ritual1, 400, 520);
        Greenfoot.delay(1500);
        removeObject(ritual1);
        addObject(ritual2, 400, 520);
        setBackground("black background.png");
        Greenfoot.delay(1000);
        removeObject(ritual2);
        removeObject(playerBox);
    }
}
