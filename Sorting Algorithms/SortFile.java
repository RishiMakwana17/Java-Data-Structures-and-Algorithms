import java.util.*;
import java.io.*;
public class SortFile
{
    public static void main(String[] args)
    {
    //Main methods   
        sortFile();
    }
    
    public static void readFile(String array)
    {
        try
        { 
            System.out.println("Enter the name of the csv file.");
            String csvFile = sc.next();
            String array = FileIO.readFile(csvFile);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("This file does not exist.");
        }
        return array;
    }
    
    public static void sortFile()
    {
    //Method to sort file (ask for sorting algorithm to use)
        Scanner sc = new Scanner(System.in);
        System.out.println("What sorting algorithm would you like to use?");
        System.out.println("1.Bubble Sort\nInsertion Sort\n3.Selection Sort");
        int input = sc.nextInt();
        switch(input)
        {
            case 1: //Bubble Sort
                Sorts.bubbleSort();
            break;
            case 2: //Selection Sort
                Sorts.selectionSort();
            break;
            case 3://Insertion sort
                Sorts.insertionSort();    
            break;
    }

    public static void writeFile()
    {
    //Method to write the sorted array to a new file
    }

}

