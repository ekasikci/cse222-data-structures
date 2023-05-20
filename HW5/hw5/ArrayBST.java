package hw5;

import java.util.ArrayList;

/**
 *
 * @author Ertugrul Kasikci
 */
public class ArrayBST<E> implements SearchTree<E>{
    
    /**
     * Default constructor
     */
    public ArrayBST() { binarySearchTree = new ArrayList<E>(); }
    
    /**
     * Takes one item as root of the tree
     * @param item root of the tree
     */
    public ArrayBST(E item) { 
        binarySearchTree = new ArrayList<E>(); 
        binarySearchTree.add(0, item);
    }
    
    /**
     * Tries to add item to the tree.
     * @param item to be add to the tree
     * @return true if it adds otherwise false
     */
    @Override
    public boolean add(E item) {
        int index = 0;
        try
        {
            while(binarySearchTree.get(index) != null)
            {
                if(((Comparable<E>) binarySearchTree.get(index)).compareTo(item) < 0)
                    index = 2*index + 2;
                else if(((Comparable<E>) binarySearchTree.get(index)).compareTo(item) > 0)
                    index = 2*index + 1;
                else
                    return  false;
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            if(binarySearchTree.size() <= index)
            {
                for(int i = binarySearchTree.size(); i <= index; i++)
                    binarySearchTree.add(i, null);
            }
        }
        binarySearchTree.set(index, item);
        return true; 
        
    }

    /**
     * checks if target is in the tree
     * @param target element to be searched
     * @return true if the tree contains target otherwise false
     */
    @Override
    public boolean contains(E target) { return searchedIndex(target) != -1; }

    /**
     * checks if target is in the tree
     * @param target element to be searched
     * @return target if the tree contains target otherwise null
     */
    @Override
    public E find(E target) {
        int index = searchedIndex(target);
        if(index == -1)
            return null;
        return binarySearchTree.get(index);
    }

    /**
     * deletes target from the tree
     * @param target element to be deleted
     * @return target if deletion is successful otherwise null
     */
    @Override
    public E delete(E target) {
        if(remove(target))
            return target;
        return null;
    }

    /**
     * removes target from the tree
     * @param target element to be removed
     * @return true if removal is successful otherwise false
     */
    @Override
    public boolean remove(E target){ 
        int index = searchedIndex(target);
        int targetValIndex;
        if (index == -1)
            return false;
        try
        {
            if(binarySearchTree.get(index*2 + 1) != null)
            {
                targetValIndex = max(index*2 + 1);
                binarySearchTree.set(index, binarySearchTree.get(targetValIndex));
                binarySearchTree.set(targetValIndex, null);
            }
            else if(binarySearchTree.get(index*2 + 2) != null)
            {        
                targetValIndex = min(index*2 + 2);
                binarySearchTree.set(index, binarySearchTree.get(targetValIndex));
                binarySearchTree.set(targetValIndex, null);

            }
            else 
                binarySearchTree.set(index, null);
        }
        catch(IndexOutOfBoundsException e)
        {
            binarySearchTree.set(index, null);
        }
        
        return true;
    }
    
    /**
     * @return readable version of the current tree
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(binarySearchTree.get(0), 1, sb, 0);
        return sb.toString();
    }
    
    /**
     * finds min value after index (a branch of the tree)
     * @param index root of the searched branch
     * @return index of the min value
     */
    private int min(int index)
    {
        try
        {
            if(binarySearchTree.get(index   ) == null)
                return -1;
            while(binarySearchTree.get(index*2 + 1) != null)
                index = 2*index + 1;
        }
        catch(IndexOutOfBoundsException e)
        {
            return index;
        }
        return index;
    }
    
    /**
     * finds max value after index (a branch of the tree)
     * @param index root of the searched branch
     * @return index of the max value
     */
    private int max(int index)
    {
        if(binarySearchTree.get(index) == null)
            return -1;
        while(binarySearchTree.get(index*2 + 2) != null)
            index = 2*index + 2;
        return index;
    }
    
    /**
     * searches to find if the target is in the tree
     * @param target element to be searched
     * @return index value of the target if it finds otherwise -1
     */
    private int searchedIndex(E target){
        int index = 0;
        while(binarySearchTree.get(index) != target)
        {
            if(((Comparable<E>) binarySearchTree.get(index)).compareTo(target) < 0)
                index = 2*index + 2;
            else
                index = 2*index + 1;

            if(binarySearchTree.get(index) == null)
                return -1;
        }
        return index;
    }
    
    /**
     * Creates a readable version of the tree array
     * @param node root of the tree
     * @param depth depth of the current node
     * @param sb StringBuilder variable
     * @param index current node index
     */
    private void preOrderTraverse(E node, int depth, StringBuilder sb, int index) {
        for (int i = 1; i < depth; i++)
            sb.append(" ");
        
        if (node == null)
            sb.append("null\n");
        else 
        {
            sb.append(node.toString());
            sb.append("\n");
            try
            {
                preOrderTraverse(binarySearchTree.get(2*index + 1), depth + 1, sb, 2*index + 1);
            }
            catch(IndexOutOfBoundsException e)
            {
            }
            
            try
            {
                preOrderTraverse(binarySearchTree.get(2*index + 2), depth + 1, sb, 2*index + 2);
            }
            catch(IndexOutOfBoundsException e)
            {
            }
        }
    }
    
    private ArrayList<E> binarySearchTree;
   
}
