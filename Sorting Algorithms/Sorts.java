/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] array)
    {
        boolean sorted;
        do
        {
            sorted = true;  
            for (int i = 0; i < array.length-1; i++) //Loops through the test code
            {
                if (array[i] > array[i+1])
                {  
                    int temp = array[i];//Swaps the out of order elements ii and ii+1
                    array[i] = array[i+1];
                    array[i+1] = temp; 
                    sorted = false;
                }   
            }
        }while(!sorted);      
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] array)
    {
        // One by one move boundary of unsorted subarray 
        for (int nn = 0; nn < array.length-1; nn++)
        {
            // Find the minimum element in unsorted array 
            int min_Idx = nn;
            for (int j = nn+1; j < array.length-1; j++)
            {
                if (array[j] < array[min_Idx])
                {
                    min_Idx = j;
                }
            }
            // Swap the found minimum element with the first 
            // element 
            int temp = array[min_Idx];
            array[min_Idx] = array[nn]; //Swaps
            array[nn] = temp;
        }

    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] array)
    {
        for (int nn = 1; nn <= array.length-1; ++nn) //Starts inserting element at 1
        {
            int ii = nn; //Start at the last item and go backwards 
            while ((ii > 0) && (array[ii-1] > array[ii]))
            {
                int temp = array[ii]; //Sorts
                array[ii] = array[ii-1];
                array[ii-1] = temp;
                
                ii = ii - 1;
            }
        }

    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning
}

