

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class QSortTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class QSortTest
{
    private int[] nums;
    /**
     * Default constructor for test class QSortTest
     */
    public QSortTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        nums = null;
    }
    
    @Test
    public void testBasic() {
        nums = new int[]{5,4,3,2,1};
        QSort.quickSort(nums, 0, nums.length - 1);
        int[] test = new int[]{1,2,3,4,5};
        assertTrue(arraysEqual(nums, test));
    }
    
    @Test
    public void test1() {
        nums = new int[]{1};
        QSort.quickSort(nums, 0, nums.length - 1);
        int[] test = new int[]{1};
        assertTrue(arraysEqual(nums, test));
    }
    
    @Test
    public void testSorted() {
        nums = new int[]{1,2,3,4,5};
        QSort.quickSort(nums, 0, nums.length - 1);
        int[] test = new int[]{1,2,3,4,5};
        assertTrue(arraysEqual(nums, test));
    }
    
    @Test
    public void testDups() {
        nums = new int[]{1,2,3,4,5,2,1,4};
        QSort.quickSort(nums, 0, nums.length - 1);
        int[] test = new int[]{1,1,2,2,3,4,4,5};
        assertTrue(arraysEqual(nums, test));
    }
    
    private boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        
        return true;
    }
}
