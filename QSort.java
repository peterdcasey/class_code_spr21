import java.util.Random;
/**
 * QuickSort Example.
 */
public class QSort
{
    private static final Random rnd = new Random();
    // counter is used to display recursion depth
    private static int counter = 0;
    private static final int MAX_RND_INT = 100;
    private static final int MAX_NUMS = 40;
    private static final int MAX_NUMS_PER_LINE = 15;
    public static final boolean DEBUG = false;
    
    public static void quickSort(int[] data, int left, int right) {
        counter++;
        int mid, tmp, i, j; 
        i = left;
        j = right;
        mid = data[left];  // using the left most value
    
        do {
            if (DEBUG) System.out.println("[" + mid + "] ");
            if (DEBUG) printNums(data, left, right);
            
            while(data[i] < mid)  // look for a bigger (or equal) item
                i++;    // moving to the right
                
            while(data[j] > mid)  // look for a smaller (orequal) item
                j--;    // moving to the right
                
            if (i <= j) {   // did we find values to swap?
                tmp = data[i];   // do swap
                data[i] = data[j];
                data[j] = tmp;
                i++;             // move i and j one more step left / right
                j--;
            }
        } while (i <= j); // while i has not passed j
        
        if (DEBUG) System.out.println("******");
        if (DEBUG) printNums(data, left, right);
        
        if (left < j) {  // are there items from left to j? (sublist?)
            if (DEBUG) System.out.print("[" + "left" + "] ");
            if (DEBUG) printNums(data, left, j);
            quickSort(data,left,j);   // sort this left sublist
        }
        
        if (i < right) {  // are there items from i to right? (sublist?)
            if (DEBUG) System.out.print("[" + "right" + "] ");
            if (DEBUG) printNums(data, i, right);
            quickSort(data,i,right);  // sort this right sublist
        }
    
        counter--;
        if (DEBUG) System.out.println("\n[" + "---" + "] " + counter);
        if (DEBUG) printNums(data, left, right);
    }
    
    /**
     * Print a range of numbers, left to right, in the array.
     * No range checking is done!
     */
    public static void printNums(int[] data, int left, int right) {
        for (int i = left; i <= right; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    /**
     * Create an array of random numbers.
     */
    public static int[] makeNums(int howMany) {
        int[] nums = new int[howMany];
    
        for (int i = 0; i < howMany; i += 1) {
            nums[i] = rnd.nextInt(MAX_RND_INT) + 1;
        }
        
        return nums;
    }

    /**
     * For random numbers uncomment the first line below
     *    and comment the second line.
     */
    public static void main(String[] args) {
        int[] nums = makeNums(MAX_NUMS);
        //int nums[] = {5,4,6,0,9,11,1,3,7,10,8,2};
        printArray(nums);
        System.out.println("  Sorting.....");
        quickSort(nums, 0, nums.length - 1);  
        printArray(nums);
        System.out.println("done");
    }
    
    /**
     * Print the array of int values, so many per line of output
     */
    public static void printArray(int[] nums) {
        int numCount = 0;
    
        for (int i = 0; i < nums.length; i += 1) {
            System.out.print(nums[i] + " ");
            numCount += 1;
    
            if (numCount == MAX_NUMS_PER_LINE) {
                numCount = 0;
                System.out.println();
            }
        }
        System.out.println();
    }
}
