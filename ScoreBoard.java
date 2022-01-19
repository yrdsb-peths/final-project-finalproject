import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

/**
 * Keeps track and recursively sorts total highscores in the game. 
 * 
 * @author Valerie Sum
 * @version Jan. 12/22
 */
public class ScoreBoard  
{
    private static ArrayList<Integer> highscores = new ArrayList<Integer>();
    
    /**
     * Constructor for objects of class ScoreBoard
     */
    public ScoreBoard(Integer highscore)
    {
        highscores.add(highscore);
        quicksort(highscores);
    }
    
    // Returns sorted highscores.
    public ArrayList<Integer> getHighscores()
    {
        return highscores;
    }
    
    // Modified quicksort code from Mr. Chan.
    public static int partition(ArrayList<Integer> a, int lo, int hi) 
    {
        int i = lo; 
        int j = hi + 1;
        while (true) 
        {
            while (a.get(++i) < a.get(lo)) // Find item on left to swap
            {    
                if (i == hi) 
                {
                    break; 
                }
            }
            while (a.get(--j) > a.get(lo)) 
            {
                if (j == lo)
                {
                    break;
                }
            }
            if (i >= j)
            {
                break;  // Check if pointers cross 
            }
            Collections.swap(a, i, j); // Swap
        } 
        
        Collections.swap(a, lo, j); // Swap partitioning element
        return j;  // Return index of item now know to be in place
    }
    
    public static void quicksort(ArrayList<Integer> a) 
    {
        shuffle(a); 
        quicksort(a, 0, a.size() - 1); 
    }

    // Quicksort the subarray from a[lo] to a[hi]  
    private static void quicksort(ArrayList<Integer> a, int lo, int hi) 
    {
        if (hi <= lo)
        {
            return;
        }
        int j = partition(a, lo, hi); 
        quicksort(a, lo, j-1); 
        quicksort(a, j+1, hi); 
    }

    /**
     * Shuffle an array using the Fisher-Yates method.
     * The Fisher-Yates method iterates the array once, swapping each
     * element with a random element chosen in the range between
     * the current position to the length of the array.
     * @param arr An array of integers
     */
    public static void shuffle(ArrayList<Integer> a)
    {
        Random rand = new Random();
        for(int i = 0; i<a.size(); i++)
        {
            int num = rand.nextInt(a.size());
            Collections.swap(a, i, num);
        }
    }
}
