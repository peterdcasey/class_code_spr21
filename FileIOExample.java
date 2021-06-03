import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

/**
 * Write a description of class FileIOExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileIOExample
{
    public static final Random rnd = new Random();
    
    public static void main(String[] args) {
        // iffy behavior ignoring an exception with empty catch(){}
        try { writeText("numbers.txt"); } catch(Exception e) { } // crash
        List<Integer> nums = readFile("numbers.txt");
        //List<String> nums = readFile("numbers.txt");
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
    }
    
    public static List<Integer> readFile(String name) {
    //public static List<String> readFile(String name) {
        List<Integer> numbers = null;
        //List<String> numbers = null;
        
        try {
            numbers = Files.lines(new File(name).toPath())
                            .map(s -> s.trim())
                            .filter(s -> !s.isEmpty())
                            .map(s -> Integer.parseInt(s))
                            .collect(Collectors.toList());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        return numbers;
    }
    
    public static void writeText(String name) throws IOException {
        try {
            PrintWriter fileout = new PrintWriter(new FileWriter(name));

            for (int i = 1; i <= 10; i++) {
                fileout.println(rnd.nextInt(100) + 1);
            }
            fileout.close();    // explicitly close the file!!!!
        } catch (IOException e) {
            e.printStackTrace();
            throw(e);
        }
 
    }
}
