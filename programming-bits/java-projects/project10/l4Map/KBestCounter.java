/*
 * Author: Carlos López 
 * UNI: cal2266
 * This class stores k or less best values of any object
 */
import java.util.PriorityQueue;
import java.util.List;
import java.util.*; 

public class KBestCounter<T extends Comparable<? super T>> {
    
    private PriorityQueue<T> heap;
    private int k; 
    
    public KBestCounter(int k) throws IllegalArgumentException{
       if(k <= 0)
           throw new IllegalArgumentException("K has to be larger than 0!");
       
       this.k = k;  
       heap =  new PriorityQueue<T>(k);
    }

    public void count(T x) {
        if(heap.size() < k)
          heap.add(x);
        else{
         if(x.compareTo(heap.peek()) > 0){
            heap.poll();
            heap.add(x);
        }
      }
   }
        
    public List<T> kbest() {
        int lengthL;
        LinkedList<T> s1 = new LinkedList<T>();
        LinkedList<T> temp = new LinkedList<T>();
        if(this.k >= heap.size())
            lengthL = heap.size();
        else
            lengthL = k;
        for(int j =lengthL; j>0; j--){
            s1.add(heap.peek());
            temp.add(heap.poll());
        }
        for(int i=0; i < s1.size(); i++)
            heap.add(temp.pop()); 
        return s1;
    }
    
}