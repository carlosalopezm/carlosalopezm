/*
 * Author: Carlos Lopez 
 * UNI: cal2266
 * Description: This class creates a queue with two stacks
 */ 
import java.util.NoSuchElementException;

public class TwoStackQueue<T> implements Queue<T> {

    private Stack<T> s1;
    private Stack<T> s2;
    
    public TwoStackQueue() {
        // write a constructor
      this.s1 = new ArrayStack();
      this.s2 = new ArrayStack();
    }
    
    public void enqueue(T x) {
        s1.push(x); 
      // replace this
    }
    
    public T dequeue() throws NoSuchElementException {
      if(this.isEmpty()){
        throw new NoSuchElementException();
      }
      if(s2.isEmpty() == true)
        while(s1.isEmpty() != true){
          s2.push(s1.pop());
        }
      
        return s2.pop();
      
       // replace this
    }
    
    public boolean isEmpty() {
      return s1.isEmpty() && s2.isEmpty();
    }
    
}