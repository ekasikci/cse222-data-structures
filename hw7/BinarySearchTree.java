package hw7;

/**
 *
 * @author Ertugrul Kasikci
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E> 
{

    @Override
    public boolean add(E item) 
    {
        root = add(root, item);
        return addReturn;
    }
    
    private Node<E> add(Node<E> localRoot, E item) 
    {
        if (localRoot == null) 
        {
            // item is not in the tree — insert it.
            addReturn = true;
            return new Node<>(item);
            } 
        else if (item.compareTo(localRoot.data) == 0) 
        {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } 
        else if (item.compareTo(localRoot.data) < 0) 
        {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } 
        else 
        {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    @Override
    public boolean contains(E target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E find(E target) 
    {
        return find(root, target);
    }   
    
    private E find(Node<E> localRoot, E target) 
    {
        if (localRoot == null)
        return null;
        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
        return localRoot.data;
        else if (compResult < 0)
        return find(localRoot.left, target);
        else
        return find(localRoot.right, target);
    }

    @Override
    public E delete(E target) 
    {
        root = delete(root, target);
        return deleteReturn;
    }
    
    private Node<E> delete(Node<E> localRoot, E item) 
    {
        if (localRoot == null) 
        {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) 
        {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } 
        else if (compResult > 0) 
        {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } 
        else 
        {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) 
            {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } 
            else if (localRoot.right == null) 
            {
            // If there is no right child, return left child.
            return localRoot.left;
            } 
            else 
            {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) 
                {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                else 
                {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    
    private E findLargestChild(Node<E> parent) 
    {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) 
        {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } 
        else 
        {
            return findLargestChild(parent.right);
        }
    }

    @Override
    public boolean remove(E target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    protected boolean addReturn;
    protected E deleteReturn;
}
