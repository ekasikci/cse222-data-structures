package hw7;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Ertugrul Kasikci
 */
public class HW7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinaryTree<Integer> binaryTree1 = new BinaryTree<Integer>(2,  new BinaryTree<Integer>(5,  new BinaryTree<Integer>(1, null, null),  new BinaryTree<Integer>(9, null, null)),
        new BinaryTree<Integer>(8,  new BinaryTree<Integer>(7, null, null),  new BinaryTree<Integer>(6, null, null)));
        
        BinaryTree<Integer> binaryTree2 = new BinaryTree<Integer>(7,  new BinaryTree<Integer>(2,  new BinaryTree<Integer>(1, null, null),  new BinaryTree<Integer>(4, null, null)),
        new BinaryTree<Integer>(6,  new BinaryTree<Integer>(5, null, null), null));
        
        BinaryTree<Integer> binaryTree3 = new BinaryTree<Integer>(11,  new BinaryTree<Integer>(5,  new BinaryTree<Integer>(4, null, null),  new BinaryTree<Integer>(2, null, null)),
        new BinaryTree<Integer>(7,  new BinaryTree<Integer>(1, null, null),  new BinaryTree<Integer>(8, new BinaryTree<Integer>(13, null, null), null)));
        
        BinarySearchTree<Integer> binarySearchTree1 = new BinarySearchTree<Integer>();
        BinarySearchTree<Integer> binarySearchTree2 = new BinarySearchTree<Integer>();
        BinarySearchTree<Integer> binarySearchTree3 = new BinarySearchTree<Integer>();
        
        Integer[] array1 = new Integer[]{2, 5, 1, 9, 8, 7, 6}; // An array contains the elements of the BinaryTree1
        Integer[] array2 = new Integer[]{7, 2, 1, 4, 6, 5}; // An array contains the elements of the BinaryTree2
        Integer[] array3 = new Integer[]{11, 5, 4, 2, 7, 1, 8, 13}; // An array contains the elements of the BinaryTree3
        
        Random rand = new Random();
        
        
        for(int i = 0; i < 5; i++)
            binarySearchTree1.add(rand.nextInt(100));
        
        for(int i = 0; i < 7; i++)
            binarySearchTree2.add(rand.nextInt(100));
        
        for(int i = 0; i < 9; i++)
            binarySearchTree3.add(rand.nextInt(100));
        
        System.out.println("1. BinaryTree:\n");       
        System.out.println(binaryTree1.toString());
        System.out.println("1. BinaryTree to BinarySeachTree:\n"); 
        System.out.println(ReturnBST(binaryTree1, array1).toString());
        
        System.out.println("2. BinaryTree:\n");       
        System.out.println(binaryTree2.toString());
        System.out.println("2. BinaryTree to BinarySeachTree:\n"); 
        System.out.println(ReturnBST(binaryTree2, array2).toString());
        
        System.out.println("3. BinaryTree:\n");       
        System.out.println(binaryTree3.toString());
        System.out.println("3. BinaryTree to BinarySeachTree:\n"); 
        System.out.println(ReturnBST(binaryTree3, array3).toString());
        
        System.out.println("1. BinarySeachTree:\n");
        System.out.println(binarySearchTree1.toString());
        System.out.println("1. BinarySeachTree to AVL tree:\n");
        System.out.println(ReturnAVLTree(binarySearchTree1).toString());
        
        System.out.println("2. BinarySeachTree:\n");
        System.out.println(binarySearchTree2.toString());
        System.out.println("2. BinarySeachTree to AVL tree:\n");
        System.out.println(ReturnAVLTree(binarySearchTree2).toString());
        
        System.out.println("3. BinarySeachTree:\n");
        System.out.println(binarySearchTree3.toString());
        System.out.println("3. BinarySeachTree to AVL tree:\n");
        System.out.println(ReturnAVLTree(binarySearchTree3).toString());
    }
    
    /**
     * Sorts the elements of the array then passes them to the tree by calling inOrderTraverse
     * @param <E> Comparable type
     * @param tree BinaryTree to be convert into a BinarySearchTree
     * @param array Array which has the same elements with tree
     * @return Sorted BinaryTree which means BinarySearchTree
     */
    public static <E> BinaryTree ReturnBST(BinaryTree tree, Comparable<E>[] array)
    {
        Arrays.sort(array);    
        inOrderTraverse (tree, array, 0);
        return tree;
    }
    
    /**
     * Does inorder traverse recursively and passes the element of the array to the 
     * @param <E> Comparable type
     * @param tree BinaryTree to be convert into a BinarySearchTree
     * @param array Array which has the same elements with tree
     * @param index Keeps track of the array
     * @return index value determines which element is going to be used
     */
    private static <E> int inOrderTraverse (BinaryTree tree, Comparable<E>[] array, int index){
        
        if(tree == null)
            return index;
        index = inOrderTraverse(tree.getLeftSubtree(), array, index);
        tree.setData(array[index++]);
        index = inOrderTraverse(tree.getRightSubtree(), array, index);

        return index;
    }
    
    /**
     * Takes BinarySearchTree and returns AVL tree
     * @param <E> Comparable type
     * @param tree BinarySearchTree to be convert into a AVL tree
     * @return Balanced BinarySearchTree which means AVL tree
     */
    public static <E extends Comparable<E>> BinaryTree<E> ReturnAVLTree(BinaryTree<E> tree)
    {
        if(tree == null)
            return tree;
        ReturnAVLTreeHelper(tree.getLeftSubtree());
        ReturnAVLTreeHelper(tree.getRightSubtree());
        ReturnAVLTreeHelper(tree);
        ReturnAVLTree(tree.getLeftSubtree());
        ReturnAVLTree(tree.getRightSubtree());
        return tree;
    }
    
    /**
     * Implements rotations according to unbalance cases
     * @param <E> Comparable type
     * @param tree BinarySearchTree to be convert into a AVL tree
     */
    private static <E extends Comparable<E>> void ReturnAVLTreeHelper(BinaryTree<E> tree)
    {
        int result;
        
        if(tree == null)
            return;
        
        if(tree.getLeftSubtree() == null)
        {
            if(tree.getRightSubtree() != null)
            {
                result = GetHeight(tree.getRightSubtree());
                if(result > 1)
                    LeftRotate(tree);
            }
            return;
        }
        
        if(tree.getRightSubtree() == null)
        {
            if(tree.getLeftSubtree() != null)
            {
                result = GetHeight(tree.getLeftSubtree());
                if(result > 1)
                    RightRotate(tree);
            }
            return;
        }
        
        
        result = GetHeight(tree.getRightSubtree()) - GetHeight(tree.getLeftSubtree());
        if(result > 1)
        {
            result = GetHeight(tree.getRightSubtree().getRightSubtree()) - GetHeight(tree.getRightSubtree().getLeftSubtree());
            if(result > 0)
                LeftRotate(tree);
            else
            {
                RightRotate(tree.getRightSubtree());
                LeftRotate(tree);
            }
        }
        else if(result < -1)
        {
            result = GetHeight(tree.getLeftSubtree().getRightSubtree()) - GetHeight(tree.getLeftSubtree().getLeftSubtree());
            if(result > 0)
            {
                LeftRotate(tree.getLeftSubtree());
                RightRotate(tree);
            }
            else
                RightRotate(tree);
        }
    }
    
    /**
     * Takes a BinaryTree and returns its height
     * @param <E> Comparable type
     * @param tree BinaryTree which height of it is going to be calculated
     * @return Height of tree
     */
    private static <E extends Comparable<E>> int GetHeight(BinaryTree<E> tree)
    {
     
        if(tree == null)
            return 0;
        int left = GetHeight(tree.getLeftSubtree());
        int right = GetHeight(tree.getRightSubtree());

        if(left > right) 
            return left + 1;
        return right + 1;    
    }
    
    /**
     * Takes a BinaryTree and implements right rotation on its root node
     * @param <E> Comparable type
     * @param tree BinaryTree which the rotation is going to be implemented on it
     */
    private static <E extends Comparable<E>> void RightRotate(BinaryTree<E> tree)
    {    
        var leftLeft = tree.root.left.left;
        var left = tree.root.left;
        
        left.left = left.right;
        left.right = tree.root.right;
        
        tree.root.right = left;
        tree.root.left = leftLeft;
        
        E temp = tree.root.data;
        tree.root.data = left.data;
        left.data = temp;   
    }
    
    /**
     * Takes a BinaryTree and implements left rotation on its root node
     * @param <E> Comparable type
     * @param tree BinaryTree which the rotation is going to be implemented on it
     */
    private static <E extends Comparable<E>> void LeftRotate(BinaryTree<E> tree)
    {
        var rightRight = tree.root.right.right;
        var right = tree.root.right;
        
        
        right.right = right.left;
        right.left = tree.root.left;
        
        tree.root.left = right;
        tree.root.right = rightRight;
        
        E temp = tree.root.data;
        tree.root.data = right.data;
        right.data = temp;      
    }
}