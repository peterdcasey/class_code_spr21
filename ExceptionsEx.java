
/**
 * Exceptions Examples
 */
public class ExceptionsEx
{
    public static void main(String[] args) {
        Ex01 ex01 = null;
        
        try {
            ex01 = new Ex01(-1);
        }
        catch(Exception e) {
             System.out.println(e);
        }
        if (ex01 != null)
             System.out.println(ex01.num);
        
        
    }
    
    public static class Ex01 {
        public int num;
        
        /** num must be >= zero
         1) could default to zero if bad input
         2) throw an exception
           a) throw a RuntimeException   or
           b) throw an Exception
        */
        public Ex01(int num) { //throws NegNumberException {
            if (num < 0) {
                throw new NegNumberException(num);
            }
            this.num = num;        
        }
    } // end of Ex01
}
