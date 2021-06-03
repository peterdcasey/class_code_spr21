import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Write a description of class FileIOExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileIOExample
{
    public static void main(String[] args) {
        readFile("ssss");
    }
    
    public static void readFile(String name) {
        Files.lines(new File(name).toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .forEach(System.out::println);
    }
}
