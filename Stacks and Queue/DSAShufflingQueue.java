import java.util.Arrays;
public class DSAShufflingQueue extends DSAQueue
{
    // Constructors

    public DSAShufflingQueue()
    {
        super(); //Calls the super class to implement constructors
    }

    public DSAShufflingQueue( int capacity )
    {
        super( capacity );
    }

    // Accessors

    public boolean isEmpty() // Checks to see if empty or not
    {
        boolean empty = false;

        if( super.endIdx == 0 )
        {
            empty = true;
        }

        return empty;
    }

    public boolean isFull() // Checks to see if full or not
    {
        boolean full = false;

        if( super.endIdx == super.queue.length )
        {
            full = true;
        }
        
        return full;
    }

    public int getCount() // Counts the elements 
    {
        return super.endIdx;
    }

    public Object peek() // Top of the queue
    {
        Object frontVal;       

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "Queue is empty" );
        }
        else
        {
            frontVal = queue[0];
        }

        return frontVal;
    }

    // Mutators

    public void enqueue( Object inObject ) // Adds element to the queue
    {
        if( isFull() )
        {
            throw new IllegalArgumentException( "Queue is full" );
        }
        else
        {
            super.queue[ endIdx ] = inObject;
            super.endIdx++;
        }
    }

    public Object dequeue() // Removes element from queue
    {
        Object frontVal = peek();
        super.endIdx--;

        for( int i = 0; i < super.endIdx; i++ )
        {
            super.queue[ i ] = super.queue[ i + 1 ];
        }

        return frontVal;
    }
    
    public String toString()
    {
        return "ShuffleQueue [" + Arrays.toString(queue) + "]"; //Prints out queue
    }

}
