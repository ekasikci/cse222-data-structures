package hw1;

/**
 * Street object that keep structures in its left and right sides
 * @author Ertugrul Kasikci
 */
public class Street{
    
    /**
     * Default constructor
     */
    public Street()
    {
        length = 0;
        structures = new StructureContainer();
        street = new StreetContainer(length);
    }
    
    /**
     * Constructor that takes toLength parameter as a lenght
     * @param toLength value to be length
     */
    public Street(int toLength)
    {
        length = toLength;
        structures = new StructureContainer();
        street = new StreetContainer(toLength);
    }

    /**
     * 
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * 
     * @param toLength value to be length
     */
    public void setLength(int toLength) {
        length = toLength;
        structures = new StructureContainer();
        street = new StreetContainer(length);
    }
    
    /**
     * Adds structure at the first available place of the left side of the street
     * @param toAdd structure to be add
     */
    public void addBuildingLeft(Structure toAdd)
    {    
        structures.addElementLeft(toAdd);
        street.addLeft(toAdd);
    }
    
    /**
     * Adds structure at the startPoint of the left side of the street
     * @param toAdd structure to be add
     * @param startPoint place where toAdd will be added
     */
    public void addBuildingLeft(Structure toAdd, int startPoint)
    {
        structures.addElementLeft(toAdd);
        street.addLeft(toAdd, startPoint);
    }
    
    /**
     * Adds structure at the first available place of the right side of the street
     * @param toAdd structure to be add
     */
    public void addBuildingRight(Structure toAdd)
    {    
        structures.addElementRight(toAdd);
        street.addRight(toAdd);
    }
    
    /**
     * Adds structure at the startPoint of the right side of the street
     * @param toAdd structure to be add
     * @param startPoint place where toAdd will be added
     */
    public void addBuildingRight(Structure toAdd, int startPoint)
    {
        structures.addElementRight(toAdd);
        street.addRight(toAdd, startPoint);
    }
    
    /**
     * Removes last added structure from the left side of the street
     */
    public void removeBuildingLeft()
    {
        street.removeBuildingLeft(structures.getLastElementLeft());
        structures.removeLastElementLeft();
    }
    
    /**
     * Removes structure at the index from the left side of the street
     * @param index index value of the structure to be remove
     */
    public void removeBuildingLeft(int index)
    {
        try
        {
            street.removeBuildingLeft(structures.getElementLeft(index));
        }
        catch(NullPointerException x)
        {
            return;
        }
        catch(ArrayIndexOutOfBoundsException x)
        {
            return;
        }
        try
        {
            structures.removeElementLeft(index);
        }
        catch(ArrayIndexOutOfBoundsException x)
        {
            return;
        }
        
    }
    
    /**
     * Removes last added structure from the right side of the street
     */
    public void removeBuildingRight()
    {
        street.removeBuildingRight(structures.getLastElementRight());
        structures.removeLastElementRight();
    }
    
    /**
     * Removes structure at the index from the right side of the street 
     * @param index index value of the structure to be remove
     */
    public void removeBuildingRight(int index)
    {
        try
        {
            street.removeBuildingRight(structures.getElementRight(index));
        }
        catch(NullPointerException x)
        {
            return;
        }
        catch(ArrayIndexOutOfBoundsException x)
        {
            return;
        }
        try
        {
            structures.removeElementRight(index);
        }
        catch(ArrayIndexOutOfBoundsException x)
        {
            return;
        }
    }
    
    /**
     * Prints silhouette view of the street
     */
    public void printSilhouette()
    {
        street.printSilhouette();
    }
    
    /**
     * 
     * @return total remaining length of the left side of the street
     */
    public int totalRemainingLengthLeft()
    {
        return street.totalRemainingLengthLeft();
    }
    
    /**
     * 
     * @return total remaining length of the right side of the street
     */
    public int totalRemainingLengthRight()
    {
        return street.totalRemainingLengthRight();
    }
    
    /**
     * 
     * @return structures at the street
     */
    public StructureContainer getStructures()
    {
        return structures;
    }

    private StreetContainer street;
    private StructureContainer structures;
    private int length, height;
}