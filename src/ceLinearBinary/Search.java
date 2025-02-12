package ceLinearBinary;

/**
 * The {@code Search} class provides static methods for searching a
 * number {@code n} in an array of whole numbers.
 * 
 * @author CSIS Starter Code + Lincoln Bunker
 *
 */
public class Search {
	/**
	* Searches the array {@code numbers} for the specified
	* {@code n} based on the linear search algorithm.
	*
	* @param numbers array of whole numbers
	* @param n the number that we are looking for
	* @return the index of the first occurrence of {@code n}
	*         in the array or -1 if {@code n} was not found.
	* @throws NullPointerException if {@code numbers} is null.
	*/
	public static int linear(int[] numbers, int n) {
		if (numbers == null) {
			throw new NullPointerException("Input array can't be null!");
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == n) {
				return i;
			}
		}
	   return -1;
	}
	
	/**  
	* Returns the index of the specified key in the specified array.
	*
	* @param a the array of integers, must be sorted in ascending order 
	* @param key the search key  
	* @return index of key in array {@code a} if present; {@code -1} otherwise
	*/
	public static int binary(int[] a, int key) {
	   int lo = 0;
	   int hi = a.length - 1;
	   while (lo <= hi) {
	      int mid = lo + (hi - lo) / 2;
	      if (key < a[mid]) hi = mid - 1;
	      else if (key > a[mid]) lo = mid + 1;
	      else return mid;
	   }
	   return -1;
	}
	
	/**
	* Searches the array {@code numbers} for the specified
	* {@code n} based on the linear search algorithm.
	*
	* @param numbers array of whole numbers
	* @param n the number that we are looking for
	* @return the index of the first occurrence of {@code n}
	*         in the array or -1 if {@code n} was not found.
	* @throws NullPointerException if {@code numbers} is null.
	*/
    public static <T> int linear(T[] array, T key) {
        if (array == null) {
            throw new NullPointerException("Input array can't be null!");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
    
	/**  
	* Returns the index of the specified key in the specified array.
	*
	* @param array the array of integers, must be sorted in ascending order 
	* @param key the search key  
	* @return index of key in array {@code a} if present; {@code -1} otherwise
	*/
    public static <T extends Comparable<T>> int binary(T[] array, T key) {
 	   int lo = 0;
 	   int hi = array.length - 1;
 	   while (lo <= hi) {
 	      int mid = lo + (hi - lo) / 2;
 	      if (key.compareTo(array[mid]) < 0) hi = mid - 1;
 	      else if (key.compareTo(array[mid]) > 0) lo = mid + 1;
 	      else return mid;
 	   }
 	   return -1;
    }
}
