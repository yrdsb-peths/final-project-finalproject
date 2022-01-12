/**
 * Queue data structure.
 * 
 * @author David Gao 
 * @version Jan. 12/22
 */

public class Queue <TextChoice>
{
    private Node first, last;
    private class Node
    {
        TextChoice item; 
        Node next; 
    }
    public boolean isEmpty() 
    { 
        return (first == null); 
    }
    public void enqueue(TextChoice item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
        {
            first = last;
        }
        else
        {
            oldLast.next = last;
        }
    }
    public TextChoice dequeue() {
        TextChoice item = first.item;
        first = first.next;
        if (isEmpty())
        {
            first = last;
        }
        return item;
    }
}


