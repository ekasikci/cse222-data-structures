package hw3_ldlinkedlist;
import java.util.AbstractList;
import java.util.List;

/**
 *
 * @author msı
 * @param <E>
 */
public class LDLinkedList<E> extends AbstractList<E>  implements List<E> {

    /**
     * default constructor
     */
    public LDLinkedList()
    {
        head = new Node<E>(null);
        size = 0;
    }
    
    /**
     * constructor that takes data value as a parameter
     * @param dataItem data value of the first node 
     */
    public LDLinkedList(E dataItem)
    {
        head = new Node<E>(dataItem);
        size = 1;
    }
    
    /**
     * constructor that takes data value and node as a parameter
     * @param dataItem node comes after the first node
     * @param nextNode data value of the first node
     */
    public LDLinkedList(E dataItem, Node<E> nextNode)
    {
        head = new Node<E>(dataItem, nextNode);
        size = 1;
    }
    
    @Override
    public E get(int index) {
        if(index >= 0 && index <= size)
            return getNode(index).data;
        else return null;
    }

    /**
     * adds item to the end of the list
     * @return true
     */
    @Override
    public int size(){ return size; }
    
    /**
     * @param item to be added and of the list
     * @return return
     */
    @Override
    public boolean add(E item)
    {
        add(size, item);
        return true;
    }
    
    /**
     * adds item to the indicated index
     * @param index indicated the place where item to be add
     * @param item item to be add
     */
    @Override
    public void add(int index, E item)
    {
        if(index >= 0 && index <= size)
        {
            if(index == 0)
                addFirst(item);
            else
            {
                Node<E> node = getNode(index - 1);
                addAfter(node, item);
            }
        }
    }
    
    /**
     * @param item value of the node to be added end of deleted nodes
     * @return true
     */
    private boolean addDeleted(E item)
    {
        addDeleted(sizeDeleted, item);
        return true;
    }
    
    /**
     * @param index value where the node to be added
     * @param item value of the node to be added to the index
     */
    private void addDeleted(int index, E item)
    {
        if(index >= 0 && index <= sizeDeleted)
        {
            if(index == 0)
                removedElementsHead = new Node<E>(item, removedElementsHead);
            else
            {
                Node<E> node = getDeletedNode(index - 1);
                addAfter(node, item);
            }
            sizeDeleted++;
        }
    }
    
    /**
     * changes the value of the variable at the given index with item
     * @param index index value of the item to be set
     * @param item value to be set
     * @return 
     */
    @Override
    public E set(int index, E item)
    {
        if(index >= 0 && index <= size)
        {
            Node<E> node = getNode(index);
            E result = node.data;
            node.data = item;
            return result;
            
        }
        else return null; 
    }
    
    /**
     * @return element at the first node
     */
    public E getFirst()
    {
        return head.data;
    }
    
    /**
     * @return element at the last node
     */
    public E getlast()
    {
        return getNode(size - 1).data;
    }
    
    /**
     * removes last node
     * @return element at the last node
     */
    public E remove()
    {
        Node<E> temp = new Node<E>(removeAfter(getNode(size - 2)));     
        addDeleted(temp.data);
        return temp.data;   
    }
    
    /**
     * @param index index value of the node to be removed
     * @return element at the removed node
     */
    public E remove(int index)
    {
        if(index >= 0 && index <= size)
        {
            Node<E> temp = new Node<E>(removeAfter(getNode(index - 1)));
            addDeleted(temp.data);
            return temp.data;         
        }
        else return null;
        
    }
    
    /**
     * @param o element to search for
     * @return Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     */
    public int indexOf(Object o)
    {
        int i = 0;
        Node<E> node = head;
        while(node != null)
        {
            if(node == o)
                return i;
            node = node.next;
            i++;
        }
        return -1;
    }
    
    /**
     * adds node at the beginning of the list, if exist takes it from deleted nodes
     * @param item data that node going to be added has
     */
    private void addFirst(E item)
    {
        if(lazyDelete(item) != null)
        {
            head = lazyDelete(item).next = head;
            System.out.println("dammnns");
        }
       
        head = new Node<E>(item, head);
        size ++;
    }
    
    /**
     * @param node node which it's following node going to be removed
     * @param item 
     */
    private void addAfter(Node<E> node, E item)
    {
        node.next = new Node<E>(item, node.next);
        size ++;
    }
    
    /**
     * 
     * @param node node which it's following node going to be removed
     * @return data of the removed node. if the node is null returns null
     */
    private E removeAfter(Node<E> node)
    {
        Node<E> temp = node.next;
        
        if(temp != null)
        {
            node.next = temp.next;
            size --;
            temp.next = null;
            return temp.data;
        }
        else
            return null;
    }
    
    /**
     * removes the first node
     * @return data of the removed node. if the node is null returns null
     */
    private E removeFirst()
    {
        Node<E> temp = head;
        
        if(head != null)
        {
            head = head.next;
        }
        
        if(temp != null)
        {
            size--;
            return temp.data;
        }
        else
            return null;
    }
    
    /**
     * @param index where the node is going to be getted
     * @return getted node 
     */
    private Node<E> getNode(int index)
    {
        Node<E> node = head;
        for(int i = 0; i < index && node != null; i++)
            node = node.next;
        return node;
    }
    
    /**
     * uses removedElementsHead as head node
     * @param index where the node is going to be getted
     * @return getted node 
     */
    private Node<E> getDeletedNode(int index)
    {
        Node<E> node = removedElementsHead;
        for(int i = 0; i < index && node != null; i++)
            node = node.next;
        return node;
    }
    
    private static class Node<E>
    {
        Node(E dataItem){ data = dataItem; next = null;}
        Node(E dataItem, Node<E> nodeRef){ data = dataItem; next = nodeRef;}
        
        private E data;
        private Node next;
    }
    
    /**
     * finds a node which contains item and returns it otherwise returns null
     * @param item asked data item
     * @return node contains item
     */
    private Node<E> lazyDelete(E item)
    {
        Node<E> node = removedElementsHead;
        if(node.data == item)
            removedElementsHead = node.next;
        
        for(int i = 0; i < sizeDeleted; i++)
        {
            if(node.next.data == item)
            {
                node.next = node.next.next;
                return node.next;
            }
            node = node.next;
        }
        return null;
    }
    
    private int size, sizeDeleted = 0;
    private Node<E> head = null;
    private Node<E> removedElementsHead = new Node<E>(null);
}
