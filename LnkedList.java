import java.util.Iterator;

/**
 * Write a description of class LnkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LnkedList<T> implements ILnkedList<T>
{
     private Node<T> start;
     private int size;
     
     public LnkedList() {
         start = null;
         size = 0;
     }
     
     /**
      * Add data to list, adds at the front;
      */
     @Override
     public void add(T data) {
         Node<T> node = new Node(data);
         node.setNext(start);
         start = node;
         size += 1;
     }
     
     public void addFirst(T data) {
         add(data);
     }
     
     /**
      * Remove the first item in the list and return it
      */
     public T removeFirst() {
        T data = null;
        
        if (size() > 0) {
            data = start.getData();
            Node<T> tmp = start;
            start = start.getNext();
            tmp.setNext(null);
            size -= 1;
        }
        
        return data;   
     }
     
     /**
      * Get the item at the index
      */
     public T get(int index) {
         T data = null;
         
         if (index < size && index >= 0) {
            Node<T> tmp = start;
            int count = 0;
            
            while (count < index) {
                tmp = tmp.getNext();
                count++;
            }
            
            data = tmp.getData();
         }
         
         return data;
     }
     
     /**
      * Return the number of items in the list
      */
     public int size() {
         return size;
     }
     
     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder("[");
         
         for (int i = 0; i < size(); i++) {
             System.out.println(i + " " + this.get(i));
             sb.append(this.get(i) + ", "); 
         }
         
         String result = sb.toString();
         
         if (size > 0) {
             result = result.substring(0, result.length() - 2);    
         }
         
         return result + "]";
     }
     
     /**
      * Reture an iterator over the list
      * If the list is changed during iteration
      *   an exception is thrown
      */
     public Iterator<T> iterator() {
         return new Iterator<T>() {
             private int index = 0;
             private int checkSize = size();
             
             public boolean hasNext() {
                 if (checkSize != size()) 
                    throw new java.util.ConcurrentModificationException();
                 return index < size();
             }
             
             public T next() {
                 T data = get(index);
                 index += 1;
                 return data;
             }
         };
     }
     
}
