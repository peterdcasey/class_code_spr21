
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node<T>
{
    private T data;
    private Node<T> next;
    private Node<T> prev;
    
    public Node(T data) {
        this.data = data;
        next = null;
    }
    
    public void setNext(Node<T> node) {
        this.next = node;
    }
    
    public T getData() {
        return data;
    }
    
    public Node<T> getNext() {
        return next;
    }
}
