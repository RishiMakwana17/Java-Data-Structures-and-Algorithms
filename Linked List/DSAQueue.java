import java.util.*;

public class DSAQueue implements Iterable
{
    // Private Classfields
    private DSALinkedList queue;

    //Default Constructor
    public DSAQueue()
    {
        queue = new DSALinkedList();
    }

    //Accessors 
    public int getCount() //Iterates through the queue and returns the number of element in it
    {
        int count = 0;

        for(Object o: this)
        {
            count++;
        }

        return count;
    }

    public boolean isEmpty() //Returns true is the queue is empty
    {
        return queue.isEmpty();
    }

    //Mutators
    public void enqueue(Object inObject) //Adds an element to the back of queue
    {
        queue.insertLast(inObject);
    }

    public Object dequeue() //Returns the front element of the queue and removes it from queue
    {
        return queue.removeFirst();
    }

    public Object peek() //Returns the front value of queue
    {
        return queue.peekFirst();
    }

    //Iteration
    public Iterator iterator() //Returns iterator object for queue
    {
        return queue.iterator();
    }
}
