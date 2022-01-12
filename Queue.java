/**
 * Write a description of class Queue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    public class Queue <TextChoice>{
    private Node first, last;
    private class Node{ TextChoice item; Node next; }
    public boolean isEmpty() { return (first == null); }
    public void enqueue(TextChoice item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())  first = last;
        else            oldLast.next = last;
    }
    public TextChoice dequeue() {
        TextChoice item = first.item;
        first = first.next;
        if (isEmpty())  first = last;
        return item;
    }
}


