package hw6;

import java.util.Random;

/**
 *
 * @author Ertugrul Kasikci
 */
public class HW6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [][]smallArrays1 = new int[1000][100];
        int [][]mediumArrays1 = new int[1000][1000];
        int [][]largeArrays1 = new int[1000][10000];
        int [][]smallArrays2 = new int[1000][100];
        int [][]mediumArrays2 = new int[1000][1000];
        int [][]largeArrays2 = new int[1000][10000];
        int [][]smallArrays3 = new int[1000][100];
        int [][]mediumArrays3 = new int[1000][1000];
        int [][]largeArrays3 = new int[1000][10000];  
     
        long start, end;
        
        Random rand = new Random();
        
        for(int i = 0; i < smallArrays1.length; i++)
        {
            for(int j = 0; j < smallArrays1[i].length; j++)
            {
                smallArrays1[i][j] = rand.nextInt(10000);
                smallArrays2[i][j] = smallArrays1[i][j];
                smallArrays3[i][j] = smallArrays1[i][j];
            }
        }
        
        for(int i = 0; i < mediumArrays1.length; i++)
        {
            for(int j = 0; j < mediumArrays1[i].length; j++)
            {
                mediumArrays1[i][j] = rand.nextInt(10000);
                mediumArrays1[i][j] = mediumArrays1[i][j];
                mediumArrays1[i][j] = mediumArrays1[i][j];
            }
        }
        
        for(int i = 0; i < largeArrays1.length; i++)
        {
            for(int j = 0; j < largeArrays1[i].length; j++)
            {
                largeArrays1[i][j] = rand.nextInt(10000);
                largeArrays1[i][j] = largeArrays1[i][j];
                largeArrays1[i][j] = largeArrays1[i][j];
            }
        }
        System.out.print("Merge Sort:\n\n");

        start = System.nanoTime();    
        testMergeSort(smallArrays1);             
        end = System.nanoTime();
        System.out.println("For small(" + smallArrays1[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/smallArrays1.length); 

        start = System.nanoTime();        
        testMergeSort(mediumArrays1);              
        end = System.nanoTime();
        System.out.println("For medium(" + mediumArrays1[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/mediumArrays1.length); 
        
        start = System.nanoTime(); 
        testMergeSort(largeArrays1);           
        end = System.nanoTime();
        System.out.println("For large(" + largeArrays1[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/largeArrays1.length);
        
        System.out.print("\n\nQuick Sort:\n\n");
        
        start = System.nanoTime();    
        testQuickSort(smallArrays2);             
        end = System.nanoTime();
        System.out.println("For small(" + smallArrays3[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/smallArrays2.length); 

        start = System.nanoTime();        
        testQuickSort(mediumArrays2);              
        end = System.nanoTime();
        System.out.println("For medium(" + mediumArrays3[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/mediumArrays2.length); 
        
        start = System.nanoTime(); 
        testQuickSort(largeArrays2);           
        end = System.nanoTime();
        System.out.println("For large(" + largeArrays3[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/largeArrays2.length);
       
        
        System.out.print("\n\nnew_sort:\n\n");
        
        start = System.nanoTime();    
        testnewSort(smallArrays3);             
        end = System.nanoTime();
        System.out.println("For small(" + smallArrays3[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/smallArrays3.length); 

        start = System.nanoTime();    
        testnewSort(mediumArrays3);             
        end = System.nanoTime();
        System.out.println("For medium(" + mediumArrays3[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/mediumArrays3.length);
        
        start = System.nanoTime();    
        testnewSort(largeArrays3);             
        end = System.nanoTime();
        System.out.println("For large(" + largeArrays3[0].length + ") size array elapsed Time in micro seconds: "+ (end - start)/1000/largeArrays3.length);    
    }
    
    /**
     * Tests merge sorting algorithm
     * @param arrays array of arrays for testing
     */
    public static void testMergeSort(int arrays[][])
    {  
        for(int i = 0; i < arrays.length; i++)
        {
            arrays[i] = MergeSort.Sort(arrays[i]);
        }
    }
    
    /**
     * Test quick sorting algorithm
     * @param arrays array of arrays for testing
     */
    public static void testQuickSort(int arrays[][])
    {  
        for(int i = 0; i < arrays.length; i++)
        {
            QuickSort.Sort(arrays[i]);
        }
    }
    
    /**
     * Tests new_sort algorithm
     * @param arrays array of arrays for testing
     */
    public static void testnewSort(int arrays[][])
    {  
        for(int i = 0; i < arrays.length; i++)
        {
            NewSort.Sort(arrays[i]);
        }
    }
}
