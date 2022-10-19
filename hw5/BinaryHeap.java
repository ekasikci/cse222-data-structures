package hw5;

/**
 *
 * @author Ertugrul Kasikci
 */
public class BinaryHeap<E> extends BinaryTree<E> {
    
    /**
     * default constructor
     */
    public BinaryHeap(){ super(); }
    
    
    /**
     * contructor which takes one Node parameter which is going to be the root
     * @param root Node which is going to be the root
     */
    public BinaryHeap(Node<E> root){ super(root); }

    /**
     * Adds one item to the binary heap
     * @param data item to be added
     * @return true as long as memory has space to hold it otherwise false
     */
    public boolean insert(E data)
    {   
        Node<E> temp = setLNH(root);
        if(temp == null)
        { 
            root = new Node<E>(data);       
            return true;
        }
        if(temp.left == null)
        {
            temp.left = new Node<E>(data);
            temp.left.up = temp;
            temp = temp.left;
        }
        else
        {
            temp.right = new Node<E>(data);
            temp.right.up = temp;
            temp = temp.right;
        }
        
        while(temp.up != null)
        {
            if(((Comparable<E>)temp.data).compareTo(temp.up.data) < 0)
            {
                swap(temp, temp.up);
                temp = temp.up;
            }
            else
                break;
        }
        
        return true;
    }
    
    /**
     * Merges the binary heap with given parameter tree
     * @param tree parameter to be merged with BinaryHeap
     */
    public void merge(BinaryHeap<E> tree)
    {
        mergeHelper(tree.root);
    }
    
    /**
     * Does pre order traverse and takes every node then inserts them to the binary heap
     * @param tree root node of the tree to be merged
     */
    private void mergeHelper(Node<E> tree)
    {
        if (tree == null)
            return;
        insert(tree.data) ;
        mergeHelper(tree.left);
        mergeHelper(tree.right);
    }
        
    
    /**
     * Finds last added item in the binary heap
     * @param tree Root of the tree to be searched for last item
     * @return last item added
     */
    private Node<E> setLIH(Node<E> tree)
    {
        Node<E> temp = setLNH(tree);
        if(temp == temp.up.right)
            return temp.up.left;
        else
        while(temp.up.left == temp)
        {
            temp = temp.up;
            if(temp.up == null) // means that tree is perfect binary tree so the function must return the rightmost node
            {
                while(temp.right != null)
                    temp = temp.right;
                return temp;
            }
        }
        temp = temp.up.left;
        while(temp.right != null)
            temp = temp.right;
        return temp;
    }
    
    /**
     * Returns last node has null branch in the binary heap which is going to be used when adding an item
     * @param tree Root of the tree to be searched for last null node
     * @return node has null branch was found
     */
    private Node<E> setLNH(Node<E> tree)
    {
        if(tree == null)
            return tree;
        if(tree.left != null && tree.right != null)
        {
           int leftHeight = 0, rightHeight = 0, middleHeight = 0;
           Node<E> temp = tree;
            while(temp.left != null)
            {
                temp = temp.left;
                leftHeight++;
            }
            temp = tree;
            while(temp.right != null)
            {
                temp = temp.right;
                rightHeight++;
            }
            temp = tree;
            while(temp.left != null)
            {
                middleHeight++;

                if(middleHeight %2 == 0)
                    temp = temp.right;
                else    
                    temp = temp.left;
                if(temp == null)
                {
                    middleHeight--;
                    break;
                }
            }
            if(leftHeight == rightHeight)
                return setLNH(tree.left);
            else if(leftHeight > rightHeight && leftHeight == middleHeight)
                return setLNH(tree.right);
            else
                return setLNH(tree.left);            
        }
        return tree;
    }
    
    /**
     * Removes the last item from the binary heap
     * @return data of the removed Node if it exist otherwise null
     */
    public E remove()
    {
        Node<E> temp = root;
        Node<E> LIH = setLIH(root);
        if(temp == null)
            return null;
        swap(temp, LIH);
        
        while(true)
        {
            Node<E> smallBranch = getSmallBranch(temp);
            if(smallBranch == null)
                break;
            if(((Comparable<E>) smallBranch.data).compareTo(temp.data) < 0)
            {
                swap(temp, smallBranch);
                temp = smallBranch;
            }
            else
                break;
        }
        if(LIH.up.left == LIH)
            LIH.up.left = null;
        else
            LIH.up.right = null;
        
        return temp.data;
    }
    
    /**
     * Swaps the datas of x and y
     * @param x first Node to be swapt
     * @param y second Node to be swapt
     */
    private void swap(Node<E> x, Node<E> y)
    {
        E temp = y.data;
        y.data = x.data;
        x.data = temp;
    }
    
    /**
     * Takes one Node as a parameter and returns small branch of it
     * @param x node which small branch is to be returned
     * @return small branch of x
     */
    private Node<E> getSmallBranch(Node<E> x)
    {
        if(x.left == null && x.right != null)
            return x.right;
        else if(x.left != null && x.right == null)
            return x.left;
        else if(x.left == null && x.right == null)
            return null;
        
        if(((Comparable<E>) x.left.data).compareTo(x.right.data) < 0)
            return x.left;
        return x.right;
    }
            
    
    protected static class Node<E> extends BinaryTree.Node<E>{
        protected Node<E> up;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {
            super(data);
            up = null;
        }
        public String toString() { return data.toString(); }
    }
    
    /**
     * @return readable version of the current tree
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }
    
    /**
     * Creates a readable version of the tree array
     * @param node root of the tree
     * @param depth depth of the current node
     * @param sb StringBuilder variable
     */
    private void preOrderTraverse (Node<E> node, int depth, StringBuilder sb){
        for (int i = 1; i < depth; i++)
            sb.append("  "); // indentation
        if (node == null)
        sb.append("null\n");
        else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
    
    private Node<E> root;
}
