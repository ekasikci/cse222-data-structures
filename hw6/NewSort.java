package hw6;

/**
 *
 * @author Ertugrul Kasikci
 */
public class NewSort {
     /**
     * Directs the array to the newSort method
     * @param array array to be sorted
     */
    public static void Sort(int[] array)
    {
        new_sort(array, 0, array.length - 1);
    }
    
    /**
     * Puts minimum value at the beginning of the array and puts maximum value at the end of the array. Then increases first index one and decreases last index one and keeps
     * doing it recursively until the array is sorted
     * @param array array to be sorted
     * @param head starting index of the array
     * @param tail ending index of the array
     * @return 
     */
    private static int[] new_sort(int[] array, int head, int tail)
    {
        int[] min_max = new int[2];
        int temp;
        if (head > tail)
            return array;
        else
        {
            min_max = min_max_finder(array, head, tail);
            temp = array[head];
            array[head] = array[min_max[0]];
            array[min_max[0]] = temp;

            temp = array[tail];
            array[tail] = array[min_max[1]];
            array[min_max[1]] = temp;
            return new_sort(array, head + 1, tail -1);
        }
    }
    
    /**
     * finds the index of the min and max values of the array by using recursive search then returns them
     * @param array array to be searched for min and max values
     * @param head head index of the array
     * @param tail tail index of the array
     * @return index of the min and max values of the array
     */
    private static int[] min_max_finder(int[] array, int head, int tail)
    {
        int[] min_max = new int[2];
        int[] min_max2 = new int[2];
        
        min_max[0] = head;
        min_max[1] = tail;
        
        min_max2[0] = head;
        min_max2[1] = tail;

        if(head < tail)
        {
            min_max = min_max_finder(array, head, (tail+head)/2);
            min_max2 = min_max_finder(array, (tail+head)/2 + 1, tail);
        }

        if (array[min_max2[0]] < array[min_max[0]])
            min_max[0] = min_max2[0];
        if (array[min_max2[1]] > array[min_max[1]])
            min_max[1] = min_max2[1];
        return min_max;
    }
}
