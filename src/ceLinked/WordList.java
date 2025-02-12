package ceLinked;

/**
 * WordList is a singly-linked list of Strings.
 * It is designed as a practice opportunity to
 * learn how to manipulate linked structures.
 * 
 * @author 
 * CS Starter Code + Lincoln Bunker
 */
public class WordList {
    private Node head; // first node of the list or null
    private Node tail; // last node of the list or null
    private int n;     // number of words in the list

    /**
     * Node of LinkedList that stores the item and a
     * single reference to the next node.
     */
    private class Node {
        private String item;
        private Node next;
    }
    
    /** 
     * Adds a node containing the new item at the
     * end of the list.
     * 
     * @param newItem the item to be added to the list
     */
    public void append(String newItem) {
        Node newNode = new Node();
        newNode.item = newItem;
        
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        n++;
    }
    
    /** 
     * Adds a node containing the new item at the
     * front of the list.
     * 
     * @param newItem the item to be added to the list
     */
    public void prepend(String newItem) {        
    	Node newNode = new Node();
    	newNode.next = head; //set newNodes next as the head
    	
    	newNode.item = newItem; //set newNodes item as newItem
    	
    	head = newNode; //set the head equal to newNode
    	
    	if (n == 0) {
    		tail = newNode;
    	}
    	n++;
    	
    }
    
    /** 
     * Returns the index of the first occurrence of the specified item.
     * If the specified item is not part of the list,
     * the method indexOf returns -1.
     * 
     * @param item the item to search for in the list
     * @return the index of the first occurrence of the item; -1 if the item was not found
     */
    public int indexOf(String item) {        
        Node current = head;
        int index = 0;

        while (current != null) { //loop till end of list is met
            if (current.item.equals(item)) {
                return index;  // Found the target, return index
            }
            current = current.next; //if not found, move to the next
            index++; //increment the index
        }

        return -1; // Not found
    }
    
    /** 
     * Checks whether the list contains the given item.
     * 
     * @param item the item to check for in the list
     * @return true if the item is contained in the list; false otherwise
     */
    public boolean contains(String item) {    
        Node current = head;
        
        while (current != null) { //loop till end of list is met
        	if (current.item.equals(item)) {
        		return true; //node containing the string has been found
        	}
        	current = current.next; //if not found, move to next node
        }
        return false; //string not found in any node
    }
    
    /**
     * Returns the number of elements in the list.
     * 
     * @return the number of elements in the list
     */
    public int size() {
        return n;
    }
    
    /** 
     * Determines whether the list is empty or not.
     * 
     * @return true if there are no elements in the list; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        
        while (current != null) {
            sb.append(current.item).append(" ");
            current = current.next;
        }
        
        return sb.toString();
    }
    
    /* * * * * * * * Test Client * * * * * * */

    public static void main(String[] args) {
        // Write test code to verify that the implementations of the methods 
    	// prepend, indexOf, and contains are correct.
    	
    	WordList list = new WordList();
    	
    	System.out.println("!!!!PRINTED LIST!!!!");
    	list.append("Lincoln");
    	list.append("James");
    	list.append("Bunker");
    	
    	System.out.println(list);
    	System.out.println();
    	
    	System.out.println("Prepending Mr. to list...");
    	
    	list.prepend("Mr.");
    	
    	System.out.println("Updated List: " + list);
    	
    	System.out.println("Index of string James: " + list.indexOf("James"));
    	
    	System.out.println();
    	
    	System.out.println("List contains the string Bunker? " + list.contains("Bunker"));
    	System.out.println("List contains the string PythonIsCool? " + list.contains("PythonIsCool"));
    }
}
