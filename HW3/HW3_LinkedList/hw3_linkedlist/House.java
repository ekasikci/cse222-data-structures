package hw3_linkedlist;

/**
 * House structure that has length, height, numberOfRooms, color and owner parameters
 * @author Ertugrul Kasikci
 */
public class House extends Building{
    
    /**
     * Default constructor
     */
    public House()
    {
        super();
        numberOfRooms = 0;
        color = "";
        owner = "";
    }
    
    /**
     * Constructor that takes all parameter of the House class
     * @param toLength value to be length
     * @param toHeight value to be height
     * @param toNumberOfRooms value to be numberOfRooms
     * @param toColor value to be color
     * @param toOwner  value to be owner
     */
    public House(int toLength, int toHeight, int toNumberOfRooms, String toColor, String toOwner)
    {
        super(toLength, toHeight);
        numberOfRooms = toNumberOfRooms;
        color = toColor;
        owner = toOwner;
    }
    
    /**
     * 
     * @return House information
     */
    @Override
    public String toString()
    {
        return "House - " + "   Owner: " + owner + "   Color: " + color + "   Length: " + length + "   Height: " + height;
    }
    
    private int numberOfRooms;
    private String color;
}
