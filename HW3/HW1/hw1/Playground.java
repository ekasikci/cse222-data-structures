package hw1;

/**
 * Playground structure that has length and fixed height parameters 
 * @author Ertugrul Kasikci
 */
public class Playground extends Structure{
    
    /**
     * Default constructor
     */
    public Playground()
    {
        length = 10;
        height = 5;
    }
    
    /**
     * Constructor that takes toLength as a length parameter
     * @param toLength value to be length
     */
    public Playground(int toLength)
    {
        length = toLength;
        height = 5;
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

    /**
     * 
     * @return height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param toHeight garbage value
     */
    @Override
    public void setHeight(int toHeight) {
        height = 5;
    }
    
    /**
     * 
     * @return Playground information
     */
    @Override
    public String toString()
    {
        return "Playground - " + "   Owner: " + "   Length: " + length + "   Height: " + height;
    }
}
