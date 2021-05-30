

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LnkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LnkedListTest
{
    private LnkedList<Integer> list;
    
    /**
     * Default constructor for test class LnkedListTest
     */
    public LnkedListTest()
    {
        list = new LnkedList<>();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {   // add() adds to the front
        list.add(12); list.add(52); list.add(62); list.add(1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        list = null;
    }
    
    @Test
    public void justChecking() {
        assertTrue(true);
    }
    
    @Test
    public void testAdd() {
        assertTrue(list.size() == 4);
    }
    
    @Test
    public void testAddFirst() {
        list.addFirst(55);
        assertTrue(list.get(0) == 55);
    }
    
    @Test
    public void testAddFirstSize() {
        list.addFirst(55);
        assertTrue(list.size() == 5);
    }
    
    @Test
    public void testGetFirst() {
        int x = list.get(0);
        assertTrue(x == 1);
    }
    
    @Test
    public void testGetLast() {
        int x = list.get(3);
        assertTrue(x == 12);
    }
    
    @Test
    public void testRemoveFirst() {
        int x = list.removeFirst();
        assertTrue(x == 1);
        assertTrue(list.size() == 3);
    }
    
    
    
    
    
    
}
