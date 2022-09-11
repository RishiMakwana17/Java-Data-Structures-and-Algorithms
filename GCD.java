import java.util.*;
public class GCD
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter first number: ");
            int firstNum = sc.nextInt();
        
            System.out.println("Enter second number: ");
            int secondNum = sc.nextInt();
        
            System.out.println("Greatest common demoninator:"+ gcd(firstNum, secondNum));
        }catch (InputMismatchException ex)
        {
            System.out.println("Please enter a valid input!");
        }
    }

    public static int gcd(int num1, int num2) 
    {
        if (num2 != 0)
        {
            return gcd(num2, num1 % num2);
        } 
        else
        {
            return num1;
        }
   }
}
