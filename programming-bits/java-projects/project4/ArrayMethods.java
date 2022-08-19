/**
* ArrayMethods - Manipulate Array Contents
* 
* 
* author: Carlos López 
*
* UNI: cal2266
* 
* // 
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math.*; 
public class ArrayMethods {

    // private instance variables
    private int[] values;
    // this is for  resetting purposes, otherwise not needed
    private int[] originalValues; 

    //constructor
    public ArrayMethods(int[] initialValues) {
        values = initialValues;
        originalValues = Arrays.copyOf(values, values.length);
    }

    // pretty printing for testing purposes
    public void printArray() {
        for (int i : values) {
            System.out.print(i + " ");
    }
        System.out.println("");
    }
    
    // resetting back to original values for testing purposes
    public void resetValues() {
        values = Arrays.copyOf(originalValues, originalValues.length);
    }

    // *a. swap the first and last elements
    public void swapFirstAndLast() {
        // your code here
        int temp = values[0]; 
        values[0] = values[values.length - 1]; 
        values[values.length - 1] = temp;
	
    }

    // b.* shift all element to right and wraparound
    public void shiftRight() {
        // your code here  
        for(int i = 0; i < values.length - 1; i++){
            
            values[i + 1] = originalValues[i];    
        }
        
        values[0] = originalValues[originalValues.length-1];

    }

    // c. *replace even elements with zero
    public void replaceEven() {
        // your code here
        
        for(int j = 0; j < values.length; j++){
            
            if(values[j] % 2 == 0){
                values[j] = 0; 
            }
            
        }
        
    }

    // d. replace middle elements with larger of two neighbors
    public void replaceMiddle() {
        
        for(int j = 1; j < values.length-1; j++){
            values[j] = Math.max(originalValues[j-1], originalValues[j+1]);   
        }
       
      }  

    

 
    // e. Remove middle one or two elements
    public void removeMiddle(){
        int[] result; 
        boolean even = values.length % 2 == 0;
        int middle = values.length/2; 
            
        if(even) 
           result = new int[values.length -2]; 
        else 
           result = new int[values.length -1];
              
         for(int j = 0, k = 0; j < values.length; j++){
                 
            if(even && (j == middle || j == middle -1))
              continue;
            else if(!even && j == middle)
               continue;
            
            result[k] = values[j];
            k++;       
          }
        values = result; 
       }
                  
       
        
    
     

    

    // f. Move even elements to the front
    public void moveEven() {
        
        int cIndex = 0; // current size 
        int[] mEven = new int[values.length]; // new array to change values
        for( int element : values){
            if(element % 2 ==0){ // add the even values first 
                mEven[cIndex] = element;
                cIndex++;    
            }
        }
                
         for(int element : values){ // add the odd values second
                
             if( element % 2 != 0){
                 mEven[cIndex] = element; 
                 cIndex++; 
             }
             
             values = mEven; // values equals the modified array
              
            }  
        }


    // g. Return the value of the second-largest element
    public int secondLargest() {
        resetValues();
        Arrays.sort(values);
        int max = values[values.length-1]; 
        int secondLargest = values[0]; 
        for(int element : values){
            if(element < max && element > secondLargest)
                secondLargest = element;
        }
        return secondLargest; 

    }

    // h. Check if sorted in increasing order
    public boolean sortedIncreasing() {
        resetValues();
        Arrays.sort(values); 
        boolean sorted = true; 
        for(int j = 0; j < values.length -1; j++){
            if(values[j] != originalValues[j])
                sorted = false;      
        }
        
        return sorted; 
    }

    // i. Check if contains two adjacent duplicate elements
    public boolean adjacentDups() {
        resetValues();
        boolean adjacent = false; 
        for(int j = 0; j < values.length - 1; j++){
            if(values[j] == values[j+1])
                adjacent = true; 
        }
        
        return adjacent; 

    }

    // j. Check if contains any duplicate elements
    public boolean containsDups() {
        resetValues();
        boolean contain = false; 
        
        for(int j = 0; j < values.length - 2; j++ ){
            for(int k = j + 1; k < values.length - 1; k++){
                if(values[j] == values[k])
                    contain = true; 
            }
        
	}
      return contain; 
  }


    
}

