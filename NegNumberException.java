
/**
 * Example custom exception
 *
 * extends Exception to create a checked exception
 * extends RuntimeException to create an unchecked exception
 */
public class NegNumberException extends RuntimeException
{
    // instance variables - replace the example below with your own
    private int arg;

    /**
     * Constructor for objects of class BadArg
     */
    public NegNumberException(int arg)
    {
        // initialise instance variables
        this.arg = arg;
    }

    public String toString() {
        return "Bad argument: " + arg + ", arg must be >= 0";
    }
}
