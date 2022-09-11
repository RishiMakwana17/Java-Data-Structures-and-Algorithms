import java.util.*;
public class base
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: "); //User enters input 
            int decimal_number = sc.nextInt();
            System.out.println("The binary number of " + decimal_number + " is " + base(decimal_number)); //Prints out decimal to binary 
        }catch (InputMismatchException ex)
        {
            System.out.println("Please enter a valid input"); //try/catch incase user enters anything other than a number
        }
    }
    
    public static int base(int decimal_number) //recursive method
    {
       
        if (decimal_number == 0)  
            return 0;              
        else
        return (decimal_number % 2 + 10 *  base(decimal_number / 2)); //returns calculation from decimal to binary to main method
    }
    
}
