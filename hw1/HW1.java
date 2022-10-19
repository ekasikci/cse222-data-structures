package hw1;

/**
 *
 * @author Ertugrul Kasikci
 */
public class HW1 {

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
        Street street = new Street(55);
        
        street.addBuildingLeft(new House(8, 20, 10, "blue", "Ertugrul"));
        
        street.addBuildingLeft(new Office(11, 20, "Software", "GTU"), 12);
        
        street.addBuildingLeft(new Market(7, 12, 10.00, 21.00, "Migros"), 38);
        
        street.addBuildingLeft(new Market(7, 12, 10.00, 21.00, "Bim"), 48);
        
        street.addBuildingRight(new Playground(8), 6);
        
        street.addBuildingRight(new Office(13, 25, "Consultancy", "Deloitte"), 18);
        
        street.addBuildingRight(new House(7, 20, 10, "yellow", "Kaan"), 43);
        
        street.printLeft();
        street.printRight();
        street.printSilhouette();
        
        
        street.removeBuildingLeft();
        
        street.printSilhouette();
        street.printRight();
        
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
    }
}
