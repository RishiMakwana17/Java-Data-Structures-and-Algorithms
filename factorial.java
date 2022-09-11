import java.util.*;
public class factorial
{
    public static void main(String[] args)
    {
        try 
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: "); //User enters an number
            int n = sc.nextInt();
        
            System.out.println("Factorial: " + calcFactorial(n)); //Prints out factorial 
        }catch(InputMismatchException ex)
        {
            System.out.println("Please a valid input"); //try catch incase user enters anything invalid / other than a number
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("User Input should not be negative"); //try catch inase user enters a negative number
        }
    }
    
    private static long calcFactorial(int n)
    {
        long factorial = 1;
        if (n < 0)
        {
            throw new IllegalArgumentException("User input should not be negative");
        }
        if(n == 0)
        {
            factorial = 1;
        }
        else 
        {
            factorial = n * calcFactorial(n-1); //Factorial calculation 
        }
        return factorial;
    }
    
    public static void Factorial(int n)
    {
        calcFactorial(n); //Wrapper method
    }
}
