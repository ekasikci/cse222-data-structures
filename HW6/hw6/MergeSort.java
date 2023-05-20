package hw6;

/**
 *
 * @author Ertugrul Kasikci
 */
public class MergeSort {
    /**
     * Division part of the merge sort. Takes an array as a parameter and divides it into almost equal two part for sorting
     * @param array array to be sorted
     * @return sorted array
     */
    public static int[] Sort(int[] array)
    {
        if(array.length == 1)
            return array;
        else
        {
            int[] left = new int[array.length/2];
            int[] right = new int[array.length - left.length];
            
            for(int i = 0; i < left.length; i++)
                left[i] = array[i];     
            
            for(int i = left.length; i < array.length; i++)
                right[i - left.length] = array[i];
        
            left = Sort(left);
            right = Sort(right);
                  
            return Merge(left, right);
        }
    }
    
    /**
     * Takes two array as parameters and sorts them by merging
     * @param left left half array
     * @param right right half array
     * @return merged and sorted array consisting of left and right parameters
     */
    private static int[] Merge(int[] left, int[] right)
    {
        int counter = 0, rightCounter = 0, leftCounter = 0;
        
        int[] mergedArray = new int[left.length + right.length];
        
        while(leftCounter < left.length && rightCounter < right.length)
        {
            if(left[leftCounter] < right[rightCounter])
            {
                mergedArray[counter] = left[leftCounter];
                leftCounter++;
            }
            else
            {
                mergedArray[counter] = right[rightCounter];
                rightCounter++;
            }
            counter ++;
        }
        
        if(leftCounter < left.length)
            for(int i = leftCounter; i < left.length; i++)
            {
                mergedArray[counter] = left[i];
                counter++;
            }
        else
            for(int i = rightCounter; i < right.length; i++)
            {
                mergedArray[counter] = right[i];
                counter++;
            }
        
        return mergedArray;
    }
}
