import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;
    
public class FileIO
{ 
   /*
    SUBMODULE: readFile
    IMPORT: readArray
    EXPORT: none
    ASSERTION:
        PER:Get the number and length of the lines 
        POST: Ret
    */
    public static int[][] readFile(String fileName) throws FileNotFoundException 
    {
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufferReader;
        
        int Length = 0; //Length of line
        int Number = 0;  //the number of lines
        String line, theLine; 
        int[][]readArray = new int[Number][Length]; //creates 2D array
        
        try
        {
            fileStream = new FileInputStream(fileName);
            rdr = new InputStreamReader(fileStream);
            bufferReader = new BufferedReader(rdr); //Reads text from character input stream, provides efficient reading of the characters and lines.
            
            bufferReader.mark(10000); //holds bufferReader to 10000 char
            //Obtains the number and length of lines        
            line = "";
            while (line != null)
            {
                line = bufferReader.readLine(); //read lines 
                if (line != null)
                {
                    Number++;
                    Length = line.split(",").length; //Returns string with each part of split in each element of array 
                }
            
            }
            
        readArray = new int[Number][Length]; //2D array of new data with number & length of lines
        bufferReader.reset(); //resets the buffer to start of the file                            
        
        for(int i = 0;i < readArray.length;i++) //Implements the array with data from the file
        {
            theLine = bufferReader.readLine(); //reads lines
            if (theLine != null)
            {
                String[] lineArray = theLine.split(","); //Returns string with each part of split in each elemt of array 
                for (int j = 0;j < readArray[i].length;j++) 
                {
                    readArray[i][j] = Integer.parseInt(lineArray[j]); //Output/returns integer in the test
                }
            }
        }
        
        fileStream.close(); // closes the file stream
        } 
        catch (FileNotFoundException e)
        {
            throw e;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.print("Error: IO Exception");
        }
        return readArray;   
    }
}       
