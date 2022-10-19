package hw4;

import java.util.ArrayList;

/**
 * @author Ertugrul Kasikci
 */

 public class HW4
 {
    public static void main(String[] args)
    {
        System.out.println("Question 1:");
        System.out.println("\nBig String: abababc     Query String: ababc     Index of the first occurence: " + 
        question1("ababc", "abababc", 1, 0, 0, 0));
        System.out.println("\nBig String: cse222randomfacse222sfoaisfcse222jsaocse222facse222     Query String: cse222     Index of the fifth occurence: " + 
        question1("cse222", "cse222randomfacse222sfoaisfcse222jsaocse222facse222", 5, 0, 0, 0));
        System.out.println("\nBig String: randomstring     Query String: cannotbefound     Index of the first occurence: " + 
        question1("cannotbefound", "randomstring", 1, 0, 0, 0));

        int sortedArray[] = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Question 2:");
        System.out.println("\nSorted Array: {1,2,3,4,5,6,7,8,9,10}     Top Int: 4   Bottom Int: 8     Number of integers between bottom int and top int: " + 
        question2(sortedArray, 4, 8, 0, sortedArray.length - 1));
        System.out.println("\nSorted Array: {1,2,3,4,5,6,7,8,9,10}     Top Int: 10   Bottom Int: 12    Number of integers between bottom int and top int: " + 
        question2(sortedArray, 10, 12, 0, sortedArray.length - 1));
        System.out.println("\nSorted Array: {1,2,3,4,5,6,7,8,9,10}     Top Int: 0   Bottom Int: 11     Number of integers between bottom int and top int: " + 
        question2(sortedArray, 0, 11, 0, sortedArray.length - 1));
        
        int unsortedArray[] = {5, 4, 6, 1, 9, 11, 6, 3, 2, 9, 3, 4, 2, 8};
        ArrayList<ArrayList<Integer>> subArrays1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> subArrays2 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> subArrays3 = new ArrayList<ArrayList<Integer>>();

        System.out.println("Question 3:");
        System.out.println("\nunsortedArray:{5, 4, 6, 1, 9, 11, 6, 3, 2, 9, 3, 4, 2, 8};     Target value: 9     Number of subarrays which sum of the numbers are equal target value: " + 
        question3(unsortedArray, subArrays1, 9, unsortedArray[0], 0, 0));
        // subArrays keeps index values of the arrays in unsortedArray. Sum of the values between these indexes equals target value. 
        // This for loop prints the numbers in unsortedArray according to these indexes to show the askes subarrays
        for(int i = 0; i < subArrays1.size(); i++)
        {
            System.out.print("{");
            for(int j = subArrays1.get(i).get(0); j <= subArrays1.get(i).get(1); j++)
            {
                if(j == subArrays1.get(i).get(1))
                    System.out.print(unsortedArray[j]);
                else
                    System.out.print(unsortedArray[j] + ", ");
            }
            System.out.println("}");
        }

        System.out.println("Question 3:");
        System.out.println("\nunsortedArray:{5, 4, 6, 1, 9, 11, 6, 3, 2, 9, 3, 4, 2, 8};     Target value: 10     Number of subarrays which sum of the numbers are equal target value: " + 
        question3(unsortedArray, subArrays2, 10, unsortedArray[0], 0, 0));
        // subArrays keeps index values of the arrays in unsortedArray. Sum of the values between these indexes equals target value. 
        // This for loop prints the numbers in unsortedArray according to these indexes to show the askes subarrays
        for(int i = 0; i < subArrays2.size(); i++)
        {
            System.out.print("{");
            for(int j = subArrays2.get(i).get(0); j <= subArrays2.get(i).get(1); j++)
            {
                if(j == subArrays2.get(i).get(1))
                    System.out.print(unsortedArray[j]);
                else
                    System.out.print(unsortedArray[j] + ", ");
            }
            System.out.println("}");
        }

        System.out.println("Question 3:");
        System.out.println("\nunsortedArray:{5, 4, 6, 1, 9, 11, 6, 3, 2, 9, 3, 4, 2, 8};     Target value: 7     Number of subarrays which sum of the numbers are equal target value: " + 
        question3(unsortedArray, subArrays3, 7, unsortedArray[0], 0, 0));
        // subArrays keeps index values of the arrays in unsortedArray. Sum of the values between these indexes equals target value. 
        // This for loop prints the numbers in unsortedArray according to these indexes to show the askes subarrays
        for(int i = 0; i < subArrays3.size(); i++)
        {
            System.out.print("{");
            for(int j = subArrays3.get(i).get(0); j <= subArrays3.get(i).get(1); j++)
            {
                if(j == subArrays3.get(i).get(1))
                    System.out.print(unsortedArray[j]);
                else
                    System.out.print(unsortedArray[j] + ", ");
            }
            System.out.println("}");
        }

        
        System.out.println();
        boolean emptyArray[] = new boolean[7];

        question5(emptyArray, 3, 0, 3, 0);  
    }

    /**
     * reccurence function to find the index value of the i'th occurence of the query string in the given big string
     * @param queryString the string that is been search in the big string
     * @param bigString the string that is been search for to query string in it
     * @param i value that determines how many times the query string needs to be found in big string
     * @param indexQuery keeps index of the query string
     * @param indexBig keeps index of the big string
     * @param occurence keeps the number of occurence of the query string in the big string
     * @return  if the occurence is reach to i returns the index value of the i'th occurence else returns -1
     */
    public static int question1(String queryString, String bigString, int i, int indexQuery, int indexBig, int occurence)
    {      
        if(queryString.length() - indexQuery > bigString.length() - indexBig || bigString.length() < indexBig)
            return -1;

        
        if(indexQuery == queryString.length())
        {
            occurence++;
            if(i == occurence)
                return indexBig - indexQuery;
            indexQuery = 0;
        }

        if(queryString.charAt(indexQuery) != bigString.charAt(indexBig))
                return question1(queryString, bigString, i, 0, indexBig - indexQuery + 1, occurence);
        else
            return question1(queryString, bigString, i, ++indexQuery, ++indexBig, occurence);
    }

    /**
     * @param topInt determines the top value of the interval (excluding)
     * @param bottomInt determines the bottom value of the interval (excluding)
     * @param sortedArray given sorted array which is going to be search
     * @param indexBottom determines the bottom index value of the sorted array to be search
     * @param indexTop determines the top index value of the sorted array to be search
     * @return number of values between topInt and bottomInt
     */
    public static int question2(int[] sortedArray, int bottomInt, int topInt, int indexBottom, int indexTop)
    {
        if((indexTop >= indexBottom && indexBottom <= (sortedArray.length - 1)))
        {
            int indexMiddle = (indexBottom + indexTop) / 2;
            if(sortedArray[indexMiddle] < topInt && sortedArray[indexMiddle] > bottomInt)
                return 1 + question2(sortedArray, bottomInt, topInt, indexBottom, indexMiddle - 1) + question2(sortedArray, bottomInt, topInt, indexMiddle + 1, indexTop);  
            else if(sortedArray[indexMiddle] <= bottomInt)
                return question2(sortedArray, bottomInt, topInt, indexMiddle + 1, indexTop);
            else
                return question2(sortedArray, bottomInt, topInt, indexBottom, indexMiddle - 1);
        }
        return 0;
    }

    /**
     * @param unsortedArray given unsorted array which is going to be searched to find subarrays which sum of their items is equal to target value
     * @param subArrays double dimensional ArrayList which holds index values of the unsortedArray. Sum of the numbers between these numbers are equal targetValue
     * @param targetValue Value that is searched for
     * @param sumOfValues Keeps the sum of the values of the current subarray that is being searched
     * @param startIndex starting position of the searched subarray
     * @param endIndex ending position of the searched subarray
     * @return returns the number of subarray which sum of their items is equal to target value
     */
    public static int question3(int[] unsortedArray, ArrayList<ArrayList<Integer>>  subArrays, int targetValue, int sumOfValues, int startIndex, int endIndex)
    {
        if(startIndex == unsortedArray.length - 1)
        {
            if(sumOfValues == targetValue)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(startIndex);
                temp.add(endIndex);
                subArrays.add(temp);
                return 1;
            }
            return 0;
        }

        if(endIndex == unsortedArray.length - 1)
        {
            if(sumOfValues > targetValue)
                return question3(unsortedArray, subArrays, targetValue, unsortedArray[startIndex + 1], startIndex + 1, startIndex + 1);
            else if(sumOfValues == targetValue)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(startIndex);
                temp.add(endIndex);
                subArrays.add(temp);
                return 1 + question3(unsortedArray, subArrays, targetValue, unsortedArray[startIndex + 1], startIndex + 1, startIndex + 1);
            }
        }

        if(sumOfValues > targetValue)
            return question3(unsortedArray, subArrays, targetValue, unsortedArray[startIndex + 1], startIndex + 1, startIndex + 1);
        else if(sumOfValues == targetValue)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(startIndex);
            temp.add(endIndex);
            subArrays.add(temp);
            return 1 + question3(unsortedArray, subArrays, targetValue, unsortedArray[startIndex + 1], startIndex + 1, startIndex + 1);
        }
        else
            return question3(unsortedArray, subArrays, targetValue, unsortedArray[endIndex + 1] + sumOfValues, startIndex, endIndex + 1);
    }

    public static int numberOfDigits(int x)
    {
        int i = 0;
        while(x > 0)
        {
            x /= 10;
            i++;
        }
        return i;
    }

    public static int max(int x, int y)
    {
        if(x > y)
            return x;
        return y;
    }

     public static int question4(int int1, int int2)
    {
        if(int1 < 10 || int2 < 10)
            return int1*int2;

        int half = max(numberOfDigits(int1), numberOfDigits(int2)) / 2;

        int a = (int) (int1 / Math.pow(10, half));
        int b = (int) (int1 % Math.pow(10, half));
        int c = (int) (int2 / Math.pow(10, half));
        int d = (int) (int2 % Math.pow(10, half));

        int sub0 = question4(b, d);
        int sub1 = question4(b, a) + question4(d, c);
        int sub2 = question4(c, a);
        int sum  = (int) (sub2* Math.pow(10, 2*half) + (sub1-sub2-sub0)* Math.pow(10, half) + sub0);

        return sum;
    }
    
    public static void question5(boolean[] emptyArray, int lengthOfSubArray, int startIndex, int endIndex, int tour)
    {
        if(lengthOfSubArray < 3)
            return;
        
        question5Print(emptyArray, lengthOfSubArray, startIndex, endIndex);

        if(lengthOfSubArray == emptyArray.length)
            return;

        if(endIndex < emptyArray.length)
            question5(emptyArray, lengthOfSubArray, ++startIndex, ++endIndex, tour);
        else
            question5(emptyArray, ++lengthOfSubArray, 0, lengthOfSubArray, 0);
    }

    public static void question5Print(boolean[] emptyArray, int lengthOfSubArray, int startIndex, int endIndex)
    {
        for(int i = 0; i < emptyArray.length; i++)
        {
            if(i >= startIndex && i < endIndex)
                System.out.print("*");
            else
                System.out.print("-");
        }
        System.out.println();
    }
}
