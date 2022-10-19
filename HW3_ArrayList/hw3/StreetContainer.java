package hw3;

import java.util.ArrayList;

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
        leftSide = new ArrayList<ArrayList<Boolean>>();
        rightSide = new ArrayList<ArrayList<Boolean>>();
    }
    
    /**
     * Constructor that takes length value as input
     * @param toLength value to be the length of both leftSide and rightSide
     */
    public StreetContainer(int toLength)
    {
        length = toLength;
        height = 1;
        leftSide = new ArrayList<ArrayList<Boolean>>();
        rightSide = new ArrayList<ArrayList<Boolean>>();
        
        for(int i = 0; i < length; ++i)
        {
            leftSide.add(new ArrayList<Boolean>());
            leftSide.get(i).add(false);
        }
        for(int i = 0; i < length; ++i)
        {
            rightSide.add(new ArrayList<Boolean>());
            rightSide.get(i).add(false);
        }
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
        
        
        if(addLength <= length)
        {
            int counter = 0;
            
            // finds the first empty spaces that can be filled up with the given structure at the left side of the street then saves these informations
            for(int i = 0; i < length; ++i) 
            {
                if(!leftSide.get(i).get(0))
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
                        if(i == 0)
                            leftSide.get(j).set(i, true);
                        else
                            leftSide.get(j).add(true);
                    }
                }
                if(height < addHeight) // sets the height if the new added structure is taller than the others
                    height = addHeight;
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
         
        if(startPoint + addLength <= length)
        {            
            int counter = 0;
            
            // finds the first empty spaces that can be filled up with the given structure at the left side of the street then saves these informations
            for(int i = startPoint; i < length; ++i) 
            {
                if(!leftSide.get(i).get(0))
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
                        if(i == 0)
                            leftSide.get(j).set(i, true);
                        else
                            leftSide.get(j).add(true);
                    }
                }
                if(height < addHeight) // sets the height if the new added structure is taller than the others
                    height = addHeight;
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
        
        if(addLength <= length)
        {
            int counter = 0;
            
            // finds the first empty spaces that can be filled up with the given structure at the left side of the street then saves these informations
            for(int i = 0; i < length; ++i) 
            {
                if(!rightSide.get(i).get(0))
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
                        if(i == 0)
                            rightSide.get(j).set(i, true);
                        else
                            rightSide.get(j).add(true);
                    }
                }
                if(height < addHeight) // sets the height if the new added structure is taller than the others
                    height = addHeight;
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
       
        if(startPoint + addLength <= length)
        {
            int counter = 0;
            
            // finds the first empty spaces that can be filled up with the given structure at the left side of the street then saves these informations
            for(int i = startPoint; i < length; ++i) 
            {
                if(!rightSide.get(i).get(0))
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
                        if(i == 0)
                            rightSide.get(j).set(i, true);
                        else
                            rightSide.get(j).add(true);
                    }
                }
                if(height < addHeight) // sets the height if the new added structure is taller than the others
                    height = addHeight;
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
                leftSide.get(j).set(i, false);
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
                rightSide.get(j).set(i, false);
            }
        }
    }
   
    /**
     * Prints the silhouette view of the street
     */
    public void printSilhouette()
    {
        ArrayList<ArrayList<Boolean>> silhouetteContainer = new ArrayList<ArrayList<Boolean>>();
        
        for(int j = 0; j < length; ++j)
        {
            silhouetteContainer.add(new ArrayList<Boolean>());
            if(leftSide.get(j).size() < height)
            {
                for(int i = 0; i < leftSide.get(j).size(); i++)
                    silhouetteContainer.get(j).add(i, leftSide.get(j).get(i));
                for(int i = leftSide.get(j).size(); i < height; i++)
                    silhouetteContainer.get(j).add(i, false);
            }
            else
            {
                for(int i = 0; i < height; i++)
                    silhouetteContainer.get(j).add(i, leftSide.get(j).get(i));
            }
            
            if(rightSide.get(j).size() < height)
            {
                for(int i = 0; i < rightSide.get(j).size(); i++)
                {
                    if(!silhouetteContainer.get(j).get(i))
                        silhouetteContainer.get(j).set(i, rightSide.get(j).get(i));
                }
            }
            else
            {
                for(int i = 0; i < height; i++)
                {
                    if(!silhouetteContainer.get(j).get(i))
                        silhouetteContainer.get(j).set(i, rightSide.get(j).get(i));
                }
            }
        }
        
     
        for(int i = height - 1; i >= 0; --i)
        {
            for(int j = 0; j < length; ++j)
            {
                if(j == 0 && silhouetteContainer.get(j).get(i))
                    System.out.print("|");
                else if(j == length - 1 && silhouetteContainer.get(j).get(i))
                    System.out.print("|");
                else if(silhouetteContainer.get(j).get(i) && (!silhouetteContainer.get(j - 1).get(i) || 
                        !silhouetteContainer.get(j + 1).get(i)))
                    System.out.print("|");
                else if(i == height - 1 && silhouetteContainer.get(j).get(i))
                    System.out.print("-");
                else if(silhouetteContainer.get(j).get(i) && !silhouetteContainer.get(j).get(i + 1))
                    System.out.print("-");
                else
                    System.out.print(" ");
            }
            System.out.println();
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
            if(!leftSide.get(j).get(0))
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
            if(!rightSide.get(j).get(0))
                ++totalRemainingLengthRight;
        }
        return totalRemainingLengthRight;
    }
    
    private ArrayList<ArrayList<Boolean>> leftSide;
    private ArrayList<ArrayList<Boolean>> rightSide;
    private int length;
    private int height;
}
