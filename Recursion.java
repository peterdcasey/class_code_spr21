
/**
 * Recursive algorithms
 *  1) must call themselves in come fashion
 *  2) must have a base case that is NOT recursive!
 *  3) the recursive call must move toward the base case
 */
public class Recursion
{
    public static void main(String[] args) {
        String s = rev("abcde");
        System.out.println(s);
        System.out.println(decimalToBinary(48));
        System.out.println(ack(3,3));
        System.out.println(counter);
        counter = 0;
        System.out.println(fib(40));
        System.out.println(counter);
    }
    
    public static String ex1(String s) {
        String r = "";
        
        for (int i = s.length() - 1; i >= 0; i--) {
            r = r + s.charAt(i);        
        }
        return r;
    }
    private static long counter = 0;
    
    public static long ack(long m, long n) {
        counter++;
        if (m == 0) {
            return n + 1;
        }
        
        if (n == 0) {
            return ack(m - 1, 1);
        }
        
        return ack(m - 1, ack(m, n - 1));
    }
    
    public static String rev(String s) {
        String result = "";
        
        if (s.length() < 2)  // base case
            result = s;
        else {
            int len = s.length();
            String letter = s.substring(len - 1);
            String substr = s.substring(0, len - 1);
            result = letter + rev(substr);  // recursive call
        }
        return result;
    }
    
    public static long fib(int n) {
        counter++;
        
        if (n < 2) {
            return n;
        }
        
        return fib(n - 1) + fib(n - 2);
    }
    
    public static String decimalToBinary(int dec) {
        if (dec == 0)  // base case
            return "";
        else { // call recursively with a small number
            String digit = "" + (dec % 2);
            return decimalToBinary(dec / 2) + digit;
        }
    }
}
