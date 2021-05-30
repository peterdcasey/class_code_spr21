
/**
 * Write a description of class Recursion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recursion
{
    public static void main(String[] args) {
        String s = rev("abcde");
        System.out.println(s);
        System.out.println(decimalToBinary(48));
    }
    
    public static String ex1(String s) {
        String r = "";
        
        for (int i = s.length() - 1; i >= 0; i--) {
            r = r + s.charAt(i);        
        }
        return r;
    }
    
    public static String rev(String s) {
        String r = "";
        
        if (s.length() < 2)  // base case
            r = s;
        else {
            int len = s.length();
            String letter = s.substring(len - 1);
            String substr = s.substring(0, len - 1);
            r = letter + rev(substr);  // recursive call
        }
        return r;
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
