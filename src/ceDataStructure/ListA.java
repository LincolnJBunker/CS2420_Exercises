package ceDataStructure;

import java.util.Arrays;

/**
 * class ListA creates an array list given the capacity passed in to its constructor
 * Methods within ListA include checking the size of the list, whether it is empty, and adding an item to the list
 * 
 * @author Lincoln Bunker
 */
public class ListA {
	private int[] items;
	private int n;
	
	/**
	 * Constructor for class ListA
	 * Initalizes the field items by setting the size of it to whatever capacity is
	 * @param capacity specified size of the to-be declared array
	 */
	public ListA(int capacity) {
		items = new int[capacity];
	}
	
	/**
	 * Method to return the size of the list
	 * @return the size of the list
	 */
	public int size() {
		return n;
	}
	
	/**
	 * method to determine whether the list is empty or not
	 * @return true if the list is empty, false if there are items in the list
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * Method to add an element to the items list
	 * Checks to amke sure that the list is not full
	 * If the list is not full, item is added to end of the list
	 * @param item the item to be added
	 */
	public void add(int item) {
		if (n == items.length) {
			throw new IllegalStateException("Cant add elements to a full list");
		}
		items[n++] = item;
	}

	@Override
	public String toString() {
		return "ListA [items=" + Arrays.toString(items) + ", n=" + n + "]";
	}
	
	/* * * * * * * * Test Client * * * * * * */

	public static void main(String[] args) {
	    System.out.println("ListA Test Client");
	    System.out.println("-----------------");
	    
	    ListA list = new ListA(5);
	    printListInfo(list);       
	    System.out.println("The list " 
	                + (list.isEmpty() ? "is" : "is not") + " empty.");
	    System.out.println();
	    
	    list.add(5);
	    printListInfo(list);       
	    System.out.println("The list " 
	                + (list.isEmpty() ? "is" : "is not") + " empty.");
	    System.out.println();
	    
	    list.add(10);
	    list.add(15);
	    list.add(20);
	    list.add(25);
	    printListInfo(list);      
	    System.out.println();
	    
	    // uncomment the next line to trigger an IllegalStateException
	     list.add(35); 
	}

	private static void printListInfo(ListA list) {
		System.out.println("size: " + list.size());
	    System.out.println(list);
	}
	
  }
