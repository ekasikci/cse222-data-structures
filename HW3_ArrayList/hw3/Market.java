package hw3;

/**
 * Market structure that has length, height, openingTime, closingTİme and owner parameters
 * @author Ertugrul Kasikci
 */
public class Market extends Building{
    
    /**
     * Default constructor
     */
    public Market()
    {
        super();
        openingTime = 0;
        closingTime = 0;
        owner = "";
    }
    
    /**
     * Constructor that takes all parameter of the Market class
     * @param toLength value to be length
     * @param toHeight value to be height
     * @param toOpeningTime value to be openingTime
     * @param toClosingTime value to be closingTime
     * @param toOwner  value to be owner
     */
    public Market(int toLength, int toHeight, double toOpeningTime, double toClosingTime, String toOwner)
    {
        super(toLength, toHeight);
        openingTime = toOpeningTime;
        closingTime = toClosingTime;
        owner = toOwner;
    }
    
    /**
     * 
     * @return Market information
     */
    @Override
    public String toString()
    {
        return "Market - " + "   Owner: " + owner + "   Opening time: " + String.format("%.2f", openingTime) + "   Closing time: " + String.format("%.2f", closingTime) + "   Length: " + length + "   Height: " + height;
    }
     
    private double openingTime, closingTime;
}
