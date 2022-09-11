import java.io.*;
import java.util.Scanner;

public class TestHarnessDSABinaryTree extends BinarySearchTree
{
    private static final String FILE_NAME = "student.csv";
    public static void main (String [] args)
    {
        Scanner sc = new Scanner( System.in );
        int menu = '0';
        BinarySearchTree tree = new BinarySearchTree();
        DSAQueue queue = new DSAQueue();
        while( menu != 8 )
        {
            System.out.print( "Select an option:\n[1] Run Test Harness\n"
                + "[2] Populate Tree\n[3] Read CSV\n"
                + "[4] Write CSV\n" + "[5] Read Serialized\n"
                + "[6] Write Serialized\n[7] Exit\n > " );
            menu = sc.nextInt();
            System.out.println( "=========================================\n" 
                );
            switch( menu )
            {
                case 1:
                {
                    // Run Test Harness
                    testHarness();
                    break;
                }
                case 2:
                {
                    //Populate tree
                    tree.insertNode("1","1");
                    tree.insertNode("2","2");
                    tree.insertNode("3","3");
                    tree.insertNode("4","4");
                    tree.insertNode("5","5");
                    tree.insertNode("6","6");
                    tree.insertNode("7","7");
                    tree.insertNode("8","8");
                    tree.insertNode("9","9");
                    
                    tree.display();
                    break;
                }
                case 3:
                {
                    //Read CSV
                    //readCSV( tree );
                    readPrint();
                    tree.display();
                    break;
                }
                case 4:
                {
                    //Write CSV
                    tree.insertNode("15","A");
                    tree.insertNode("12","B");
                    tree.insertNode("17","C");
                    tree.insertNode("35","D");
                    tree.insertNode("25","E");
                    tree.insertNode("45","F");
                    tree.insertNode("69","G");
                    writeCSV(tree);
                    break;
                }
                case 5:
                {
                    //Read Serialized
                   //readSerial( tree );
                    //BinarySearchTree tree = new BinarySearchTree();
                    readCSV(tree); 
                    System.out.println("Saving the tree into a file called output.txt");
                    saveTree(tree);
                    break;
                }
                case 6:
                {
                    //Write Serialized
                    writeSerial( tree );
                    break;
                }
                case 7:
                {
                    // Exit
                    break;
                }
                default:
                {
                    System.out.println( "Invalid menu selection" );
                }
            }
            System.out.println( "=========================================\n" 
                );
        }
    }

    public static void testHarness()
    {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println("Inserting Key: ");
        tree.insertNode("15","A");
        tree.insertNode("12","B");
        tree.insertNode("17","C");
        tree.insertNode("35","D");
        tree.insertNode("25","E");
        tree.insertNode("45","F");
        tree.insertNode("69","G");
        
        System.out.println("Tree before: ");
        tree.display(); 
        System.out.println("Deleting key 17: ");
        tree.deleteNode("17");
        System.out.println("Tree after removal: ");
        tree.display();
        System.out.println("Inserting 17 back into tree: ");
        tree.insertNode("17", "C");
        tree.display();
        System.out.println();         
       
        System.out.println("Testing inOrder Transversal: ");
        System.out.println(tree.inOrderTranversal());
        
        System.out.println("Testing Pre Order Transversal: ");
        System.out.println(tree.preOrderTranversal());
        
        System.out.println("Testing Post Order Transversal: ");
        System.out.println(tree.postOrderTranversal());
        
        System.out.println("testing Height Tree:");
        System.out.println("Tree Height: " +tree.getHeight());

        System.out.println();

        System.out.println("Testing Finding Min key and Max Key");
        System.out.println("Maximum Key: " + tree.findMax());
        System.out.println("Minimum Key: " + tree.findMin());
        
        System.out.println();
        
        System.out.println("Testing Find");
        System.out.println("Searching for key 35");
        Object value = tree.findNode("35");
        System.out.println("Found value " + value + " at key 35, expected: D");

        System.out.println("Testing Balance");
        System.out.println("Checking if the tree is balance " + "for a balanced tree, the method will return TRUE and FALSE for unbalance tree");
        System.out.println("Tree Balance  " +tree.balance());
        System.out.println();
    }    
    
    public static void readPrint()
    {
        int menu;
        Scanner sc = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        readCSV(tree);
        
        //Tranversal menu
        System.out.println("Choose a traversal: \n" +
        "1: In Order\n" +
        "2: Pre Order\n" +
        "3: Post Order");
        menu = sc.nextInt();
        switch (menu)
        {
        case 1:
            System.out.println("In Order Traversal");
            tree.inOrderTranversal();
        break;
        case 2:
            System.out.println("Pre Order Traversal");
            tree.postOrderTranversal();
        break;
        case 3:
            System.out.println("Post Order Traversal");
            tree.postOrderTranversal();
        break;
       default:
        }
    }
    
    private static BinarySearchTree readCSV(BinarySearchTree tree)
    {
        FileInputStream fstream=null;
        InputStreamReader ireader;
        BufferedReader breader;

        int count;
        String line;
        try
        {
            fstream = new FileInputStream("student.csv");
            ireader = new InputStreamReader(fstream);
            breader = new BufferedReader(ireader);
            
            count = 0;
            line = breader.readLine();
            parseString(line,tree);
            count++;
            while(line != null)
            {   
                line = breader.readLine();
                parseString(line,tree);
                count++;
            }
            fstream.close();
        }
        catch (IOException o)
        {
            if(fstream != null)
            {
                try
                {
                    fstream.close();
                }
                catch (IOException o2)
                {
                } 
            }  
        }

    return tree;
    }
    
    private static BinarySearchTree parseString(String line, BinarySearchTree tree)
    {
        try
        {
            String[] parsing = line.split(",");
            tree.insertNode(parsing[0],parsing[1]);
        }
        catch (NullPointerException ex)
        {
        }
        return tree;
    }
   
    public static void writeCSV( BinarySearchTree tree )
    {
        String fileName;
        FileOutputStream strm = null;
        PrintWriter pw;
        int order;
        Scanner sc = new Scanner( System.in );
        DSAQueue queue = new DSAQueue();
        int i = 1;

        System.out.println( "Enter file name: " );
        fileName = sc.nextLine();
 
       try
        {
            strm = new FileOutputStream( fileName );
            pw = new PrintWriter( strm );

            System.out.print( "Select traversal:\n[1] Preorder\n" +
                "[2] Inorder\n[3] Postorder\n > " );
            order = sc.nextInt();

            switch( order )
            {
                case 1:
                {
                    tree.inOrderTranversal();
                    break;
                }
                case 2:
                {
                    tree.inOrderTranversal();
                    break;
                }
                case 3:
                {
                    tree.inOrderTranversal();
                    break;
                }
                default:
                {
                    System.out.println( "Invalid selection, using inorder" );
                    tree.inOrderTranversal();
                }
            }

            for( Object o : queue )
            {
                pw.println( i + "," + o );
                i++;
            }

            pw.close();
            System.out.println( "File written successfully" );
        }
        catch( IOException e )
        {
            System.out.println( "" );
            //e.printStackTrace();
            if( strm != null )
            {
                try
                {
                    strm.close();
                }
                catch( Exception e2 )
                {
                    System.out.println( "File cannot be closed :(" );
                }
            }
        }
    }

    public static void readSerial( BinarySearchTree tree )
    {
        FileInputStream fileStrm = null;
        ObjectInputStream objStrm;
        String fileName;
        Scanner sc = new Scanner( System.in );

        System.out.print( "Enter file name: " );
        fileName = sc.nextLine();

        try
        {
            fileStrm = new FileInputStream( fileName );
            objStrm = new ObjectInputStream( fileStrm );
            tree = ( BinarySearchTree )objStrm.readObject();

            objStrm.close();
            System.out.println( "Tree read successfully" );
        }
        catch( ClassNotFoundException e )
        {
            System.out.println( 
                "Error occured, file is not the correct class" );
            if( fileStrm != null )
            {
                try
                {
                    fileStrm.close();
                }
                catch( Exception e2 )
                {        System.out.print( "Enter file name: " );
        fileName = sc.nextLine();


                    System.out.println( "File cannot be closed :(" );
                }
            }
        }
        catch( IOException e )
        {
            System.out.println( "Error occured" );
            e.printStackTrace();
            if( fileStrm != null )
            {
                try
                {
                    fileStrm.close();
                }
                catch( Exception e2 )
                {
                    System.out.println( "File cannot be closed :(" );
                }
            }
        }
    }
    
     public static void writeSerial( BinarySearchTree tree )
     {
        FileOutputStream fileStrm = null;
        ObjectOutputStream objStrm;
        String fileName;
        Scanner sc = new Scanner( System.in );

        System.out.print( "Enter file name: " );
        fileName = sc.nextLine();

        try
        {
            fileStrm = new FileOutputStream( fileName );
            objStrm = new ObjectOutputStream( fileStrm );
            objStrm.writeObject( tree );

            objStrm.close();
            System.out.println( "Tree saved successfully" );
        }
        catch( IOException e )
        {
            System.out.println( "" );
            //e.printStackTrace();
            if( fileStrm != null )
            {
                try
                {
                    fileStrm.close();
                }
                catch( Exception e2 )
                {
                    System.out.println( "File cannot be closed :(" );
                }
            }
        }
    }
        
     private static void saveTree(BinarySearchTree bst)
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            ObjectOutputStream object = new ObjectOutputStream(fileOutputStream);

            try
            {
                object.writeObject(bst);
                object.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getStackTrace());
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
    }    
    
    
}
    
