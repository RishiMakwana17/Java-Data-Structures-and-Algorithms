import java.util.*;
public class Fibonacci
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: "); //User input for number
            int n = sc.nextInt();
        
            System.out.println(fibRecursive(n)); //Prints the Fibonacci number of the number that the user entered
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Please enter a number"); //try/catch incase user enters a value other than a number
        }
    }
    
    public static int fibRecursive(int n)
    {
        int fibVal = 0; //Declaration
        if (n == 0)
        {
            fibVal = 0; //base case 1
        }
        else if (n == 1)
        {    
            fibVal = 1; //base case 2
        }
        else 
        {
            fibVal = fibRecursive(n-1) + fibRecursive(n-2); //Recursion calls
        }
        return fibVal;
    }
}
