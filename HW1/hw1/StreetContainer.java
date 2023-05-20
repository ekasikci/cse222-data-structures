package hw1;

/**
 * StreetContainer class handles Street classes methods and uses arrays to keep track of structures
 * @author Ertugrul Kasikci
 */
public class StreetContainer {
    
    /**
     * Default constructor
     */
    public StreetContainer()
    {
        length = 1;
        height = 1;
        leftSide = new boolean[height][length];
        rightSide = new boolean[height][length];
    }
    
    /**
     * Constructor that takes length value as input
     * @param toLength value to be the length of both leftSide and rightSide
     */
    public StreetContainer(int toLength)
    {
        length = toLength;
        height = 1;
        leftSide = new boolean[height][length];
        rightSide = new boolean[height][length];
    }
    
    /**
     * Increases height of the streets if a structure that is higher than the streets is added
     * @param toHeight height parameter to be the new street height
     */
    private void increaseHeight(int toHeight)
    {
        boolean[][] lTemp = new boolean[toHeight][length];
        boolean[][] rTemp = new boolean[toHeight][length];

                
        for(int i = 0; i < height; ++i)
        {
            for(int j = 0; j < length; ++j)
            {
                lTemp[i][j] = leftSide[i][j];
                rTemp[i][j] = rightSide[i][j];
            }
        }
        
        leftSide = lTemp;
        rightSide = rTemp;
        
        height = toHeight;
        
        lTemp = null;
        rTemp = null;
    }
    
    /**
     * Adds toAdd to the first available place of the left street
     * @param toAdd structure to be added
     * @return returns true if adding is successful otherwise false
     */
    public boolean addLeft(Structure toAdd)
    {
        int addLength = toAdd.getLength();
        int addHeight = toAdd.getHeight();
        
        // increases height of the street if the building to be add is higher than it
        if(height < addHeight)
            increaseHeight(addHeight);
        
        if(addLength <= length)
        {
            int counter = 0;
            
            // finds the first empty spaces that can be filled up with the given structure
            // at the left side of the street then saves these informations
            for(int i = 0; i < length; ++i) 
            {
                if(!leftSide[0][i])
                    ++counter;
                else
                    counter = 0;
                
                if(counter == addLength)
                {
                    toAdd.setStartPoint(i - counter + 1);
                    toAdd.setEndPoint(i);
                    break;
                }                      
            }
            
            if(counter == addLength)
            {
                for(int i = 0; i < addHeight; ++i)
                {
                    for(int j = toAdd.getStartPoint(); j <= toAdd.getEndPoint(); ++j)
                    {
                        leftSide[i][j] = true;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
    
    /**
     * toAdd to the given startPoint of the left street
     * @param toAdd structure to be added
     * @param startPoint start point of the given structure to be add
     * @return returns true if adding is successful otherwise false
     */
    public boolean addLeft(Structure toAdd, int startPoint)
    {
        int addLength = toAdd.getLength();
        int addHeight = toAdd.getHeight();
        
        // increases height of the street if the building to be add is higher than it
        if(height < addHeight)
            increaseHeight(addHeight);

        if(startPoint + addLength <= length)
        {            
            int counter = 0;
            
            // finds the first empty spaces that can be filled up with the given structure
            // at the left side of the street then saves these informations
            for(int i = startPoint; i < length; ++i) 
            {
                if(!leftSide[0][i])
                    ++counter;
                else
                    return false;
                
                if(counter == addLength)
                {
                    toAdd.setStartPoint(i - counter + 1);
                    toAdd.setEndPoint(i);
                    break;
                }                      
            }
            
            if(counter == addLength)
            {
                for(int i = 0; i < addHeight; ++i)
                {
                    for(int j = toAdd.getStartPoint(); j <= toAdd.getEndPoint(); ++j)
                    {
                        leftSide[i][j] = true;
                    }
                }
                return true;
            }         
            return false;
        }
        return false;
    }

    /**
     * Adds toAdd to the first available place of the right street
     * @param toAdd structure to be added
     * @return returns true if adding is successful otherwise false
     */
    public boolean addRight(Structure toAdd)
    {
        int addLength = toAdd.getLength();
        int addHeight = toAdd.getHeight();
        
        // increases height of the street if the building to be add is higher than it
        if(height < addHeight)
            increaseHeight(addHeight);

        if(addLength <= length)
        {
            int counter = 0;
            
            // finds the first empty spaces that can be filled up with the given structure
            // at the left side of the street then saves these informations
            for(int i = 0; i < length; ++i) 
            {
                if(!rightSide[0][i])
                    ++counter;
                else
                    counter = 0;
                
                if(counter == addLength)
                {
                    toAdd.setStartPoint(i - counter + 1);
                    toAdd.setEndPoint(i);
                    break;
                }                      
            }
            
            if(counter == addLength)
            {
                for(int i = 0; i < addHeight; ++i)
                {
                    for(int j = toAdd.getStartPoint(); j <= toAdd.getEndPoint(); ++j)
                    {
                        rightSide[i][j] = true;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
    
    /**
     * Adds toAdd to the given startPoint of the right street
     * @param toAdd structure to be added
     * @param startPoint start point of the given structure to be add
     * @return returns true if adding is successful otherwise false
     */
    public boolean addRight(Structure toAdd, int startPoint)
    {
        int addLength = toAdd.getLength();
        int addHeight = toAdd.getHeight();
        
        // increases height of the street if the building to be add is higher than it
        if(height < addHeight)
            increaseHeight(addHeight);

        if(startPoint + addLength <= length)
        {
            int counter = 0;
            
            // finds the first empty spaces that can be filled up with the given structure
            // at the left side of the street then saves these informations
            for(int i = startPoint; i < length; ++i) 
            {
                if(!rightSide[0][i])
                    ++counter;
                else
                    return false;
                
                if(counter == addLength)
                {
                    toAdd.setStartPoint(i - counter + 1);
                    toAdd.setEndPoint(i);
                    break;
                }                      
            }
            
            if(counter == addLength)
            {
                for(int i = 0; i < addHeight; ++i)
                {
                    for(int j = toAdd.getStartPoint(); j <= toAdd.getEndPoint(); ++j)
                    {
                        rightSide[i][j] = true;
                    }
                }
                return true;
            }          
            return false;
        }
        return false;
    }
    
    /**
     * Removes toRemove from the left side of the street
     * @param toRemove structure to be remove
     */
    public void removeBuildingLeft(Structure toRemove)
    {
        for (int i = 0; i < toRemove.height; ++i)
        {
            for(int j = toRemove.startPoint; j <= toRemove.endPoint; ++j)
            {
                leftSide[i][j] = false;
            }
        }
    } 
    
    /**
     * Removes toRemove from the right side of the street
     * @param toRemove structure to be remove
     */
    public void removeBuildingRight(Structure toRemove)
    {
        for (int i = 0; i < toRemove.height; ++i)
        {
            for(int j = toRemove.startPoint; j <= toRemove.endPoint; ++j)
            {
                rightSide[i][j] = false;
            }
        }
    }

    /**
     * Prints the street view from the left side
     * @param structures structures in the street
     */
    public void printLeft(StructureContainer structures)
    {
        int startPointLeft = length, endPointLeft = 0, startPointRight = length, endPointRight = 0, indexLeft = 0, indexRight = 0;
        
        for(int i = height - 1; i >= 0; --i)
        {
            for(int j = 0; j < length; ++j)
            {
                for(int k = 0; k < structures.getLeftSize(); ++k)
                {
                    if(structures.getElementLeft(k).startPoint == j)
                    {
                        //System.out.println(j);
                        startPointLeft = structures.getElementLeft(k).startPoint;
                        endPointLeft = structures.getElementLeft(k).endPoint;
                        indexLeft = k;                      
                        break;
                    }
                }
                
                for(int k = 0; k < structures.getRightSize(); ++k)
                {
                    if(structures.getElementRight(k).startPoint == j)
                    {
                        startPointRight = structures.getElementRight(k).startPoint;
                        endPointRight = structures.getElementRight(k).endPoint;
                        indexRight = k;                   
                       break;
                    }
                }
                
                try
                {
                    if((j == startPointLeft || j == endPointLeft) && leftSide[i][j])
                        System.out.print("|");              
                    else if(i == structures.getElementLeft(indexLeft).getHeight() - 1 && leftSide[i][j])
                        System.out.print("-");
                    else if((j == startPointRight || j == endPointRight) && !leftSide[i][j] && rightSide[i][j])
                        System.out.print("|");
                    else if(i == structures.getElementRight(indexRight).getHeight() - 1 && !leftSide[i][j] && rightSide[i][j])
                        System.out.print("-");
                    else
                        System.out.print(" ");
                }
                catch(NullPointerException x)
                {
                    try
                    {
                        if((j == startPointRight || j == endPointRight) && !leftSide[i][j] && rightSide[i][j])
                            System.out.print("|");
                        else if(i == structures.getElementRight(indexRight).getHeight() - 1 && !leftSide[i][j] && rightSide[i][j])
                            System.out.print("-");
                        else
                            System.out.print(" ");
                    }
                    catch(NullPointerException y)
                    {
                        System.out.print(" ");
                    }                
                }                            
            }
            System.out.println();
            startPointLeft = length; endPointLeft = 0; startPointRight = length; endPointRight = 0; indexLeft = 0; indexRight = 0;
        }
        for(int j = 0; j < length; ++j)
            System.out.print("_");
        System.out.println();
    }
    
    /**
     * Prints the street view from the right side
     * @param structures structures in the street
     */
    public void printRight(StructureContainer structures)
    {
        int startPointLeft = length, endPointLeft = 0, startPointRight = length, endPointRight = 0, indexLeft = 0, indexRight = 0;
        
        for(int i = height - 1; i >= 0; --i)
        {
            for(int j = 0; j < length; ++j)
            {
                for(int k = 0; k < structures.getLeftSize(); ++k)
                {
                    if(structures.getElementLeft(k).startPoint == j)
                    {
                        //System.out.println(j);
                        startPointLeft = structures.getElementLeft(k).startPoint;
                        endPointLeft = structures.getElementLeft(k).endPoint;
                        indexLeft = k;                      
                        break;
                    }
                }
                
                for(int k = 0; k < structures.getRightSize(); ++k)
                {
                    if(structures.getElementRight(k).startPoint == j)
                    {
                        startPointRight = structures.getElementRight(k).startPoint;
                        endPointRight = structures.getElementRight(k).endPoint;
                        indexRight = k;                   
                       break;
                    }
                }
                
                try
                {
                    if((j == startPointRight || j == endPointRight) && rightSide[i][j])
                        System.out.print("|");              
                    else if(i == structures.getElementRight(indexRight).getHeight() - 1 && rightSide[i][j])
                        System.out.print("-");
                    else if((j == startPointLeft || j == endPointLeft) && !rightSide[i][j] && leftSide[i][j])
                        System.out.print("|");
                    else if(i == structures.getElementLeft(indexLeft).getHeight() - 1 && !rightSide[i][j] && leftSide[i][j])
                        System.out.print("-");
                    else
                        System.out.print(" ");
                }
                catch(NullPointerException x)
                {
                    try
                    {
                        if((j == startPointLeft || j == endPointLeft) && !rightSide[i][j] && leftSide[i][j])
                            System.out.print("|");
                        else if(i == structures.getElementLeft(indexLeft).getHeight() - 1 && !rightSide[i][j] && leftSide[i][j])
                            System.out.print("-");
                        else
                            System.out.print(" ");
                    }
                    catch(NullPointerException y)
                    {
                        System.out.print(" ");
                    }            
                }
                              
            }
            System.out.println();
            startPointLeft = length; endPointLeft = 0; startPointRight = length; endPointRight = 0; indexLeft = 0; indexRight = 0;
        }
        for(int j = 0; j < length; ++j)
            System.out.print("_");
        System.out.println();
    }
    
    /**
     * Prints the silhouette view of the street
     * @param structures structures in the street
     */
    public void printSilhouette(StructureContainer structures)
    {
        int startPointLeft = length, endPointLeft = 0, startPointRight = length, endPointRight = 0, indexLeft = 0, indexRight = 0;
        
        for(int i = height - 1; i >= 0; --i)
        {
            for(int j = 0; j < length; ++j)
            {
                for(int k = 0; k < structures.getLeftSize(); ++k)
                {
                    if(structures.getElementLeft(k).startPoint == j)
                    {
                        //System.out.println(j);
                        startPointLeft = structures.getElementLeft(k).startPoint;
                        endPointLeft = structures.getElementLeft(k).endPoint;
                        indexLeft = k;                      
                        break;
                    }
                }
                
                for(int k = 0; k < structures.getRightSize(); ++k)
                {
                    if(structures.getElementRight(k).startPoint == j)
                    {
                        startPointRight = structures.getElementRight(k).startPoint;
                        endPointRight = structures.getElementRight(k).endPoint;
                        indexRight = k;                   
                       break;
                    }
                }
                
                try
                {
                    if((j == startPointLeft || j == endPointLeft) && leftSide[i][j] && !rightSide[i][j])
                        System.out.print("|");              
                    else if(i == structures.getElementLeft(indexLeft).getHeight() - 1 && leftSide[i][j] && !rightSide[i][j])
                        System.out.print("-");
                    else if((j == startPointLeft || j == endPointLeft) && (j == startPointRight || j == endPointRight) && 
                            (leftSide[i][j] || rightSide[i][j]))
                        System.out.print("|");
                    else if(i == structures.getElementLeft(indexLeft).getHeight() - 1 && i == structures.getElementRight(indexRight).getHeight() - 1
                            && (leftSide[i][j] || rightSide[i][j]))
                        System.out.print("-");
                    else if((j == startPointRight || j == endPointRight) && !leftSide[i][j] && rightSide[i][j])
                        System.out.print("|");
                    else if(i == structures.getElementRight(indexRight).getHeight() - 1 && !leftSide[i][j] && rightSide[i][j])
                        System.out.print("-");
                    else
                        System.out.print(" ");
                }
                catch(NullPointerException x)
                {
                    try
                    {
                        if((j == startPointLeft || j == endPointLeft) && (j == startPointRight || j == endPointRight) && 
                            (leftSide[i][j] || rightSide[i][j]))
                            System.out.print("|");
                        else if((j == startPointRight || j == endPointRight) && !leftSide[i][j] && rightSide[i][j])
                            System.out.print("|");
                        else if(i == structures.getElementRight(indexRight).getHeight() - 1 && !leftSide[i][j] && rightSide[i][j])
                            System.out.print("-");
                        else
                            System.out.print(" ");
                    }
                    catch(NullPointerException y)
                    {
                        System.out.print(" ");
                    }
                    
                }
                              
            }
            System.out.println();
            startPointLeft = length; endPointLeft = 0; startPointRight = length; endPointRight = 0; indexLeft = 0; indexRight = 0;
        }
        for(int j = 0; j < length; ++j)
            System.out.print("_");
        System.out.println();
    }
    
    /**
     * Returns the total length that is available to build upon it at the left side of the street
     * @return total available space at the left side of the street
     */
    public int totalRemainingLengthLeft()
    {
        int totalRemainingLengthLeft = 0;
        for(int j = 0; j < length; ++j)
        {
            if(!leftSide[0][j])
                ++totalRemainingLengthLeft;
        }
        return totalRemainingLengthLeft;
    }
    
    /**
     * Returns the total length that is available to build upon it at the right side of the street
     * @return total available space at the right side of the street
     */
    public int totalRemainingLengthRight()
    {
        int totalRemainingLengthRight = 0;
        for(int j = 0; j < length; ++j)
        {
            if(!rightSide[0][j])
                ++totalRemainingLengthRight;
        }
        return totalRemainingLengthRight;
    }
    
    private boolean[][] leftSide;
    private boolean[][] rightSide;
    private int length;
    private int height;
}
