package hw3_ldlinkedlist;

/**
 * Office structure that has length, height, jobType and owner parameters
 * @author Ertugrul Kasikci
 */
public class Office extends Building{
    
    /**
     * Default contructor
     */
    public Office()
    {
        super();
        jobType = "";
        owner = "";
    }
    
    /**
     * Constructor that takes all the parameters of the Office class
     * @param toLength value to be length
     * @param toHeight value to be height
     * @param toJobType value to be jobType
     * @param toOwner  value to be owner
     */
    public Office(int toLength, int toHeight, String toJobType, String toOwner)
    {
        super(toLength, toHeight);
        jobType = toJobType;
        owner = toOwner;
    }
    
    /**
     * 
     * @return Office information
     */
    @Override
    public String toString()
    {
        return "Office - " + "   Owner: " + owner + "   Job type: " + jobType + "   Length: " + length + "   Height: " + height;
    }
    
    private String jobType;
}
