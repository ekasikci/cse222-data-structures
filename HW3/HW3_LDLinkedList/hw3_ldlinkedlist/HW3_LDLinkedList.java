package hw3_ldlinkedlist;

/**
 *
 * @author Ertugrul Kasikci
 */
public class HW3_LDLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DriverFunction();
        
        Street street = new Street();
        Menu menu = new Menu(street);
        
        menu.Mainmenu();
    }
    
    public static void DriverFunction()
    {
        long startPrint, endPrint, startAdd, endAdd, startRemove, endRemove;
        Street street = new Street(55);
        Street streetForAnalysis1 = new Street(1);
        Street streetForAnalysis2 = new Street(10);
        Street streetForAnalysis3 = new Street(100);

        
        street.addBuildingLeft(new House(8, 20, 10, "blue", "Ertugrul"));
        
        street.addBuildingLeft(new Office(11, 20, "Software", "GTU"), 12);
        
        street.addBuildingLeft(new Market(7, 12, 10.00, 21.00, "Migros"), 38);
        
        street.addBuildingLeft(new Market(7, 12, 10.00, 21.00, "Bim"), 48);
        
        street.addBuildingRight(new Playground(8), 6);
        
        street.addBuildingRight(new Office(13, 25, "Consultancy", "Deloitte"), 18);
        
        street.addBuildingRight(new House(7, 20, 10, "yellow", "Kaan"), 43);

        
        street.printSilhouette();
        
        
        street.removeBuildingLeft();
        
        street.printSilhouette();

        street.removeBuildingRight(-99); // Exception handling
        street.removeBuildingLeft(99);
       // Try to add a structure where is occupied with another structure.
        street.addBuildingRight(new Playground(10), 2); 
       // Try to exceed the street by addind larger structure than street.
        street.addBuildingRight(new Playground(1000));

        street.printSilhouette();
        
        Menu menu = new Menu(street);
        
        menu.viewingMode();
        System.out.print("\n\n");
        
        startAdd = System.nanoTime();
        streetForAnalysis1.addBuildingLeft(new House(1, 1, 10, "blue", "Ertugrul"));
        endAdd = System.nanoTime();
        
        startPrint = System.nanoTime();
        streetForAnalysis1.printSilhouette();
        endPrint = System.nanoTime();
        
        startRemove = System.nanoTime();
        streetForAnalysis1.removeBuildingLeft();
        endRemove = System.nanoTime();
        
        AnalysisResults(startAdd, endAdd, startRemove, endRemove, startPrint, endPrint, 1);
        
        startAdd = System.nanoTime();
        streetForAnalysis2.addBuildingLeft(new House(10, 10, 10, "blue", "Ertugrul"));
        endAdd = System.nanoTime();
        
        startPrint = System.nanoTime();
        streetForAnalysis2.printSilhouette();
        endPrint = System.nanoTime();
        
        startRemove = System.nanoTime();
        streetForAnalysis2.removeBuildingLeft();
        endRemove = System.nanoTime();
        
        AnalysisResults(startAdd, endAdd, startRemove, endRemove, startPrint, endPrint, 10);
        
        startAdd = System.nanoTime();
        streetForAnalysis3.addBuildingLeft(new House(100, 100, 10, "blue", "Ertugrul"));
        endAdd = System.nanoTime();
        
        startPrint = System.nanoTime();
        streetForAnalysis3.printSilhouette();
        endPrint = System.nanoTime();
        
        startRemove = System.nanoTime();
        streetForAnalysis3.removeBuildingLeft();
        endRemove = System.nanoTime();
        
        AnalysisResults(startAdd, endAdd, startRemove, endRemove, startPrint, endPrint, 100);
    }
    
    public static void AnalysisResults(long startAdd, long endAdd, long startRemove, long endRemove, long startPrint, long endPrint, int nSize)
    {
        System.out.println("LDLinkedList for " + nSize + " complexity");
        System.out.println("Elapsed Time in milliseconds for adding a structure: "+ (endAdd - startAdd)/1000);
        System.out.println("Elapsed Time in milliseconds for removeing a structure: "+ (endRemove - startRemove)/1000);
        System.out.println("Elapsed Time in milliseconds for printSilhouette: "+ (endPrint - startPrint)/1000);  
        System.out.println("\n");
    }
}
