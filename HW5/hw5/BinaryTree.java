package hw5;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Ertugrul Kasikci
 */
public class BinaryTree<E> {
    
    public BinaryTree() { root = null; }
    protected BinaryTree(Node<E> root) { this.root = root; }
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
        root = new Node<E>(data);
        if (leftTree != null)
            root.left = leftTree.root;
        else
            root.left = null;
        
        if (rightTree != null) 
            root.right = rightTree.root;
        else 
            root.right = null;
    }
    public BinaryTree<E> getLeftSubtree(){
        if (root != null && root.left != null) 
            return new BinaryTree<E>(root.left);
        else 
            return null;
    }
    public BinaryTree<E> getRightSubtree(){
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } 
        else return null;
    }
    public E getData(){ return root.data; }
    public boolean isLeaf() { return (root.left == null && root.right == null); }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }
    
    private void preOrderTraverse (Node<E> node, int depth, StringBuilder sb){
        for (int i = 1; i < depth; i++)
            sb.append(" "); // indentation
        if (node == null)
        sb.append("null\n");
        else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
    
    public static BinaryTree readBinaryTree(Scanner scan){
        String data = scan.next();
        if (data.equals("null"))
            return null;
        else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }
    
    protected static class Node<E> implements Serializable {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        public String toString() { return data.toString(); }
    }
    
    protected Node<E> root;
}
