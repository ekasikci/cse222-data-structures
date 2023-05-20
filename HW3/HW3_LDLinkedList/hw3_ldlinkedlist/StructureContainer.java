package hw3_ldlinkedlist;

/**
 * Keeps structures using array and does necessary implementations to them
 * @author Ertugrul Kasikci
 */
public class StructureContainer {
    
    /**
     * Default constructor
     */
    public StructureContainer()
    {
        leftSize = 0;
        rightSize = 0;
        leftSide = new LDLinkedList<Structure>();
        rightSide = new LDLinkedList<Structure>();
    }
    
    /**
     * Adds a structure to the leftSide
     * @param toAdd structure to be add
     */
    public void addElementLeft(Structure toAdd)
    {      
        leftSide.add(toAdd);
        ++leftSize;
    }
    
    /**
     * Adds a structure to the rightSide
     * @param toAdd structure to be add
     */
    public void addElementRight(Structure toAdd)
    {
        rightSide.add(toAdd);
        ++rightSize;
    }
    
    /**
     * Removes Structure at the index from leftSide
     * @param index index value indicates the structure to be deleted
     */
    public void removeElementLeft(int index)
    {     
        leftSide.remove(index);
        --leftSize;
    }
    
    /**
     * Removes last Structure from leftSide
     */
    public void removeLastElementLeft()
    {     
        leftSide.remove(leftSize - 1);
        --leftSize;
    }
    
    /**
     * Removes Structure at the index from rightSide
     * @param index index value indicates the structure to be deleted
     */
    public void removeElementRight(int index)
    {     
        rightSide.remove(index);
        --rightSize;
    }
    
    /**
     * Removes last Structure from rightSide
     */
    public void removeLastElementRight()
    {     
        rightSide.remove(rightSize - 1);
        --rightSize;
    }
    
    /**
     * 
     * @param index index value of the structure
     * @return structure at the index of left side
     */
    public Structure getElementLeft(int index)
    {
        try
        {
            return leftSide.get(index);
        }
        catch(ArrayIndexOutOfBoundsException x)
        {
            throw x;
        }
        catch(IndexOutOfBoundsException x)
        {
            throw x;
        }
    }
    
    /**
     * 
     * @return last element of the leftSide
     */
    public Structure getLastElementLeft()
    {
        return leftSide.get(leftSize - 1);
    }
    
    /**
     * 
     * @param index index value of the structure
     * @return structure at the index of rightSide
     */
    public Structure getElementRight(int index)
    {
        try
        {
            return rightSide.get(index);
        }
        catch(ArrayIndexOutOfBoundsException x)
        {
            throw x;
        }
        catch(IndexOutOfBoundsException x)
        {
            throw x;
        }
        
    }
    
    /**
     * 
     * @return last element of the rightSide
     */
    public Structure getLastElementRight()
    {
        return rightSide.get(rightSize - 1);
    }
    
    /**
     * 
     * @return size of the leftSide
     */
    public int getLeftSize()
    {
        return leftSize;
    }
    
    /**
     * 
     * @return size of the rightSide
     */
    public int getRightSize()
    {
        return rightSize;
    }
       
    private int leftSize, rightSize;
    private LDLinkedList<Structure> leftSide;
    private LDLinkedList<Structure> rightSide;
}
