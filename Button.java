import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates clickable buttons. 
 * 
 * @author Valerie 
 * @version Jan. 9/22
 */
public class Button extends Actor
{
    private String content;
    private int size;
    private Color bg;
    private Color clickedbg;
    private Color hoverbg;

    /**
     * Creates text image.
     * Based off https://www.youtube.com/watch?v=NjP3MMJnvGc
     * 
     * @param content The sentences that are wanted to be displayed.
    */
    public Button(String content, int size, int r, int g, int b) 
    {
        Color background = new Color(r, g, b);
        setImage(new GreenfootImage(content, size, Color.WHITE, background));
        
        this.content = content;
        this.size = size;
        bg = background;
        clickedbg = new Color(r-20, g-20, b-20);
        hoverbg = new Color(r+20, g+20, b+20);
    }
    
    //Creates white text with pink background
    public Button(String content, int size) 
    {
        Color background = new Color(229, 115, 115);
        setImage(new GreenfootImage(content, size, Color.WHITE, background));
        
        this.content = content;
        this.size = size;
        bg = background;
        clickedbg = new Color(249, 135, 135);
        hoverbg = new Color(209, 95, 95);
    }  
    
    // Code based off of Mr. Chan.
    public void act()
    {
        MouseInfo info = Greenfoot.getMouseInfo();
        if(info == null) 
        {
            setImage(new GreenfootImage(content, size, Color.WHITE, bg));
            return;
        }

        if(info.getActor() == this)
        {
            Button button = (Button) info.getActor();

            if(Greenfoot.mousePressed(this))
            {
                setImage(new GreenfootImage(content, size, Color.WHITE, clickedbg));
            }
            else
            {
                setImage(new GreenfootImage(content, size, Color.WHITE, hoverbg));
            }
        }
        
        //setImage(new GreenfootImage(content, size, Color.WHITE, bg));
    }
}
