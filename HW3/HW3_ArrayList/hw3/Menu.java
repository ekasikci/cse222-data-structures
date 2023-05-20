package hw3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Menu class is the menu of the program, it allows users to interact with Street
 * @author Ertugrul Kasikci
 */
public class Menu {
    
    /**
     * Default constructor
     */
    public Menu()
    {
        street = new Street();
    }
    
    /**
     * Constructor that takes toStreet as a street argument
     * @param toStreet value to be street
     */
    public Menu(Street toStreet)
    {
        street = toStreet;
    }
    
    /**
     * Main menu of the program
     */
    public void Mainmenu()
    {
        boolean modeFlag = false;
        
        System.out.println("Enter the length of the street");
        street.setLength(sc.nextInt());
        
        while(!modeFlag)
        {
            street.printSilhouette();
            
            System.out.println("Select the mode  1: Editing mode, 2: Viewing mode, 3: Exit");
            switch (sc.nextInt())
            {
                case 1:
                {
                    editingMode();
                    break;
                }
                case 2:
                {
                    viewingMode();
                    break;
                }
                case 3:
                {
                    modeFlag = true;
                    break;
                }
                default:
                {
                    System.out.println("Invalid input! Enter again.");
                }
            }
        }
    }
    
    /**
     * Menu where user can edit the street
     */
    public void editingMode()
    {
        boolean addDeleteFlag = false;
        System.out.println("Current Street: ");
        street.printSilhouette();
        
        while(!addDeleteFlag)
        {
            System.out.println("\n\n1: Add building, 2: Delete Building, 3: Exit main menu");
            switch (sc.nextInt())
            {
                case 1:
                {
                    addBuilding();
                    break;
                }
                case 2:
                {
                    deleteBuilding();
                    break;
                }
                case 3:
                {
                    addDeleteFlag = true;
                    break;
                }
                default:
                {
                    System.out.println("Invalid input! Enter again.");
                }
            }
        }
    }
    
    /**
     * Menu where user can see the information about street and structures in it
     */
    public void viewingMode()
    {
        int playGroundNumber = 0, playGroundLength = 0, marketLength = 0, houseLength = 0, officeLenght = 0;
        System.out.println(street.totalRemainingLengthLeft() + "length remaining left side of the street ");
        System.out.println(street.totalRemainingLengthRight() + "length remaining right side of the street ");
        
        System.out.println("Left side of the street:");
        for(int k = 0; k < street.getStructures().getLeftSize(); ++k)
        {
            System.out.println(street.getStructures().getElementLeft(k).toString());
            if(Playground.class ==  street.getStructures().getElementLeft(k).getClass())
            {
                ++playGroundNumber;
                playGroundLength += street.getStructures().getElementLeft(k).getLength();
            }
            else if(Market.class ==  street.getStructures().getElementLeft(k).getClass())
                marketLength += street.getStructures().getElementLeft(k).getLength();
            else if(House.class ==  street.getStructures().getElementLeft(k).getClass())
                houseLength += street.getStructures().getElementLeft(k).getLength();
            else if(Office.class ==  street.getStructures().getElementLeft(k).getClass())
                officeLenght += street.getStructures().getElementLeft(k).getLength();
        }
        System.out.print("\n\n");
        System.out.println("Right side of the street:");
        for(int k = 0; k < street.getStructures().getRightSize(); ++k)
        {     
            System.out.println(street.getStructures().getElementRight(k).toString());
            if(Playground.class ==  street.getStructures().getElementRight(k).getClass())
            {
                ++playGroundNumber;
                playGroundLength += street.getStructures().getElementRight(k).getLength();
            }
        }
        System.out.print("\n\n");
        
        System.out.println("There is " + playGroundNumber + 
                " playground in the street, Ratio of length of playgrounds in the street is: " + (double)playGroundLength/street.getLength());
        
        System.out.println("Total length of street occupied by the markets is: " + marketLength);
        System.out.println("Total length of street occupied by the houses is: " + houseLength);
        System.out.println("Total length of street occupied by the offices is: " + officeLenght);
        
        int result;
        long start, end;
        start = System.nanoTime();
        street.printSilhouette();
        end = System.nanoTime();
        System.out.println("Elapsed Time in milliseconds: "+ (end - start)/1000000);  
    }
    
    /**
     * Menu that allows user to add structure to street
     */
    public void addBuilding()
    {
        boolean buildingSelectingFlag = false, sideSelectionFlag = false;
        while(!sideSelectionFlag)
        {
            System.out.println("Select a side to add a building. 1: left, 2: right, 3: exit");
            switch (sc.nextInt())
            {
                case 1:
                {
                    System.out.println("Select a building type to add");
                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");

                    while(!buildingSelectingFlag)
                    {
                        switch (sc.nextInt())
                        {
                            case 1:
                            {
                                System.out.println("Enter houses length, height, number of rooms, color, and owner sequentially");
                                try
                                {
                                    street.addBuildingLeft(new House(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next(), sc.next()));
                                }
                                catch(InputMismatchException x)
                                {
                                    System.out.println("Invalid input!");
                                    System.out.println("Select a building type to add");
                                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");
                                    sc.next();
                                    break;
                                }
                                buildingSelectingFlag = true;
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Enter market's length, height, opening time, closing time, and owner sequentially");
                                try
                                {
                                    street.addBuildingLeft(new Market(sc.nextInt(), sc.nextInt(), sc.nextDouble(), sc.nextDouble(), sc.next()));
                                }
                                catch(InputMismatchException x)
                                {
                                    System.out.println("Invalid input!");
                                    System.out.println("Select a building type to add");
                                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");
                                    sc.next();
                                    break;
                                }                   
                                buildingSelectingFlag = true;
                                break;
                            }
                            case 3:
                            {
                                    System.out.println("Enter office's length, height, job type, and owner sequentially");
                                try
                                {
                                    street.addBuildingLeft(new Office(sc.nextInt(), sc.nextInt(), sc.next(), sc.next()));
                                }
                                catch(InputMismatchException x)
                                {
                                    System.out.println("Invalid input!");
                                    System.out.println("Select a building type to add");
                                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");
                                    sc.next();
                                    break;
                                }                                                              
                                buildingSelectingFlag = true;
                                break;
                            }
                            case 4:
                            {
                                System.out.println("Enter playground's length");
                                try
                                {
                                    street.addBuildingLeft(new Playground(sc.nextInt()));                                
                                }
                                catch(InputMismatchException x)
                                {
                                    System.out.println("Invalid input!");
                                    System.out.println("Select a building type to add");
                                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");
                                    sc.next();
                                    break;
                                }               
                                buildingSelectingFlag = true;
                                break;
                            }
                            default:
                            {
                                System.out.println("Invalid input! Enter again.");
                                break;
                            }
                        }
                    }
                    sideSelectionFlag = true;
                    break;
                }
                case 2:
                {
                    System.out.println("Select a building type to add");
                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");

                    while(!buildingSelectingFlag)
                    {
                        switch (sc.nextInt())
                        {
                            case 1:
                            {
                                System.out.println("Enter houses length, height, number of rooms, color, and owner sequentially");
                                try
                                {
                                    street.addBuildingRight(new House(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next(), sc.next()));
                                }
                                catch(InputMismatchException x)
                                {
                                    System.out.println("Invalid input!");
                                    System.out.println("Select a building type to add");
                                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");
                                    sc.next();
                                    break;
                                } 
                                buildingSelectingFlag = true;
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Enter market's length, height, opening time, closing time, and owner sequentially");
                                try
                                {
                                    street.addBuildingRight(new Market(sc.nextInt(), sc.nextInt(), sc.nextDouble(), sc.nextDouble(), sc.next()));
                                }
                                catch(InputMismatchException x)
                                {
                                    System.out.println("Invalid input!");
                                    System.out.println("Select a building type to add");
                                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");
                                    sc.next();
                                    break;
                                } 
                                buildingSelectingFlag = true;
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Enter office's length, height, job type, and owner sequentially");
                                try
                                {
                                    street.addBuildingRight(new Office(sc.nextInt(), sc.nextInt(), sc.next(), sc.next()));
                                }
                                catch(InputMismatchException x)
                                {
                                    System.out.println("Invalid input!");
                                    System.out.println("Select a building type to add");
                                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");
                                    sc.next();
                                    break;
                                }
                                buildingSelectingFlag = true;
                                break;
                            }
                            case 4:
                            {
                                System.out.println("Enter playground's length");
                                try
                                {
                                    street.addBuildingRight(new Playground(sc.nextInt()));
                                }
                                catch(InputMismatchException x)
                                {
                                    System.out.println("Invalid input!");
                                    System.out.println("Select a building type to add");
                                    System.out.println("1: House, 2: Market, 3: Office, 4: Playground");
                                    sc.next();
                                    break;
                                }
                                buildingSelectingFlag = true;
                                break;
                            }
                            default:
                            {
                                System.out.println("Invalid input! Enter again.");
                                break;
                            }
                        }
                    }
                    sideSelectionFlag = true;
                    break;
                }
                case 3:
                {
                    sideSelectionFlag = true;
                    break;
                }
                default:
                {
                    System.out.println("Invalid input! Enter again.");
                    break;
                }
            }
        }
            
          
        street.printSilhouette();
    }
    
    /**
     *  Menu that allows user to delete structure from street
     */
    public void  deleteBuilding()
    {
        int selectionToDelete;

        street.printSilhouette();
        for(int i = 0; i < street.getStructures().getRightSize(); ++i)
        {
            System.out.println(i + street.getStructures().getLeftSize() + 1 + ": " + street.getStructures().getElementRight(i).toString());
        }
        
        System.out.println("Select the building index to delete (0: Exit)");
        
        selectionToDelete = sc.nextInt();
        
        if(selectionToDelete == 0)
            return;
        else if(selectionToDelete <= street.getStructures().getLeftSize())
        {
            street.removeBuildingLeft(selectionToDelete - 1);
        }
        else if(selectionToDelete > street.getStructures().getLeftSize() && 
                selectionToDelete <= street.getStructures().getRightSize() + street.getStructures().getLeftSize())
        {
            street.removeBuildingRight(selectionToDelete - street.getStructures().getLeftSize() - 1);
        }
        else
            System.out.println("Invalid input entered!\nz");
        
        street.printSilhouette();
        
    }
    private Scanner sc = new Scanner(System.in); 
    private Street street;
}
