package ceLinearBinary;

import java.util.Arrays;

/**
 * class Test Client includes the main metho for this CE
 * creates an array of integers, and an array of type Point
 * Includes binary Searches for various different examples
 */
public class TestClient {

	/**
	 * main method of this application
	 * @param args placeholder params - unused
	 */
	public static void main(String[] args) {
		final int[] intArray = {1, 3, 5, 7, 9};
		
		Point point1 = new Point(2, 4);
		Point point2 = new Point(5, 7);
		Point point3 = new Point(3, 1);
		Point point4 = new Point(7, 0);
		Point point5 = new Point(5, 3);
		Point point6 = new Point(6, 9);
		Point point7 = new Point(2, 1);
		
		final Point[] pointArray = {point1, point2, point3, point4, point5, point6, point7};
		
		int pointIndex = Search.linear(pointArray, point2);
		
		System.out.println("point search for (5, 7) : " + pointIndex);
		
		System.out.println();
		
		Arrays.sort(pointArray);
		
		int binarySearch = Search.binary(pointArray, point5);
		System.out.println("Search.binary(pointArray, (5, 3)): " + binarySearch);
		
        String[] stringArray = {"ape", "bee", "cow", "doe", "eel"};
        int stringSearchIndex = Search.binary(stringArray, "ape");
        System.out.println("Search.binary(stringArray, \"ape\"): " + stringSearchIndex);
		
		System.out.println("Search.binary(array, 5): " + Search.binary(intArray, 5));
		System.out.println("Search.binary(array, 1): " + Search.binary(intArray, 1));
		System.out.println("Search.binary(array, 3): " + Search.binary(intArray, 3));
		System.out.println("Search.binary(array, 9): " + Search.binary(intArray, 9));
	}
	
}
