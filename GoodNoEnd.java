import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ending for if the player decides to befriend Mary.
 * 
 * @author Valerie 
 * @version Jan. 9/22
 */
public class GoodNoEnd extends World
{
    Button cont = new Button(" Press to continue ", 40);
    GreenfootSound musicSFX = new GreenfootSound("happy end.wav");
    String dialogue = "Within a span of a year, Mary and I have become \n" +
                      "close friends. Knowing a spirit has its perks. \n\n";
                      
    String dialogue2 ="We talk every few days and have a blast. I give \n" +
                      "her ideas on how to scare people and she supports \n" +
                      "me through my dating struggles. I may not \n" +
                      "have met the one, but I'm glad I've. \n" +
                      "found someone who'll always be there for me. \n";
    
    Text endText = new Text(dialogue, 30, 50);
    Text endText2 = new Text(dialogue2, 30, 80);
    Integer score;
    
    /**
     * Constructor for objects of class GoodNoEnd.
     * 
     */
    public GoodNoEnd(Integer score)
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        this.score = score;
        addObject(endText, 400, 50);
        addObject(endText2, 400, 470);
        addObject(cont, 650, 570);
    }
    
    public void act()
    {
        musicSFX.play();
        if(Greenfoot.mouseClicked(cont))
        {
            musicSFX.stop();
            Greenfoot.setWorld(new Highscore(score));
        }
    }
}
