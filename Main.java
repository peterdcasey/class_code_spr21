import java.util.Iterator;
import java.util.*;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        var list = new LnkedList<String>();
        list.add("Bob"); list.add("Teri"); list.add("Sam");
        System.out.println("List: " + list);
        Iterator<String> it = list.iterator();
        
        while (it.hasNext()) {
            System.out.println(it.next());
            //list.add("Ouch");
        }
        
        itEx();
    }
    
    public static void itEx() {
        List<Integer> list = List.of(1,2,3,4,5,6);
        var list2 = new ArrayList<>(list);
        
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            //it.remove();  //error
            System.out.println(it.next());
        }
        
        for (Iterator<Integer> it = list2.iterator(); it.hasNext(); ) {
            if (it.next() == 3) {
                it.remove();
            }
        }
        list.stream().forEach(System.out::println);
        System.out.println("====");
        list2.stream().forEach(System.out::println);
        
        try {
            int x = list2.get(340);
        }
        catch(Exception e) {
            System.out.println("ouch: " + e);
        }
        
    }
}
