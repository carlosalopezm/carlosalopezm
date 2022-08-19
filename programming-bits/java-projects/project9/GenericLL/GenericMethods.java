/**
 * Author: Carlos López
 * UNI: cal2266
 * Description: This class has 3 main methods an one helper method. 
 * The first two main methods find the index of the first occurrence of the maximum value of 
 * an array of generic types. The second method uses binary search to find a specific generic in an array of generics types. 
 */
public class GenericMethods {
/**
* The Method uses iteration to find the index of the largest integer in the array
* 
*/  
   
  public static <T extends Comparable<T>> int findMax(T[] arr) {
    
    if(arr.length == 0)
      return -1;
    if(arr.length == 1)
      return 0;
    int indexMax = 0;
    for(int j = 1; j < arr.length; j++){
        if(arr[indexMax].compareTo(arr[j]) < 0 )
          indexMax = j; 
    }
    return indexMax;  
  }
      
  /**
* The Method calls a  recursive helper method 
* to find the index of the largest integer in the specified array
* 
*/ 
  public static <T extends Comparable<T>> int findMaxRecursive(T[] arr) {
    if(arr.length == 0)
      return -1;
    // start at index zero 
    return findMaxRecursive(arr, 0,  0);
  }
/* The Method uses recursion 
* to find the index of the largest integer in the specified array
* 
*/  
  private static <T extends Comparable<T>> int findMaxRecursive(T[] arr, int maxIndex, int start){
    // index zero is used to only keep first occurrence of max value
    if(arr[maxIndex].compareTo(arr[start + 1]) < 0)
       maxIndex = start + 1;
    // since it compares i and i + 1 it stops at start +1    
    if(start + 1 == arr.length-1)
      return maxIndex; // returns max index until all the array elements are revised
    
    return findMaxRecursive(arr, maxIndex, start + 1);
     
  }
  
/* The Method calls a  recursive helper method 
* to find the index of the specified integer in the specified array
*/    
  
  public static <T extends Comparable<T>> int binarySearch(T[] arr, T x) {
    // check if list is empty 
    if(arr.length == 0) // empty array of objects 
      return -1; 
    return binarySearch(arr, x, 0, arr.length - 1); 
     
  }
  
  /* The Method uses recursion 
* to find the index of the specified integer in the specified array
* return -1 if not found 
*/ 
  private static <T extends Comparable<T>> int binarySearch(T[] arr, T x, int start, int end){  
    if(start > end)
      return -1; // check if start is greater than end 
    int middle = start + ((end - start)/2); 
    if(arr[middle].compareTo(x) == 0)
      return middle;
    else if(arr[middle].compareTo(x) < 0)
      return binarySearch(arr, x, middle +1 , end); 
    else
      return binarySearch(arr, x, start , middle - 1);
    
  }
  
  
  
  
}