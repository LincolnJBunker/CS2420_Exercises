package ceLinked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//= = = = = This Class Must Not Be Modified = = = = =

class WordListTest {
    private WordList list;
    private WordList list3;

    @BeforeEach
    void setUp() {
    	list = new WordList();
    	
    	list3 = new WordList();
    	list3.append("Brasil");
    	list3.append("Canada");
    	list3.append("Egypt");
    }
    
    // = = = prepend = = = 

    @Test
    void prepend_nonEmpty() {
        list.append("Canada");
    	list.append("Egypt");
        list.prepend("Brasil");

        assertEquals(3, list.size());
        assertEquals("Brasil Canada Egypt ", list.toString());
    }

    @Test
    void prepend_empty() {
    	list.prepend("France");
    	
        assertEquals(1, list.size());
        assertEquals("France ", list.toString());
    }

    @Test
    void prepend_duplicates() {
        list.prepend("Brasil");
        list.prepend("Brasil");
        list.prepend("Brasil");

        assertEquals(3, list.size());
        assertEquals("Brasil Brasil Brasil ", list.toString());
    }    
    
    @Test
    void prepend_tailUnchangedForNonEmptyList() {
    	list3.prepend("Austria");
    	list3.append("France");
    	
        assertEquals(5, list3.size());
        assertEquals(0, list3.indexOf("Austria")); 
        assertEquals(4, list3.indexOf("France")); 
    }
    
    @Test
    void prepend_tailUpdatedForEmptyList() {
    	list.prepend("Austria");
    	list.append("France");
    	
        assertEquals(2, list.size());
        assertEquals(0, list.indexOf("Austria")); 
        assertEquals(1, list.indexOf("France")); 
    }
    
    // = = = indexOf = = = 
    
    @Test
    void indexOf_existingElement() {
        assertEquals(0, list3.indexOf("Brasil"));
        assertEquals(1, list3.indexOf("Canada"));
        assertEquals(2, list3.indexOf("Egypt"));
    }

    @Test
    void indexOf_elementNotFound() {
        assertEquals(-1, list3.indexOf("France"));
    }

    @Test
    void indexOf_empty() {
        assertEquals(-1, list.indexOf("Brasil"));
    }

    @Test
    void indexOf_duplicates() {
        list.prepend("Brasil");
        list.prepend("Canada");
        list.prepend("Brasil");

    	assertEquals(0, list.indexOf("Brasil"));
    }
    
    @Test
    void indexOf_headUnchanged() {
        assertEquals(-1, list3.indexOf("France")); 
        assertEquals(1, list3.indexOf("Canada")); 
        assertEquals(0, list3.indexOf("Brasil")); 
    }
    
    // = = = contains = = = 
    
    @Test
    void contains_elementFound() {
        assertTrue(list3.contains("Brasil"));
        assertTrue(list3.contains("Canada"));
        assertTrue(list3.contains("Egypt"));
    }

    @Test
    void contains_elementNotFound() {
        assertFalse(list3.contains("France"));
    }

    @Test
    void contains_empty() {
        assertFalse(list.contains("France"));
    }

    @Test
    void contains_duplicates() {
        list.prepend("Brasil");
        list.prepend("Canada");
        list.prepend("Brasil");

        assertTrue(list.contains("Brasil"));
    }
    
    @Test
    void contains_headUnchanged() {
    	assertEquals(-1, list3.indexOf("France")); 
        assertTrue(list3.contains("Canada"));
        assertTrue(list3.contains("Brasil"));
    }
}
