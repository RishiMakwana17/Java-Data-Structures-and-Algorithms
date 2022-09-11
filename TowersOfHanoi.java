import java.util.*;
public class TowersOfHanoi
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            int disk;
            int start = 1;
            int dest = 3;

            System.out.println("Enter the number of disks");
            disk = sc.nextInt(); //User enters the number of disks to start with
        
            tower(disk, start, dest); //Calls tower method
        }catch(InputMismatchException ex)
        {
            System.out.println("Please enter a valid input."); //try catch incase user enters invalid input (throws error)
        }
    }
    
    public static void tower(int n, int src, int dest)
    {
        if (n==1)
        {
            moveDisk(src,dest); //base case - moves one disk from peg src to peg dest
        }
        else
        {
            int temp;
            temp = 6 - src - dest; //other non target peg
            tower(n-1, src, temp); //Move all disks apart from to temp peg tmp
            moveDisk(src,dest); //Move bottom disk to target peg dest
            tower(n-1,temp,dest); //Move the rest from temp peg tmp to target peg dest
        }   
    }
    
    public static void moveDisk(int src, int dest)
    {
        System.out.println("Move the top of the disk from peg " +src+ " to peg " + dest); //Prints the moving of the disk in a separate public method from peg to destination 
    }
}
