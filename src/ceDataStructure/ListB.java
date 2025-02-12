package ceDataStructure;

import java.util.NoSuchElementException;

/**
 * class ListB deals with adding an item to the end of a Linked List
 * Methods in the class check the size of the list, whether it is empty, and returns the last item in that list
 * Also has the functionality to add an item to the end of the list.
 * 
 * @author Lincoln Bunker
 */
public class ListB {
	private int n;
	private Node head;
	private Node tail;
	
	/**
	 * Method to return the number of elements in the list
	 * @return the number of elements in the list
	 */
	public int size() {
		return n;
	}
	
	/**
	 * Method to return true/false if the list is empty
	 * @return true if the list is empty, false if it is not
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * Method to return the last item in the list
	 * If the list is empty/null, an exception will be thrown
	 * @return the last element in the list
	 */
	public int lastItem() {
		if (n == 0) {
			throw new NoSuchElementException("There is no last element in an empty list.");
		}
		
		return tail.item;
	}
	
	/**
	 * Method to add a new node at the end of the list
	 * Creates a new node, and sets the item in that node to what newItem is
	 * if the list is empty, the node becomes the head otherwise it becomes the new tail
	 * @param newItem item to be added at the end of the list
	 */
	public void add(int newItem) {
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

	private static class Node {
		private int item;
		private Node next;
	}
	
	/* * * * * * * * Test Client * * * * * * */

	public static void main(String[] args) {
	    System.out.println("ListB Test Client");
	    System.out.println("-----------------");
	    
	    ListB list = new ListB();
	    printListInfo(list);
	    
	    list.add(11);
	    printListInfo(list);
	    
	    list.add(22);
	    printListInfo(list);

	    list.add(33);
	    printListInfo(list);
	    list.add(44);
	    printListInfo(list);
	}

	private static void printListInfo(ListB list) {
	    System.out.println("size: " + list.size());
	    if (list.isEmpty())
	        System.out.println("The list is empty.");
	    else
	        System.out.println("last element : " + list.lastItem());  
	    System.out.println(list);
	    System.out.println();
	}
}
