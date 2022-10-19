package hw6;

/**
 *
 * @author Ertugrl Kasikci
 */
public class QuickSort {
    
    /**
     * Directs the array to the quickSort method
     * @param array array to be sorted
     */
    public static void Sort(int[] array)
    {
        QuickSortRecursive(array, 0, array.length - 1);    
    }
    
    /**
     * Recursively sorts the array parameter applying quick sort method
     * @param array array to be sorted
     * @param start starting index of the array
     * @param end ending index of the array
     */
    private static void QuickSortRecursive(int[] array, int start, int end)
    {
        if (start < end)
        {
         
            int pivot = QuickSorting(array, start, end);
            
            QuickSortRecursive(array, start, pivot - 1);
            QuickSortRecursive(array, pivot + 1, end);
        }
    }
    
    /**
     * Puts smaller values to the left side of the pivot and bigger values to the right side of the pivot to apply quick sort method
     * @param array array to be sorted
     * @param start starting index of the array
     * @param end ending index of the array
     * @return one index after of the pivot
     */
    private static int QuickSorting(int[] array, int start, int end)
    {
        int pivot = array[end];      
        int smallCounter = start - 1;
        int temp;

        for (int i = start; i < end; i++)
        {
            if (array[i] < pivot)
            {
                smallCounter++;
                temp = array[smallCounter];
                array[smallCounter] = array[i];
                array[i] = temp;
            }
        }
        
        temp = array[smallCounter + 1];
        array[smallCounter + 1] = array[end];
        array[end] = temp;
      
        return (smallCounter + 1);
    }
    
}
