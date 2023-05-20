package hw5;

/**
 *
 * @author Ertugrul Kasikci
 */
public class HW5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        question3();
        question4();
    }
    
    public static void question3()
    {
        int intArray[] = new int[]{1, 2, 3, 4 , 5 , 6, 7, 8, 9, 10};
        BinaryHeap<Integer> x = new BinaryHeap<Integer>();
        System.out.println("_____________________________________________________________________________");
        System.out.println("Question 3:\n\n");
        System.out.println("Inserting " + intArray[4] + "\n");
        x.insert(intArray[4]); 
        System.out.println(x.toString());
        System.out.println("Inserting " + intArray[1] + "\n");
        x.insert(intArray[1]); 
        System.out.println(x.toString());
        System.out.println("Inserting " + intArray[7] + "\n");
        x.insert(intArray[7]); 
        System.out.println(x.toString());
        System.out.println("Inserting " + intArray[3] + "\n");
        x.insert(intArray[3]); 
        System.out.println(x.toString());
        System.out.println("Inserting " + intArray[2] + "\n");
        x.insert(intArray[2]); 
        System.out.println(x.toString());
        System.out.println("Inserting " + intArray[6] + "\n");
        x.insert(intArray[6]); 
        System.out.println(x.toString());
        System.out.println("Inserting " + intArray[5] + "\n");
        x.insert(intArray[5]); 
        System.out.println(x.toString());
        
        System.out.println("Removing");
        x.remove();
        System.out.println(x.toString());
        
        BinaryHeap<Integer> y = new BinaryHeap<Integer>();
        
        y.insert(intArray[0]);   
        y.insert(intArray[8]);
        y.insert(intArray[9]);
        System.out.println("Merging with");
        System.out.println(y.toString());
        x.merge(y);
        System.out.println("Result\n");
        System.out.println(x.toString());

    }
    
    public static void question4()
    {
        int val1 = 4, val2 = 7, val3 = 2, val4 = 9;
        System.out.println("_____________________________________________________________________________");
        System.out.println("Question 4:\n\n");
        
        System.out.println("Creating a tree with root value 1\n");
        ArrayBST<Integer> x= new ArrayBST<Integer>(6);
        System.out.println(x.toString());
        
        System.out.println("Adding " + val1 + "\n");
        x.add(val1);
        System.out.println(x.toString());
        System.out.println("Adding " + val2 + "\n");
        x.add(val2);
        System.out.println(x.toString());
        System.out.println("Adding " + val3 + "\n");
        x.add(val3);
        System.out.println(x.toString());
        System.out.println("Adding " + val4 + "\n");
        x.add(val4);
        System.out.println(x.toString());
        
        System.out.print("Does tree contain " + val1 + ": ");
        System.out.println(x.contains(val1) + "\n");
        System.out.print("Find " + val2 + ": ");
        System.out.println(x.find(val2) + "\n");
        System.out.print("Delete " + val3 + ": ");
        System.out.println(x.delete(val3) + "\n");
        System.out.println(x.toString());
        System.out.print("Remove " + val4 + ": ");
        System.out.println(x.remove(val4) + "\n");    
        System.out.println(x.toString());
        System.out.print("Remove " + val4 + " again: ");
        System.out.println(x.remove(val4) + "\n");
        System.out.println(x.toString());
        System.out.print("Find " + val4 + ": ");
        System.out.println(x.find(val4) + "\n");
        System.out.print("Does tree contain " + val4 + ": ");
        System.out.println(x.contains(val4));
        x.toString();
    }   
}
