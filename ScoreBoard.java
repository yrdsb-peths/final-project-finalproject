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
    private String name;
    private Integer highscore;
    private static ArrayList<Integer> highscores = new ArrayList<Integer>();
    private static HashMap<Integer, String> unsortedScores = new HashMap<Integer, String>();
    private static LinkedHashMap<Integer, String> sortedScores = new LinkedHashMap<Integer, String>();
    
    /**
     * Constructor for objects of class ScoreBoard
     */
    public ScoreBoard(Integer highscore, String name)
    {
        this.highscore = highscore;
        this.name = name;
        highscores.add(highscore);
        unsortedScores.put(highscore, name);
    }
    
    // Returns sorted highscores with associated names.
    public LinkedHashMap<Integer, String> getSortedScores()
    {
        sortAndCopy();
        return sortedScores;
    }
    
    /**
     * Sorts highscores and copies highscore and associated name onto
     * linked hashmap.
     */
    public void sortAndCopy()
    {
        // Sorting highscores.
        quicksort(highscores); 
        
        for(int i = highscores.size()-1; i > -1; i--) 
        {
            // Highest score on arraylist.
            Integer highest = highscores.get(i); 
            // Associated name to highest score on hashmap.
            String name = unsortedScores.get(highest);
            // Putting highscore and name onto linked hashmap.
            sortedScores.put(highest, name); 
        }
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
