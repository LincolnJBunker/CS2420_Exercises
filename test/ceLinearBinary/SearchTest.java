package ceLinearBinary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {
	
	private final int[] linearArray = {5, 8, 12, 15, 18};
	
	@Test
	void linear_targetFound() {
	    int expected = 12;
        int actual = Search.linear(linearArray, expected);

        assertEquals(2, actual, "The target 12 should be found at index 2.");
	}
	
	@Test
	void linear_targetNotFound() {
	    int expected = 2;
		int actual = Search.linear(linearArray, expected);
		
		assertEquals(-1, actual, "2 not found in the array");
	}

	@Test
	void linear_emptyArray() {
		int[] emptyArray = {};
		int expected = 2;
		int actual = Search.linear(emptyArray, expected);
		
		assertEquals(-1, actual, "2 could not be found in an empty array");
	}
	
    @Test
    void linear_nullArray() {
        int[] nullArray = null;
        assertThrows(NullPointerException.class, () -> {
            Search.linear(nullArray, 10);
        }, "Should throw NullPointerException for null array.");
    }
    
    @Test 
    void linear_firstElementMatch() {
    	int expected = 5;
    	int actual = Search.linear(linearArray, expected);
    	assertEquals(0, actual, "The Target 5 should be found at index 0");
    }
	
//	@Test
//	void testBinary() {
//		fail("Not yet implemented");
//	}

}
