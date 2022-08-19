/* 
 *  * 
 * name: Carlos López 
 * UNI: cal2266
 * 
 */

public class RangeInput{
    // instance variables 
    private int currentValue;
    private int highValue;
    private int lowValue;
    //constructor
    public RangeInput(int high, int low){
      
      highValue = Math.max(high, low); 
      lowValue = Math.min(high, low);
      // This line of code allows the user to enter values in any order. 
      currentValue = (highValue + lowValue)/2;
      
        
    }
    
    public void up(){
        // this is a mutator method
        // that increases currentValue if allowed
        // your code here
      
      currentValue = currentValue + 1; 
      currentValue = Math.min(currentValue, highValue );
    }
    
    public void down(){
        // this is a mutator method
        // that decreases currentValue if allowed
        // your code here
      currentValue = currentValue - 1;
      currentValue = Math.max(currentValue, lowValue );
      
        
    }
    
    public int getCurrentValue(){
        // this is an accessor method 
        // your code here
      return currentValue;
        
    }
    
    
    
}
