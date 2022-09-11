import java.util.Arrays;
public class TestQS
{
    public static void main(String[] args)
    {
        DSACircularQueue circular = new DSACircularQueue(); //Calls circular class
        DSAShufflingQueue shuffling = new DSAShufflingQueue(); //Calls Shuffle Class

        testQueue(circular); //Calls testQueue method
        testShuffle(shuffling); //Calls testShuffle method
    }
    
    public static void testQueue(DSACircularQueue circular) 
    {
        DSACircularQueue circularQueue = new DSACircularQueue(8); //8 elements in the queue
        
        circularQueue.enqueue(15);
        circularQueue.enqueue(16); //Adding elements to the queue
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);
        
        System.out.println("Full Circular Queue " + circularQueue); //Queue before removals
        System.out.println("Dequeued following element from circular queue: ");
        System.out.println(circularQueue.dequeue() + " "); //Removes element
        circularQueue.enqueue(23); //Adds element 
        System.out.println("Enqueueing circular queue with 23: ");
        System.out.println(circularQueue); //Prints 
   }
    
    public static void testShuffle(DSAShufflingQueue shuffling)
    {
        DSAShufflingQueue queue = new DSAShufflingQueue(8);
        System.out.println("--------------------------------------");       
        System.out.println("Adding elements: ");
        queue.enqueue(15);
        queue.enqueue(16); //Adds elements to the queue
        queue.enqueue(17);
        queue.enqueue(18);
        queue.enqueue(19);
        queue.enqueue(20);
        queue.enqueue(21);
        queue.enqueue(22);  
    
        System.out.println("Full Shuffle Queue " + queue); //Queue before removals
        System.out.println("Dequeued following element from shuffle queue: ");
        System.out.println(queue.dequeue() + ""); //Removes element
        queue.enqueue(23); //Adds elements
        System.out.println("Enqueueing shuffle queue with 23: ");
        System.out.println(queue); //Prints   
    }          
}

