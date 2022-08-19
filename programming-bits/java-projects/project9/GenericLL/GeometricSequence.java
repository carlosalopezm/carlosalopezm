/**
 * Author: Carlos López
 * UNI: cal2266
 * Description: This class generates a geometric series using the iterable interface.
 */

import java.util.Iterator; 
import java.io.*; 

/**
 * An iterable that produces the first steps terms of the geometric sequence
 * defined by an initial term and constant factor. 
 * @param   initialTerm     the initial term of the sequence 
 * @param   constantFactor  the constant factor of the sequence 
 * @param   steps           the number of terms to produce before iteration terminates. 
 */


public class GeometricSequence implements Iterable<Double> {
  // you probably need some variables here and an inner class.
  // private instance variables
  private double initialTerm; 
  private double constantFactor; 
  private int steps; 
  // private class to generate a GeometricSequenceIterator
  private class GeometricSequenceIterator implements Iterator<Double>{ 
    Double current = initialTerm;
    public boolean hasNext() {
     // check if the var steps is not negative
      if (steps > 0) 
        return true;
      else
        return false; // return false if negative
    }
    public Double next() {
      Double result = current;
      current = current * constantFactor;
      steps--; // steps are reduced so the sequence is finite
      return result;  
    }
    
    public void remove(){ 
      throw new UnsupportedOperationException();  // operation not supported    
    }  
  }
  
 // constructor for geometric sequence 
    
  public GeometricSequence(double initialTerm, double constantFactor, int steps) {
    
    this.initialTerm = initialTerm;
    this.constantFactor = constantFactor; 
    this.steps = steps; 
  }
  
  
  
// iterator returns a new instance of GeometricSequenceIterator()
 public Iterator<Double> iterator() {
    
    return new GeometricSequenceIterator(); 
    
    
    
  }
  
}


