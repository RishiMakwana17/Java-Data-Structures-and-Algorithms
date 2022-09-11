import java.util.*;

public class DSAStack
{
    //Private Classfields
    private Object[] stack;
    private int count;

    //Class Constants
    private static final int DEFAULT_CAPACITY = 100;

    //Default Constructor
    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    //Alternate Constructor
    public DSAStack(int capacity)
    {
        if( capacity <= 0 )
        {
            throw new IllegalArgumentException("Capacity must be greater than zero" );
        }
        else
        {
            stack = new Object[capacity];
            count = 0;
        }
    }

    // Accessors
    public Object top() // Places back on top
    {
        Object topVal;

        if(isEmpty())
        {
            throw new IllegalArgumentException("Stack is empty");
        }
        else
        {
            topVal = stack[count - 1];
        }

        return topVal;
    }

    public int getCount()
    {
        return count;
    }

    public boolean isEmpty() // Checks to see if the stack is empty
    {
        boolean empty = false;

        if(count == 0) 
        {
            empty = true;
        }

        return empty;
    }

    public boolean isFull() // Checks to see if the stack is full
    {
        boolean full = false;

        if(count == stack.length)
        {
            full = true;
        }

        return full;
    }

    // Mutators
    public void push(Object inObject) // Adds item to the top of the stack
    {
        if(isFull())
        {
            throw new IllegalArgumentException("Stack is full");
        }
        else
        {
            stack[count] = inObject;
            count++;
        }
    }

    public Object pop() // Removes the item from the top
    {
        Object topVal;

        topVal = top();
        count--;

        return topVal;
    }
        
    public String toString()
    {
        return Arrays.toString(stack); //Prints out
    }

}
