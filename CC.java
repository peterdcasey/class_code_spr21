import java.util.*;
import java.util.stream.Collectors.*;
import java.util.stream.Collectors;

/**
 * Simple on-the-fly example of Comparable and
 *     Comparator.
 *
 * @author Peter Casey
 * @version 0.1
 */
public class CC implements Comparable<CC>
{
  private String name;
  private int age;
  private double heightMM;
    
  public CC(String name, int age, double inches) {
      this.name = name;
      this.age = age;
      this.heightMM = inches * 25.4;
  }
  
  public String getName() {
      return name;
  }
  
  public double getHeight() {
      return heightMM;
  }
  
  public int getAge() {
      return age;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (! (other instanceof CC)) return false;
    return compareTo((CC)other) == 0;
  }

  @Override
  public int compareTo(CC other) {
    // Name compare <String>
    int result = this.name.compareTo(other.name);

    // If names the same, compare ages
    if (result == 0) {
      result = this.age - other.age;
    }

    // If names and ages same, compare heights
    if (result == 0) {
      result = (int)((long)this.heightMM * 100 -
                     (long)other.heightMM * 100);
    }

    return result;
  }

  public static final Random rnd = new Random();
  
  /**
   * Create a Comparator object that compares by
   *    age, then name, then height
   *    
   * Usage: Collections.sort(list, CC.ageSort);
   */
  public static final Comparator<CC> ageSort = new Comparator<>() {
      @Override
      public int compare(CC a, CC b) {         
        int result = a.age - b.age;
        
        if (result == 0) {
          result = a.name.compareTo(b.name);
        }

        if (result == 0) {
          if (a.heightMM > b.heightMM) result = 1;
          else if (a.heightMM < b.heightMM) result = -1;
          else result = 0;
        }

        return result;   
      }
  };

  @Override
  public String toString() {
    return name + " " + age + " " + heightMM;
  }

  // ===============================
  //  Test Code - Example run
  // ===============================
  public static void main(String[] args) {
    CC[] objects = { 
      new CC("Barb", 34, 71.4),
      new CC("Bill", 34, 61.4),
      new CC("Beth", 24, 61.4),
      new CC("Beth", 34, 61.4),
      new CC("Barb", 34, 61.4),
    };
    Arrays.sort(objects);
    System.out.println(Arrays.toString(objects));
    
    List<CC> list = new ArrayList<>(Arrays.asList(objects));
    // Use Comparable interface
    Collections.sort(list, Collections.reverseOrder());
    System.out.println(list);
    
    // Use Comparator object
    Collections.sort(list, CC.ageSort);
    System.out.println(list);
    
    list.stream()
            .filter(obj -> obj.getAge() < 30 || obj.getHeight() > 1800.0)
            .map(obj -> obj.getName())
            .map(obj -> obj.length())
            .forEach(System.out::println);
            
    int sum = list.stream()
            .filter(obj -> obj.getAge() < 30 || obj.getHeight() > 1800.0)
            .map(obj -> obj.getName())
            .map(obj -> obj.length())
            .reduce(0, (total, lengths) -> total + lengths);
    System.out.println("sum of name lengths is " + sum);
    
    List<String> names = list.stream()
            .filter(obj -> obj.getAge() < 30 || obj.getHeight() > 1800.0)
            .map(obj -> obj.getName())
            .collect(Collectors.toCollection(ArrayList::new));

    System.out.println(names);        
  }
  
  
}