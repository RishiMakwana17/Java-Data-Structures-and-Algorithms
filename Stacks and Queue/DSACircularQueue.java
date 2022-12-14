import java.util.*;

public class DSACircularQueue extends DSAQueue
{
    // Private Classfields

    private int frontIdx;
    private int count;

    // Constructors    
    public DSACircularQueue()
    {
        super(); //Calls the base class
        frontIdx = 0;
        count = 0;
    }

    public DSACircularQueue(int capacity)
    {
        super(capacity);
        frontIdx = 0;
        count = 0;
    }

    // Accessors
    public Object peek()
    {
        Object frontVal;
        if(isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty");
        }
        else
        {
            frontVal = super.queue[frontIdx];
        }

        return frontVal;
    }

    public boolean isEmpty() // Checks to see if the queue is empty
    {
        boolean empty = false;

        if( count == 0 )
        {
            empty = true;
        }

        return empty;
    }

    public boolean isFull() // Checks to see if queue is full
    {
        boolean full = false;

        if( count == super.queue.length )
        {
            full = true;
        }

        return full;
    }

    public int getCount() // Determines the number of elements in the queue
    {
        return count;
    }

    // Mutators

    public void enqueue( Object inObject ) //Adds elements to the queue
    {
        if( isFull() )
        {
            throw new IllegalArgumentException( "Queue is full" );
        }
        else
        {
            super.queue[ endIdx ] = inObject;
            count++;

            if( endIdx == super.queue.length - 1 )
            {
                endIdx = 0; // If queue needs to loop around for next enqueue
            }
            else
            {
                endIdx++; // If end index can increment normally
            }
        }
    }

    public Object dequeue() //Removes elements from the queue
    {
        Object frontVal;

        frontVal = peek();
        count--;

        if( frontIdx == super.queue.length - 1 )
        {
            frontIdx = 0; // If the queue needs to loop around backwards for next dequeue
        }
        else
        {
            frontIdx++; //If front index can decrement normally
        }

        return frontVal;
    }
    
    public String toString()
    {
        return "CircularQueue [" + Arrays.toString(queue) + "]"; //Print
    }

}
