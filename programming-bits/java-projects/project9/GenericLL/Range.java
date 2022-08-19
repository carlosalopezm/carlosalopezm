import java.util.Iterator; 

/**
 *  A Range iterable that can be used to iterate over a sequence of integers
 *  (similar to Python's range function).
 */
public class Range implements Iterable<Integer> {
  // instance variables
  private int min; 
  private int max; 
  private int increment;
    
  private class RangeIterator implements Iterator<Integer> {
    
    /* We could also pass the instance variables in Range to the constructor
       of RangeIterator. The RangeIterator could then be a static nested
       class instead of an inner class. */
    
    int current = min;
    
    public boolean hasNext() {
     
      if (increment > 0) 
        return current < max;
      else
        return current > max;
    }
    
    public Integer next() {
      int result = current;
      current = current + increment;
      return result;
    }
    // not supported 
    public void remove() {
      throw new UnsupportedOperationException();
    }
    
  }
  public Range(int start, int stop, int step) {
    this.min = start;
    this.max = stop;
    this.increment = step;
  }
  
// returns new instance of range iterator 
  public Iterator<Integer> iterator() {
    return new RangeIterator();
  }
  
}

