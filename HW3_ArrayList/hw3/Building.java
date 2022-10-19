package hw3;

/**
 *
 * @author Ertugrul Kasikci
 */
public abstract class Building extends Structure{

    /**
     * Default constructor
     */
    public Building()
    {
        length = 0;
        height = 0;
    }
    
    /**
     * Constructor that takes all parameter of the abstract Building class
     * @param toLength value to be length
     * @param toHeight value to be height
     */
    public Building(int toLength, int toHeight)
    {
        length = toLength;
        height = toHeight;
    }
    
    /**
     * 
     * @return length
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * 
     * @param toLength value to be length 
     */
    @Override
    public void setLength(int toLength) {
        length = toLength;
    }
    
    /**
     * 
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param toHeight value to be height
     */
    public void setHeight(int toHeight) {
        height = toHeight;
    }
    
    /**
     * 
     * @return startPoint
     */
    public int getStartPoint() {
        return startPoint;
    }

    /**
     * 
     * @param toStartpoint value to be startPoint
     */
    public void setStartPoint(int toStartpoint) {
        startPoint = toStartpoint;
    }
    
    /**
     * 
     * @return endPoint
     */
    public int getEndPoint() {
        return endPoint;
    }

    /**
     * 
     * @param toEndpoint value to be endPoint
     */
    public void setEndPoint(int toEndpoint) {
        endPoint = toEndpoint;
    }
    
    protected String owner;   
}
