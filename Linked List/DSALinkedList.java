import java.util.*;
import java.io.*;

public class DSALinkedList implements Iterable, Serializable
{
    private class DSAListNode implements Serializable //DSAListNode
    {
        //Private classfields 
        private Object value; //The value of the list node
        private DSAListNode prev, next; //References to the previous and next nodes in the list

        //Alternate constructor
        public DSAListNode(Object inValue) //Sets previous and next to null and sets value to give value
        {
            value = inValue;
            prev = null;
            next = null;
        }
        
        //Accessors
        public Object getValue() // Returns value of the ListNode
        {
            return value;
        }

        public DSAListNode getPrev() // Returns a reference to the previous node in the list
        {
            return prev;
        }

        public DSAListNode getNext() // Returns a refernece to the next node in the list
        {
            return next;
        }

        //Mutators 
        public void setValue(Object inValue) // Sets the value of the list node to the given value
        {
            value = inValue;
        }

        public void setPrev(DSAListNode inListNode) //Sets previous node to the given node
        {
            prev = inListNode;
        }

        public void setNext(DSAListNode inListNode) // Sets next node to given node
        {
            next = inListNode;
        }
    }//End of DSAlistNode
    


    private class DSALinkedListIterator implements Iterator, Serializable
    {

        //Private Classfield
        private DSAListNode iterNext;//Iteration cursor

        //Alternate Constructor
        public DSALinkedListIterator(DSALinkedList linkedList) // Sets cursor to head of linked list
        {
            iterNext = linkedList.head;
        }

        //Iterator Interface Implementation 
        public boolean hasNext() // Returns true if cursor is not null and returns false otherwise
        {
            return iterNext != null;
        }

        public Object next() // Returns true if cursor is not null and return false otherwise
        {
            Object value;

            if( iterNext == null )
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();//Get the value in the node
                iterNext = iterNext.getNext();//Ready for subsequent calls to next()
            }

            return value;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }
    } //End of LinkedListIterator



    //DSALinkedList
    //Private Classfields
    private DSAListNode head, tail; // References to the head and tail list nodes

    //Default Constructor
    public DSALinkedList()
    {
        head = null;
        tail = null;
    }

    //Accessors 
    public boolean isEmpty() // Returns true if the head points to null, otherwise returns false
    {
        boolean empty = false;
        empty = head == null;

        return empty;
    }

    public Object peekFirst() //Return the value of the head node
    {
        Object nodeValue;

        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty");
        }
        else
        {
            nodeValue = head.getValue();
        }

        return nodeValue;
    }

    public Object peekLast() //Returns the value of the tail node
    {
        Object nodeValue;

        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty");
        }
        else
        {
            nodeValue = tail.getValue();
        }

        return nodeValue;
    }

    //Mutators 
    public void insertFirst(Object inValue) //insertFirst
    {
        DSAListNode newNd = new DSAListNode(inValue);

        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            // Set the current head to the next of the new node, and sets the head to the new node
            newNd.setNext(head);
            head.setPrev(newNd);
            head = newNd;
        }
    }

    public void insertLast(Object inValue) //inserts a new node at the tail of the list with the given value
    {
        DSAListNode newNd = new DSAListNode(inValue);

        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            tail.setNext(newNd);
            newNd.setPrev(tail);
            tail = newNd;
        }
    }

    public Object removeFirst() //Returns the value of the first node in the list and removes the node
    {
        Object nodeValue;

        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty");
        }
        else if(head.getNext() == null)
        {
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext();
        }

        return nodeValue;
    }

    public Object removeLast() // Returns the value of the last node in the list and removes the node
    {
        Object nodeValue;

        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty");
        }
        else if(tail.getPrev() == null)
        {
            nodeValue = tail.getValue(); 
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = tail.getValue();  
            tail.getPrev().setNext(null); 
            tail = tail.getPrev();
        }

        return nodeValue;
    }

    //Iteration
    public Iterator iterator()
    {
        return new DSALinkedListIterator(this);
    }
}

