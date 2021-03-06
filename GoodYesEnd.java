import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ending for if the user decides to date Mary.
 * 
 * @author Valerie
 * @version Jan. 9/22
 */
public class GoodYesEnd extends World
{
    Button cont = new Button(" Press to continue ", 40);
    GreenfootSound musicSFX = new GreenfootSound("happy end.wav");
    String dialogue = "2 years later, Mary and I are still going strong. \n" +
                      "I talk to her through the mirror everyday and \n" +
                      "spend time with her. \n\n";
    String dialogue2 ="We can't predict the future of our relationship, \n" + 
                      "but I enjoy every moment I spend with her. \n" +
                      "As long as we're both here for each other, I \n" + 
                      "think we'll be just fine.";
                      
    Text endText = new Text(dialogue, 30, 50);
    Text endText2 = new Text(dialogue2, 30, 80);
    Integer score;
    
    /**
     * Constructor for objects of class GoodYesEnd.
     * 
     */
    public GoodYesEnd(Integer score)
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        this.score = score;
        addObject(endText, 400, 70);
        addObject(endText2, 400, 480);
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
