package hw1;

/**
 * Base abstract class of all classes in the program
 * @author Ertugrul Kasikci
 */
public abstract class Structure {
    
    public abstract int getLength();

    public abstract void setLength(int toLength);
    
    public abstract int getHeight();

    public abstract void setHeight(int toHeight);
    
    public abstract int getStartPoint();

    public abstract void setStartPoint(int toStartpoint);
    
    public abstract int getEndPoint();

    public abstract void setEndPoint(int toEndpoint);
    
    protected int startPoint, endPoint, length, height;

}
