import java.util.*;

public class DSAStack implements Iterable
{
    //Private Classfield
    private DSALinkedList stack; //The stack itself is a linked list

    //Default Constructor
    public DSAStack()
    {
        stack = new DSALinkedList();
    }

    //Accessors
    public Object top() // Returns the top value of the stack
    {
        if( isEmpty() )
        {
            throw new IllegalArgumentException("Stack is empty");
        }

        return stack.peekFirst();
    }

    public int getCount() // Iterates through the stack and returns the number of elements it contains
    {
        int count = 0;

        for( Object o: this)
        {
            count++;
        }

        return count;
    }

    public boolean isEmpty() // Returns true if the stack is empty and false otherwise
    {
        return stack.isEmpty();
    }

    // Mutators 
    public void push(Object inObject) // Pushes an element onto the top of the stack
    {
        stack.insertFirst(inObject);
    }

    public Object pop() // Returns thr top value of the stack and removes it from the stack
    {
        return stack.removeFirst();
    }

    //Iteration 
    public Iterator iterator()
    {
        return stack.iterator();
    }
}
