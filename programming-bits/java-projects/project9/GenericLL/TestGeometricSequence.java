public class TestGeometricSequence {
  
  public static void main(String[] args){
    
    for (Double d : new GeometricSequence(1, 0.5,5 )) {
      System.out.println(d); // iterate through geometric sequence as if it were an array list (check how an array list is made )
    }
    
    /* 1.0
       0.5
       0.25
       0.125
       0.0625 
     */
  }
  
}