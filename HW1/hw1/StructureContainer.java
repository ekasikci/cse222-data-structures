package hw1;

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
        capacity = 1;
        leftSide = new Structure[capacity];
        rightSide = new Structure[capacity];
    }
    
    /**
     * Constructor that takes capacity value as input
     * @param toCapacity value to be the capacity of the StructureContainer
     */
    public StructureContainer (int toCapacity)
    {
        leftSize = 0;
        rightSize = 0;
        capacity = toCapacity;
        leftSide = new Structure[capacity];
        rightSide = new Structure[capacity];
    }
    
    /**
     * Adds a structure to the leftSide
     * @param toAdd structure to be add
     */
    public void addElementLeft(Structure toAdd)
    {
        if(leftSize == capacity)
            increaseCapacity();
        
        leftSide[leftSize] = toAdd;
        ++leftSize;
    }
    
    /**
     * Adds a structure to the rightSide
     * @param toAdd structure to be add
     */
    public void addElementRight(Structure toAdd)
    {
        if(rightSize == capacity)
            increaseCapacity();
        
        rightSide[rightSize] = toAdd;
        ++rightSize;
    }
    
    /**
     * Removes Structure at the index from leftSide
     * @param index index value indicates the structure to be deleted
     */
    public void removeElementLeft(int index)
    {     
        for(int i = index; i < leftSize - 1; ++i)
            leftSide[i] = leftSide[i + 1];
        leftSide[leftSize - 1] = null;
        --leftSize;
    }
    
    /**
     * Removes last Structure from leftSide
     */
    public void removeLastElementLeft()
    {     
        leftSide[leftSize - 1] = null;
        --leftSize;
    }
    
    /**
     * Removes Structure at the index from rightSide
     * @param index index value indicates the structure to be deleted
     */
    public void removeElementRight(int index)
    {     
        for(int i = index; i < rightSize - 1; ++i)
            rightSide[i] = rightSide[i + 1];
        rightSide[rightSize - 1] = null;
        --rightSize;
    }
    
    /**
     * Removes last Structure from rightSide
     */
    public void removeLastElementRight()
    {     
        rightSide[rightSize - 1] = null;
        --rightSize;
    }
    
    /**
     * Doubles capacity if it has been reached
     */
    private void increaseCapacity()
    {
        Structure[] leftTemp = new Structure[2*capacity];
        Structure[] rightTemp = new Structure[2*capacity];
   
        for(int i = 0; i < capacity; ++i)
        {
            leftTemp[i] = leftSide[i];
            rightTemp[i] = rightSide[i];
        }  
        
        leftSide = leftTemp;
        rightSide = rightTemp;
        capacity *= 2;
        leftTemp = null;
        rightTemp = null;
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
            return leftSide[index];
        }
        catch(ArrayIndexOutOfBoundsException x)
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
        return leftSide[leftSize - 1];
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
            return rightSide[index];
        }
        catch(ArrayIndexOutOfBoundsException x)
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
        return rightSide[rightSize - 1];
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
       
    private int leftSize, rightSize, capacity;
    private Structure[] leftSide;
    private Structure[] rightSide;
}
